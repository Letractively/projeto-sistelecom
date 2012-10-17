package br.com.sistelecom.relatorio;

import javax.servlet.ServletOutputStream;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public final class SistelecomRelatorio {

	public static <E> void gerarRelatorio(final InfoRelatorio<E> ier) throws Exception{
		final JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(ier.getColecao());  
		
		final String caminhoDoArquivoJasper = ier.getContexto().getRealPath(ier.getCaminhoDoArquivoDeRelatorio());
		
		final JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoDoArquivoJasper, ier.getParametros(), beanCollectionDataSource);  
		
		final byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);
		
		ier.getResponse().addHeader("Content-disposition", "attachment; filename=relatorio.pdf");
		ier.getResponse().setContentType("application/pdf");
		
		ServletOutputStream saida = ier.getResponse().getOutputStream();
		saida.write(pdf);
		saida.flush();
		saida.close();
	}
}
