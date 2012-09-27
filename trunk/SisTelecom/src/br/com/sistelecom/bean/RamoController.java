/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.com.sistelecom.dao.RamoDAOImp;
import br.com.sistelecom.entity.Ramo;
import br.com.sistelecom.interfaces.dao.RamoDAO;
import br.com.sistelecom.to.RamoTO;

/**
 * 
 * @author Danilo Alves
 */
public class RamoController extends Bean {

	private Ramo ramo;
	private List<RamoTO> listaDeTodosOsRamos;
	private static final RamoDAO RAMO_DAO = new RamoDAOImp();

	@Override
	public String novoRegistro() {

		if (validarDadosFormulario()) {
			RAMO_DAO.salvar(this.getRamo());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Ramo incluído com sucesso."));
		}

		return null;
	}

	@Override
	public String listarTodos() {
		this.listaDeTodosOsRamos = new LinkedList<RamoTO>();
		this.setListaDeTodosOsRamos(new RamoDAOImp()
				.todosRamosParaExibirEmTabela());
		return "listagem";
	}

	@Override
	public String carregarRegistro() {
		int id = this.getRamo().getIdRamo();

		final Ramo ramo = RAMO_DAO.procurarIdRamo(id);

		this.getRamo().setIdRamo(ramo.getIdRamo());
		this.getRamo().setNomeRamo(ramo.getNomeRamo());

		return "alteracao";
	}

	@Override
	public boolean validarDadosFormulario() {

		if (this.getRamo().getNomeRamo().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Informe o nome do ramo."));
			return false;
		}
		return true;
	}

	public Ramo getRamo() {
		if (this.ramo == null) {
			this.ramo = new Ramo();
		}
		return ramo;
	}

	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}

	public List<RamoTO> getListaDeTodosOsRamos() {
		return listaDeTodosOsRamos;
	}

	public void setListaDeTodosOsRamos(List<RamoTO> listaDeTodosOsRamos) {
		this.listaDeTodosOsRamos = listaDeTodosOsRamos;
	}

}
