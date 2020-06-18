package magentix2.code.agente; //paquete que contendra la implementacion del agente

import es.upv.dsic.gti_ia.core.ACLMessage;  //paquetes requeridos importados desde Magentix2
import es.upv.dsic.gti_ia.core.AgentID;
import es.upv.dsic.gti_ia.core.SingleAgent;

public class Receptor extends SingleAgent{ //Clase Receptor derivando de BaseAgent
	boolean gotMsg = false;
	public Receptor(AgentID aid) throws Exception {
		super(aid);      //Llamada al constructor de la clase BaseAgent por defecto
	}
	
	public void execute(){  //implementación del método execute para la clase Recepetor
		System.out.println("Soy el Agente: "+this.getName() + ". Estoy iniciando ejecución ..."); //mensaje de inicio
		ACLMessage msg = null;  //creación del objeto que implementa ACL(Agent Communication Language) que recibirá e mensaje
		try {
			msg = this.receiveACLMessage(); // recepción del mensjae enviao por el agente Emisor
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Soy el Agente "+this.getName() +". Estoy recibiendo este mensaje: "+msg.getContent());//mensaje recibido
	}
}

