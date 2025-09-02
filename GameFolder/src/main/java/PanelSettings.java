import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class PanelSettings extends JPanel implements Runnable{

    //Screen settings
    final int originalSize = 16; //16x16
    final int scale = 3;

    final int tileSize = originalSize * scale; //48x48
    final int maxScreenCol = 18;
    final int maxScreenRow = 14;
    final int screenWidth = tileSize * maxScreenCol; //768 px
    final int screenHeight = tileSize * maxScreenRow;  //576 px

    Thread gameThread;

    //constructor
    public PanelSettings() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {


    }
}
