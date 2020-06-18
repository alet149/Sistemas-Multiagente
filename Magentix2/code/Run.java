package magentix2.code; //paquete que contendra la implementacion del agente

import org.apache.log4j.Logger;				//paquetes requeridos importados desde Magentix2
import org.apache.log4j.xml.DOMConfigurator;
import es.upv.dsic.gti_ia.core.AgentID;
import es.upv.dsic.gti_ia.core.AgentsConnection;

import magentix2.code.agente.*;

public class Run {
	public static void main(String[] args) {						//clase principal
		DOMConfigurator.configure("configuration/loggin.xml");		//carga del fichero loggin.xml con la configuración por defecto de Magentix2
		Logger logger = Logger.getLogger(Run.class);

		AgentsConnection.connect("localhost", 5672, "test", "guest","guest", false); // conexión con el broker de comunicación
		try {
			Emisor emisor = new Emisor(new AgentID("EmisorName"));			//creación de la instancia del agente Emisor
			Receptor receptor = new Receptor(new AgentID("ReceptorName"));  //creación de la instancia del agente Receptor
			emisor.start();			//inicio del agente Emisor
			receptor.start();		//inicio del agente Receptor
		 } catch (Exception e) {
			 logger.error("Error " + e.getMessage());
		 }
	}
}
