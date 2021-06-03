package src2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class  ConcreteSTrategyTime implements Strategy {
    @Override
    public void addClient(List<Server> serverList, Client client) {
        AtomicInteger minWaitingTime = new AtomicInteger(0);
        int serverIndex = 0;
        int index = 0;
        minWaitingTime.addAndGet(Integer.MAX_VALUE);
        for (Server s : serverList
            ) {
                if(s.getWaitingPeriod().intValue() < minWaitingTime.intValue())
                {
                    minWaitingTime = s.getWaitingPeriod();
                    serverIndex = index;
                }
                index++;
            }
        serverList.get(serverIndex).addClient(client);

    }
}
