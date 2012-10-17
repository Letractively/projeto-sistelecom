package br.com.sistelecom.relatorio;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class InfoRelatorio<E> {
	
	private HttpServletRequest request; 
	private HttpServletResponse response; 
	private ServletContext contexto; 
	private Collection<E> colecao;
	private String caminhoDoArquivoDeRelatorio;
	private Map<String, Object> parametros;
	
	InfoRelatorio() {
	}

	/**
	 * @param request
	 * @param response
	 * @param contexto
	 * @param colecao
	 * @param caminhoDoArquivoDeRelatorio
	 * @param parametros
	 */
	public InfoRelatorio(HttpServletRequest request,
			HttpServletResponse response, ServletContext contexto,
			Collection<E> colecao, String caminhoDoArquivoDeRelatorio,
			Map<String, Object> parametros) {
		super();
		this.request = request;
		this.response = response;
		this.contexto = contexto;
		this.colecao = colecao;
		this.caminhoDoArquivoDeRelatorio = caminhoDoArquivoDeRelatorio;
		this.parametros = parametros;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public ServletContext getContexto() {
		return contexto;
	}

	public Collection<E> getColecao() {
		return colecao;
	}

	public String getCaminhoDoArquivoDeRelatorio() {
		return caminhoDoArquivoDeRelatorio;
	}

	public Map<String, Object> getParametros() {
		return parametros;
	}
	
}
