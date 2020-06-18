package magentix2.code.agente; //paquete que contendra la implementacion del agente

import es.upv.dsic.gti_ia.core.AgentID;  //paquetes requeridos importados desde Magentix2
import es.upv.dsic.gti_ia.core.BaseAgent;
import es.upv.dsic.gti_ia.core.ACLMessage;

public class Emisor extends BaseAgent { //Clase Emisor derivando de BaseAgent

	public Emisor(AgentID id) throws Exception {
		super(id);  // lamada al constructor de la clase BaseAgent por defecto
	}
	
	public void execute(){  //implementación del método execute para la clase Emisor
		System.out.println("Soy el Agente: "+this.getName() +". Estoy emitiendo un mensaje ...");  //mensaje de inicio
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM); //creación del objeto que implementa ACL(Agent Communication Language)
		msg.setSender(this.getAid()); //adicionando un sender al mensaje
		msg.addReceiver(new AgentID("ReceptorName")); //adicionando un Receiver o suscriptor de los mensajes
		msg.setContent("MENSAJE DE PRUEBA DESDE EL EMISOR"); // mensaje generado por el Emisor
		this.send(msg); // enviando el emnsaje
	}

}
