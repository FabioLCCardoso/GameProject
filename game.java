import javax.swing.JFrame; // Import the JFrame class

public class game {

    public static void main(String[] args) {
        // Create a new JFrame object
        JFrame frame = new JFrame("My First Window"); // Set the window title

        // Set the size of the window (width, height in pixels)
        frame.setSize(400, 300);

        // Specify what happens when the user closes the window
        // EXIT_ON_CLOSE terminates the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        frame.setVisible(true);
    }
}