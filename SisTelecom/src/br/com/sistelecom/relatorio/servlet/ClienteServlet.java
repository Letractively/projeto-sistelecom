package br.com.sistelecom.relatorio.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistelecom.entidade.relatorio.ClienteRelatorio;
import br.com.sistelecom.relatorio.InfoRelatorio;
import br.com.sistelecom.relatorio.SistelecomRelatorio;


public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CAMINHO_RELATORIO_CLIENTE = "/jasper/cliente.jasper";
   
    public ClienteServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<ClienteRelatorio> colecao = new ArrayList<ClienteRelatorio>();
		
		colecao.add(new ClienteRelatorio(1, "José Roberto"));
		colecao.add(new ClienteRelatorio(2, "Danilo"));
		colecao.add(new ClienteRelatorio(3, "Lucas"));
		
		InfoRelatorio<ClienteRelatorio> info = new InfoRelatorio<ClienteRelatorio>(request, response,this.getServletContext(), colecao, CAMINHO_RELATORIO_CLIENTE, null);
		
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
