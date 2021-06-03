package src2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Client> clientTasks;
    private AtomicInteger waitingPeriod;

    public Server() {
        clientTasks = new LinkedBlockingQueue<>();
        waitingPeriod = new AtomicInteger();
    }

    public void addClient(Client newClient) // similar to addTask
    {
        clientTasks.add(newClient);
        waitingPeriod.addAndGet(newClient.gettService() );
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

   @Override
   public void run() {
       Client c;
      while(true)
      {
          if(!clientTasks.isEmpty()) {
              c = clientTasks.peek();
              while (c.gettService() > 0) {
                  Thread.currentThread();
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  c.decrementTService();
                  this.waitingPeriod.getAndDecrement();
              }
              clientTasks.remove();
          }
      }

   }
    public Client[] getClients()
    {
        Client[] clientArray = new Client[clientTasks.size()];
        int index = 0;
        for (Client c: clientTasks
             ) {
            clientArray[index] = c;
            index++;
        }
        return clientArray;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;

    }
}
