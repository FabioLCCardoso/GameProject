package objects;

import main.PanelSettings;

import java.awt.*;
import java.awt.image.BufferedImage;

//parent class for all objects
public class SuperObjects {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw(Graphics2D g2d, PanelSettings gp){

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
            g2d.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
