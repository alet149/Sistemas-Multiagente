import robot.Agente;

   public class Program {
      public static void main( String args[] ) {
         Agente robot1 = new Agente("robbie");
         robot1.pintarParte((args.length==0) ? null : args[0] );
         System.exit(0);
      }
   }
