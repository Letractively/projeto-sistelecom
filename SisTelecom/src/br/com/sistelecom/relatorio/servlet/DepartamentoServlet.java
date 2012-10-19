package br.com.sistelecom.relatorio.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistelecom.dao.DepartamentoDAOImpl;
import br.com.sistelecom.entidade.relatorio.DepartamentoRelatorio;
import br.com.sistelecom.relatorio.InfoRelatorio;
import br.com.sistelecom.relatorio.SistelecomRelatorio;

public class DepartamentoServlet extends HttpServlet {
	
	private static final String CAMINHO_RELATORIO_DEPARTAMENTO = "/jasper/departamento.jasper";
	private static final long serialVersionUID = 1L;
	
    public DepartamentoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<DepartamentoRelatorio> colecao = new DepartamentoDAOImpl().listarParaRelatorio();
		
		InfoRelatorio<DepartamentoRelatorio> info = new InfoRelatorio<DepartamentoRelatorio>(request, response,this.getServletContext(), colecao, CAMINHO_RELATORIO_DEPARTAMENTO, null);
		
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
