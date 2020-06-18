import time
import asyncio
from spade.agent import Agent
from spade.behaviour import CyclicBehaviour

class AgentTest(Agent):
    class Comportamiento(CyclicBehaviour):              # clase para crear el comportamiento
        async def on_start(self):                       # método que inicia el comportamiento
            print("Iniciaindo comportamiento . . .")    # inicializar el contador en cero
            self.counter = 0

        async def run(self):                            # método de ejecucion ppal del comportamiento
            print("Contador: {}".format(self.counter))
            self.counter += 1
            if self.counter > 3:
                self.kill(exit_code=10)
                return
            await asyncio.sleep(1)
                                                        # incrementar en uno el contador
                                                        # poner un delay de 1 segundo para poder ver
                                                        # la ejecución  
        async def on_end(self):
            print("Comportamiento finalizado con código {}.".format(self.exit_code))                                                        

    async def setup(self):                              # método principal del Agente
        print("Iniciando el agente . . .")
        self.my_behav = self.Comportamiento()                               # obtener el comportamiento
        self.add_behaviour(self.my_behav)                           # asignar el comportamiento al agente

if __name__ == "__main__":
    dummy = AgentTest("alet149@404.city", "ejls9190")   # instanciar el agente y conectar con XMPP
    future = dummy.start()
    future.result()                                     # iniciar el agente

    while not dummy.my_behav.is_killed():         # mantener la ejecución hasta presionar CTRL+C
        try:
            time.sleep(1)
        except KeyboardInterrupt:
            break
    dummy.stop()                                        #detener el agente