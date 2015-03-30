package com.pentaho.report;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.pentaho.reporting.engine.classic.core.modules.output.pageable.pdf.PdfReportUtil;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceCreationException;
import org.pentaho.reporting.libraries.resourceloader.ResourceException;
import org.pentaho.reporting.libraries.resourceloader.ResourceKeyCreationException;
import org.pentaho.reporting.libraries.resourceloader.ResourceLoadingException;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;



public class GeneratePentahoReport {

	public static void main(String[] args) {
		ClassicEngineBoot.getInstance().start();
		ResourceManager manager = new ResourceManager();
		URL reportURL = null;
		MasterReport report = null;
		manager.registerDefaults();
		Resource resource;
		try {
			reportURL = new URL("file:input/Employee-Division.prpt");
			System.out.println("reportURL " + reportURL.getPath());
			resource = manager.createDirectly(reportURL, MasterReport.class);
			report = (MasterReport) resource.getResource();
			PdfReportUtil.createPDF(report, "output\\Employee-Division.pdf");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (ResourceLoadingException e) {
			e.printStackTrace();
		} catch (ResourceCreationException e) {
			e.printStackTrace();
		} catch (ResourceKeyCreationException e) {
			e.printStackTrace();
		} catch (ResourceException e) {
			e.printStackTrace();
		} catch (ReportProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {

		}
		System.out.println("Done........");
	}
}
