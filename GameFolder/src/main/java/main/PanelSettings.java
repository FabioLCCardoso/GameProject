package main;

import Entity.Player;

import javax.swing.JPanel;
import java.awt.*;

public class PanelSettings extends JPanel implements Runnable{

    //Screen settings
    final int originalSize = 16; //16x16
    final int scale = 3;

    public final int tileSize = originalSize * scale; //48x48
    final int maxScreenCol = 18;
    final int maxScreenRow = 14;
    final int screenWidth = tileSize * maxScreenCol; //768 px
    final int screenHeight = tileSize * maxScreenRow;  //576 px
    final int second = 1000000000;

    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);



    //player's default position

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    //constructor
    public PanelSettings() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.blue);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override

    // sleep method
   /*  public void run() {

        double drawInterval = second / FPS; // 1 second / 60 || 0.016666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread !=null){
            // IN 30 FPS this will happen 30 times per second
           //UPDATE: update information

            update();
            // DRAW: draw the screen with updated info
            repaint();

            try{

            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime / 1000000;

            if(remainingTime < 0){
                remainingTime = 0;
            }
            Thread.sleep((long) remainingTime);

            nextDrawTime += drawInterval;

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    } */

        //delta method
    public void run() {

        double drawInterval = second / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= second) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

   public void update() {
        player.update();
   }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);

        g2d.dispose();
    }
}
