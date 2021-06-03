package src2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationFrame {
    JFrame simulationFrame = new JFrame();
    JPanel panel = new JPanel();
    JTextArea txt = new JTextArea();
    File myFile = new File("output.txt");
    Writer wr;
    {
        try {
            wr = new FileWriter(myFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedWriter writer = new BufferedWriter(wr);
    public SimulationFrame(){
        simulationFrame.setSize(500,500);
        txt.setColumns(40);
        simulationFrame.setLayout(new BorderLayout());
        txt.setBounds(40,40,40,40);
        panel.setSize(40,100);
        panel.setLayout(new BorderLayout());
        panel.add(txt);
        simulationFrame.add(panel);
        simulationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void updateFrame(int time, List<Client> generatedClients, Scheduler scheduler, int queueNr) throws IOException {
        txt.setText("TIME " + time + "\n");
        //writer.write(txt.getText());
        if(time == 0 )
        {
            for(int i = 0; i < queueNr; i++)
            {
                txt.setText(txt.getText() + "Coada " + i + ": " +"\n");
            }
                    for (Client c: generatedClients
                    ) {
                        txt.setText(txt.getText() + "(" + c.getID() + "," + c.gettArrival() + "," + c.gettService() + ")" + " ");
                    }
            txt.setText(txt.getText() + "\n");
        }
        else
        {
            if(scheduler.getServers() != null)
            {
                for(int i = 0; i < queueNr;i++)
                {
                    txt.setText(txt.getText() + "Coada " + i + ": " );
                    for(int j = 0; j < scheduler.getServers().get(i).getClients().length;j++)
                    {
                           Client[] arrClient = scheduler.getServers().get(i).getClients();
                           txt.setText(txt.getText() + "(" + arrClient[j].getID()+ " " + arrClient[j].gettArrival() + " " + arrClient[j].gettService() + ") ");

                    }
                    txt.setText(txt.getText() + "\n");
                }
            }
        }
    }

}
