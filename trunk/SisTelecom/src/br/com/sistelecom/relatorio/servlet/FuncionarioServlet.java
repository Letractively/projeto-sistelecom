package br.com.sistelecom.relatorio.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistelecom.dao.FuncionarioDAOImpl;
import br.com.sistelecom.entidade.relatorio.FuncionarioRelatorio;
import br.com.sistelecom.relatorio.InfoRelatorio;
import br.com.sistelecom.relatorio.SistelecomRelatorio;

public class FuncionarioServlet extends HttpServlet {
	private static final String CAMINHO_RELATORIO_FUNCIONARIO = "/jasper/funcionario.jasper";
	private static final long serialVersionUID = 1L;
       
    public FuncionarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Collection<FuncionarioRelatorio> colecao = new FuncionarioDAOImpl().listarParaRelatorio();
		
		InfoRelatorio<FuncionarioRelatorio> info = new InfoRelatorio<FuncionarioRelatorio>(request, response,this.getServletContext(), colecao, CAMINHO_RELATORIO_FUNCIONARIO, null);
		
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
