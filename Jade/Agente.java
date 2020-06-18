package jade.code;
import jade.core.Agent;

public class Agente extends Agent{
	private static final long serialVersionUID = 1L;
	protected void setup(){
		System.out.println("soy el agente de prueba " + getAID().getName()); //mostrar nombre del agente
		Object[] args = getArguments();										 //Obtener los par�metros recibidos
		if (args != null) {
			 System.out.println("Estos son mis argumentos");				 //Imprimir los par�metros recibidos
			 for (int i = 0; i < args.length; ++i) {
			 System.out.println("- "+args[i]);
			 }
			} 

		//doDelete();															 //ordenar la finalizaci�n al Agente
	}

}