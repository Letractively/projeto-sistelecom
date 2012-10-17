package br.com.sistelecom.relatorio.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CAMINHO_RELATORIO_CLIENTE = "/recursos/arquivos/relatorios/jasper/animal.jasper";
   
    public ClienteServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
