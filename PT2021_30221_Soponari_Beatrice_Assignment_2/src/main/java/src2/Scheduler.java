package src2;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers = new ArrayList<>();
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;
    public Scheduler(int maxNoServers, int maxTasksPerServer)
    {
        this.maxNoServers = maxNoServers;
        this.maxTasksPerServer = maxTasksPerServer;
        for(int i = 0;i < maxNoServers;i++) {
            servers.add(new Server());
            Thread thread = new Thread(servers.get(i));
            thread.start();
        }
    }
    public void changeStrategy(SelectionPolicy policy)
    {
        if(policy == SelectionPolicy.SHORTEST_QUEUE)
        {
            strategy = new ConcreteSTrategyQueue();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME)
        {
            strategy = new ConcreteSTrategyTime();
        }
    }
    public void dispatchClient(Client c) //dispatchTask
    {
        strategy.addClient(servers,c);
    }
    public List<Server> getServers()
    {
        return servers;
    }
}
