package br.com.sistelecom.bean;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import br.com.sistelecom.dao.RamoDAOImpl;
import br.com.sistelecom.entity.Ramo;
import br.com.sistelecom.to.RamoTO;

public class RamoController extends Controller<Ramo> {

	private Ramo ramo;
	private List<RamoTO> lista;
	
	public RamoController() {
		this.carregarDadosNaTela();
	}
	
	@Override
	public void carregarDadosNaTela() {
		if(this.getLista() == null){
			this.listarTodos();
		}
	}
	
	@Override
	public void novoRegistro(ActionEvent evento) {
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
	
	@Override
	public void listarTodos() {
		this.lista = new LinkedList<RamoTO>();
		this.setLista(this.getDao().todosRamosParaExibirEmTabela());
	}
	
	@Override
	public void carregarRegistro(ActionEvent evento) {
		int idRamo = this.getRamo().getIdRamo();

		final Ramo ramo = this.getDao().obterPorId(idRamo);

		this.getRamo().setIdRamo(ramo.getIdRamo());
		this.getRamo().setNomeRamo(ramo.getNomeRamo());
	}
	
	@Override
	public void excluirRegistro(ActionEvent actionEvent) {
		int idRamo = this.getRamo().getIdRamo();
		
		final Ramo ramo = this.getDao().obterPorId(idRamo);
		try {
			this.getDao().excluir(ramo);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(e.getMessage()));
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Ramo excluído com sucesso."));
	}
	
	@Override
	public boolean validarDadosFormulario() {
		if (this.getRamo().getNomeRamo().equals("")) {
			
			return false;
		}
		return true;
	}
	
	@Override
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
