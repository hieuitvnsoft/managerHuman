/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

/**
 *
 * @author AnhHieu
 */
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class PdfFromXmlFile {

    public void ExportSalary() throws JRException, IOException {

        // Compile jrxml file.
        JasperReport jasperReport = JasperCompileManager
                .compileReport("F:/C1608I/II/Java/Sw1/QLNS_DA/src/Jasperreport/StyledTextReport.jrxml");

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        // DataSource
        // This is simple example, no database.
        // then using empty datasource.
        JRDataSource dataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters, dataSource);

        // Make sure the output directory exists.
        File outDir = new File("F:/C1608I/II/Java/Sw1/QLNS_DA/src/Jasperreport");
        outDir.mkdirs();

        // Export to PDF.
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "F:/C1608I/II/Java/Sw1/QLNS_DA/src/Jasperreport/StyledTextReport.pdf");

        System.out.println("Done!");
    }
}
