package src2;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public JFrame frame = new JFrame();
    public JPanel mainPanel = new JPanel();
    public JLabel simulationTimeLabel = new JLabel("Timul simularii");
    public JLabel clientNumberLabel = new JLabel("Numarul de clienti");
    public JLabel queuesNumberLabel = new JLabel("Numarul de cozi");
    public JLabel minArrivalTimeLabel = new JLabel("Timpul minim de sosire");
    public JLabel maxArrivalTimeLabel = new JLabel("Timpul maxim de sosire");
    public JLabel minServiceTimeLabel = new JLabel("Timpul minim de procesare");
    public JLabel maxServiceTimeLabel = new JLabel("Timpul maxim de procesare");
    public JLabel insertDataLabel = new JLabel("Introduceti datele simularii");
    public JTextField simulationTimeText  = new JTextField(25);
    public JTextField clientNumberText = new JTextField(25);
    public JTextField queuesNumberText = new JTextField(25);
    public JTextField minArrivalTimeText = new JTextField(25);
    public JTextField maxArrivalTimeText = new JTextField(25);
    public JTextField minServiceTimeText = new JTextField(25);
    public JTextField maxServiceTimeText = new JTextField(25);
    public JButton enterButton = new JButton("Enter");
    public int simulationTime, clientNr, queueNr, minArrTime, maxArrTime, minProcessTime, maxProcessTime;
    public void makePanel(JPanel p, JTextField t,JLabel l)
    {
        p.setLayout(new FlowLayout());
        p.add(l);
        p.add(t);
    }
    public void GUI() {
        frame.setSize(500, 500);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel p0 = new JPanel();
        p0.add(insertDataLabel);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        makePanel(p1, simulationTimeText, simulationTimeLabel);
        makePanel(p2, clientNumberText, clientNumberLabel);
        makePanel(p3, queuesNumberText, queuesNumberLabel);
        makePanel(p4, minArrivalTimeText, minArrivalTimeLabel);
        makePanel(p5, maxArrivalTimeText, maxArrivalTimeLabel);
        makePanel(p6, minServiceTimeText, minServiceTimeLabel);
        makePanel(p7, maxServiceTimeText, maxServiceTimeLabel);
        mainPanel.add(p0);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(p1);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(p2);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(p3);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(p4);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(p5);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(p6);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(p7);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(enterButton);
        frame.add(mainPanel);
        frame.setVisible(true);

    }
}
