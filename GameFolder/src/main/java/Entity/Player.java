package Entity;

import main.PanelSettings;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity {

    PanelSettings gp;
    KeyHandler keyH;

    public Player(PanelSettings gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 6;


    }
    public void update(){
        if (keyH.upPressed) {
            y -= speed;
        }
        if (keyH.downPressed) {
            y += speed;
        }
        if (keyH.leftPressed) {
            x -= speed;
        }
        if (keyH.rightPressed) {
            x += speed;
        }
    }
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.white);

        g2d.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
