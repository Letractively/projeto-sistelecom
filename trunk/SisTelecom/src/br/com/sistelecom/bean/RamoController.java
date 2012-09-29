package br.com.sistelecom.bean;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.ajax4jsf.component.html.HtmlActionParameter;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import br.com.sistelecom.dao.RamoDAOImpl;
import br.com.sistelecom.entity.Ramo;
import br.com.sistelecom.to.RamoTO;

public class RamoController implements Controller<Ramo> {

	private Ramo ramo;
	private List<RamoTO> lista;
	
	public RamoController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().salvar(this.getRamo());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Ramo incluído com sucesso."));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(e.getMessage()));
				return;
			}
		}
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<RamoTO>();
		this.setLista(this.getDao().todosRamosParaExibirEmTabela());
	}
	
	public void carregarRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idRamo = Integer.parseInt(id);

		final Ramo ramo = this.getDao().obterPorId(idRamo);

		this.getRamo().setIdRamo(ramo.getIdRamo());
		this.getRamo().setNomeRamo(ramo.getNomeRamo());
	}
	
	public void atualizarRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().atualizar(this.getRamo());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Ramo atualizado com sucesso."));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Erro na alteração do ramo."));
				return;
			}
		}
	}
	
	public void salvar(ActionEvent evento) {
		if(this.getRamo().getIdRamo() == 0){
			this.novoRegistro();
		}else{
			this.atualizarRegistro();
		}
	}
	
	public void excluirRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idRamo = Integer.parseInt(id);
		
		final Ramo ramo = this.getDao().obterPorId(idRamo);
		try {
			this.getDao().excluir(ramo);
			this.listarTodos();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Ramo excluído com sucesso."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Erro na exclusão do ramo."));
			e.printStackTrace();
		}
	}
	
	public boolean validarDadosFormulario() {
		if (this.getRamo().getNomeRamo() == null || this.getRamo().getNomeRamo().equals("")) {
			return false;
		}
		return true;
	}
	
	public RamoDAOImpl getDao() {
		return new RamoDAOImpl();
	}
	
	/**
	 * @return the ramo
	 */
	public Ramo getRamo() {
		if (this.ramo == null) {
			this.ramo = new Ramo();
		}
		return ramo;
	}

	/**
	 * @param ramo the ramo to set
	 */
	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}

	/**
	 * @return the lista
	 */
	public List<RamoTO> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<RamoTO> lista) {
		this.lista = lista;
	}
	
}
