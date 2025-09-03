package main;

import javax.swing.JFrame; // Import the JFrame class

public class Main {
    public static void main(String[] args) {
        // Create a new JFrame object
        JFrame window = new JFrame(); // Set the window title
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Cumshots <3");

        PanelSettings panelSettings = new PanelSettings();
        window.add(panelSettings);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panelSettings.startGameThread();
    }
}