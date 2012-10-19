package br.com.sistelecom.relatorio.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistelecom.dao.ProdutoDAOImpl;
import br.com.sistelecom.entidade.relatorio.ProdutoRelatorio;
import br.com.sistelecom.relatorio.InfoRelatorio;
import br.com.sistelecom.relatorio.SistelecomRelatorio;
public class ProdutoServlet extends HttpServlet {

	private static final String CAMINHO_RELATORIO_PRODUTO = "/jasper/produto.jasper";
	private static final long serialVersionUID = 1L;
       
    public ProdutoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<ProdutoRelatorio> colecao = new ProdutoDAOImpl().listarParaRelatorio();
		
		InfoRelatorio<ProdutoRelatorio> info = new InfoRelatorio<ProdutoRelatorio>(request, response,this.getServletContext(), colecao, CAMINHO_RELATORIO_PRODUTO, null);
		
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
