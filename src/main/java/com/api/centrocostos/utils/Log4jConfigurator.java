package com.api.centrocostos.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

public class Log4jConfigurator implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {

		// String workspaceDirectory =
		// event.getServletContext().getRealPath("/").replace("\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\EfvServerOauth",
		// "");

		// Concatena la ruta relativa del directorio de logs
		String logsDirectoryPath = "/var/log/apiCentroCostos" + "/" + "logs";
		System.out.println("Ruta del directorio de logs: " + logsDirectoryPath);

		// Crea el directorio si no existe
		File logsDirectory = new File(logsDirectoryPath);
		if (!logsDirectory.exists()) {

			if (logsDirectory.mkdirs()) {
				System.out.println("Directorio de logs creado en: " + logsDirectory.getAbsolutePath());
			} else {
				System.err.println("Error al crear el directorio de logs.");
			}
		}

		// Configuración de Log4j
		System.out.println("Que es esta vaina: " + event.getServletContext().getRealPath("/"));
		String log4jConfigFile = event.getServletContext().getRealPath("/") + "WEB-INF/classes/log4j.properties";
//		// Obtener la fecha actual
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String currentDate = dateFormat.format(new Date());
//		Logger logger = Logger.getRootLogger();
//		DailyRollingFileAppender appender = new DailyRollingFileAppender();
//		appender.setFile("/var/log/apiCentroCostos/logs/ApiCentroCostos-" + currentDate + ".log");
//		appender.setLayout(new PatternLayout("%d [%-2p][%c{1}.%M (%L)] %m%n"));
//		logger.addAppender(appender);
		PropertyConfigurator.configure(log4jConfigFile);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// Aquí puedes realizar tareas de limpieza al cerrar la aplicación, si
		// es
		// necesario.
	}

}
