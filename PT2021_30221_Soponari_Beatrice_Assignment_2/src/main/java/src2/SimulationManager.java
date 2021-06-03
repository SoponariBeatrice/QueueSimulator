package src2;//import src.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.*;

public class SimulationManager implements Runnable{
    public int timeLimit;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int numberOfServers;
    public int numberOfClients;
    public int maxArrivalTime;
    public int minArrivalTime;
    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
    private Scheduler scheduler;
    private SimulationFrame simulationFrame;
    private List<Client> generatedClients;
    private GUI gui = new GUI();
    private int start = 0;

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public synchronized void setValuesFromGUI(){

        gui.enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String st = gui.simulationTimeText.getText();
                timeLimit = Integer.parseInt(st);
                String nc = gui.clientNumberText.getText();
                numberOfClients = Integer.parseInt(nc);
                String qn = gui.queuesNumberText.getText();
                numberOfServers = Integer.parseInt(qn);
                String tminp = gui.minServiceTimeText.getText();
                minProcessingTime = Integer.parseInt(tminp);
                String tmaxp = gui.maxServiceTimeText.getText();
                maxProcessingTime = Integer.parseInt(tmaxp);
                String aMaxTime = gui.maxArrivalTimeText.getText();
                maxArrivalTime = Integer.parseInt(aMaxTime);
                String aMinTime = gui.minArrivalTimeText.getText();
                minArrivalTime = Integer.parseInt(aMinTime);
                scheduler = new Scheduler(numberOfServers,3);
                generateNRandomClients();
                start = 1;
                simulationFrame.simulationFrame.setVisible(true);
                gui.frame.dispatchEvent(new WindowEvent(gui.frame,WindowEvent.WINDOW_CLOSING));
            }
        });
    }
    public SimulationManager()
    {
        //scheduler = new Scheduler(numberOfServers,numberOfClients);
        simulationFrame = new SimulationFrame();
    }

    public synchronized void  generateNRandomClients() //generateNRandomTasks
    {
        Controller c = new Controller();
        c.clients = numberOfClients;
        c.simulationInterval = timeLimit;
        c.minServiceTime = minProcessingTime;
        c.maxServiceTime = maxProcessingTime;
        c.minArrivalTime = minArrivalTime;
        c.maxArrivalTime = maxArrivalTime;
        generatedClients = c.generateRandomClients();
        for (Client index:generatedClients
        ) {
            System.out.println(index.getID() + " " + index.gettArrival() + " " + index.gettService());
        }
        Collections.sort(generatedClients);
    }
    @Override
    public void run() {
       while(start == 0) {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       int currentTime = 0;
            while(currentTime < this.timeLimit)
            {
                Iterator<Client> c = generatedClients.iterator();
               while(c.hasNext()){
                   Client nextClient = c.next();
                   if(currentTime == nextClient.gettArrival())
                    {
                        scheduler.changeStrategy(selectionPolicy);
                        scheduler.dispatchClient(nextClient);
                        c.remove();
                        simulationFrame.panel.add(simulationFrame.txt);
                        simulationFrame.simulationFrame.add(simulationFrame.panel);
                        simulationFrame.simulationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                }
                try {
                    simulationFrame.updateFrame(currentTime,generatedClients,scheduler,numberOfServers);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    simulationFrame.writer.write(simulationFrame.txt.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                currentTime++;
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        try {
            simulationFrame.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


