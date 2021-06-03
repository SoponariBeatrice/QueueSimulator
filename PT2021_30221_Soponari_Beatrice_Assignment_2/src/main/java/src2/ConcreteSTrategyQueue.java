package src2;

import java.util.List;

public class ConcreteSTrategyQueue implements Strategy {
    @Override
    public void addClient(List<Server> serverList, Client client) {
        int minClientNumber = Integer.MAX_VALUE;
        int index = 0;
        int indexServer = 0;
        for (Server s : serverList
             ) {
            if(s.getClients().length < minClientNumber)
            {
                minClientNumber = s.getClients().length;
                indexServer = index;
            }
            index++;
        }
        serverList.get(indexServer).addClient(client);
    }
}
