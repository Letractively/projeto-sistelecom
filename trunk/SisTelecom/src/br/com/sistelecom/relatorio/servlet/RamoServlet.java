package br.com.sistelecom.relatorio.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistelecom.dao.RamoDAOImpl;
import br.com.sistelecom.entidade.relatorio.RamoRelatorio;
import br.com.sistelecom.relatorio.InfoRelatorio;
import br.com.sistelecom.relatorio.SistelecomRelatorio;

public class RamoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String CAMINHO_RELATORIO_RAMO = "/jasper/ramo.jasper";

	public RamoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<RamoRelatorio> colecao = new RamoDAOImpl().listarParaRelatorio();
		
		InfoRelatorio<RamoRelatorio> info = new InfoRelatorio<RamoRelatorio>(request, response,this.getServletContext(), colecao, CAMINHO_RELATORIO_RAMO, null);
		
		try {
			SistelecomRelatorio.gerarRelatorio(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
