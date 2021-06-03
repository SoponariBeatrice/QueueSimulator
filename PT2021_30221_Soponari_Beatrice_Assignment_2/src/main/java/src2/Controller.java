package src2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Controller {
    int clients;
    int queues;
    int simulationInterval;
    int minArrivalTime;
    int maxArrivalTime;
    int minServiceTime;
    int maxServiceTime;
    public void readFile()
    {
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\Beatrice\\Desktop\\tema2TP\\src\\Input.txt"));
            String line = reader.readLine();
            int counter = 0;
            while(line != null)
            {
                if(counter == 0)
                {
                    clients = Integer.parseInt(line);
                }
                else
                    if(counter == 1)
                    {
                        queues = Integer.parseInt(line);
                    }
                else
                    if(counter == 2)
                    {
                        simulationInterval = Integer.parseInt(line);
                    }
                else
                    if(counter == 3)
                    {
                        String[] strArray = line.split(" ",2);
                        minArrivalTime = Integer.parseInt(strArray[0]);
                        maxArrivalTime = Integer.parseInt(strArray[1]);
                    }
                else
                    if(counter == 4)
                    {
                        String[] strArray = line.split(" ",2);
                        minServiceTime = Integer.parseInt(strArray[0]);
                        maxServiceTime = Integer.parseInt(strArray[1]);
                    }
                line = reader.readLine();
                counter++;
            }
            reader.close();
        }catch(IOException e)
        {
            System.out.println("Error at reading file");
        }
    }
    public ArrayList<Client> generateRandomClients()
    {
        ArrayList<Client> clientList = new ArrayList<>();
        for(int i = 0;i < clients;i++)
        {
            Client c = new Client();
            c.setID(i+1);
            Random randArrivalTime = new Random();
            Random randServiceTime = new Random();
            int aTime,sTime;
            aTime = randArrivalTime.nextInt(maxArrivalTime);
            sTime = randServiceTime.nextInt(maxServiceTime);
            if(aTime < minArrivalTime)
                aTime += minArrivalTime;
            if(sTime < minArrivalTime)
                sTime += minArrivalTime;
            if(aTime == 0)
                aTime++;
            if(sTime == 0)
                sTime++;
            c.settArrival(aTime);
            c.settService(sTime);
            clientList.add(c);
        }
        return clientList;
    }
}
