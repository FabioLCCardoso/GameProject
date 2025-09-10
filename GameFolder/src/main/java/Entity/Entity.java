package Entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed;

   //sprite animation variables
    public BufferedImage[] up, down, left, right;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 0;
}
