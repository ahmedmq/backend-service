package com.sawami.backendservice.report;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemReportService {

	private final DataSource dataSource;

	public void downloadItemSummaryReport(HttpServletResponse httpServletResponse) throws SQLException, JRException, IOException {

		Map<String, Object> parameters = new HashMap<>();
		InputStream itemSummaryReportStream = getClass().getResourceAsStream("/item_summary_report_initial.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(itemSummaryReportStream);
		JasperPrint jasperPrint =
				JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());

		String itemSummaryTitle = "Item Summary Report";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		var dateTimeNow = LocalDateTime.now().format(formatter);
		var fileName = itemSummaryTitle.replace(" ", "_") + dateTimeNow;

		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(httpServletResponse.getOutputStream()));
		httpServletResponse.setContentType("application/pdf");
		httpServletResponse.setHeader(
				HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + ".pdf;");
		exporter.exportReport();

	}
}
