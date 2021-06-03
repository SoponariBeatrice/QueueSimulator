package src2;

import java.util.Collections;
import java.util.ArrayList;
public class Client implements Comparable<Client>{
    int ID;
    int tArrival;
    int tService;
    int finishTime;
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int gettArrival() {
        return tArrival;
    }

    public void settArrival(int tArrival) {
        this.tArrival = tArrival;
    }

    public int gettService() {
        return tService;
    }

    public void settService(int tService) {
        this.tService = tService;
    }
    @Override
    public int compareTo(Client c){
       if(this.gettArrival() > c.gettArrival())
           return 1;
       else if(this.gettArrival() < c.gettArrival())
           return -1;
       else
           return 0;
    }
    public void decrementTService()
    {
        this.tService--;
    }
}
