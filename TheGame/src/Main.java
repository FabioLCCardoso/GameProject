import javax.swing.JFrame; // Import the JFrame class

public class Main {

    public static void main(String[] args) {
        // Create a new JFrame object
        JFrame frame = new JFrame("Cumshots <3"); // Set the window title

        // Set the size of the window (width, height in pixels)
        frame.setSize(800, 600);

        // Specify what happens when the user closes the window
        // EXIT_ON_CLOSE terminates the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        frame.setVisible(true);
    }
}