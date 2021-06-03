package src2;

public class Main {
    public static void main(String[] args)
    {
        GUI g = new GUI();
        g.GUI();
        SimulationManager s = new SimulationManager();
        s.setGui(g);
        s.setValuesFromGUI();
        Thread thread = new Thread(s);
        thread.start();
    }
}
