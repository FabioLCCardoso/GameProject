package Entity;

import main.PanelSettings;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Player extends Entity {

    PanelSettings gp;
    KeyHandler keyH;

    public Player(PanelSettings gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage(){
        up = setupImage("/assets/MC_UP.png", 3);
        down = setupImage("/assets/MC_DOWN.png", 3);
        right = setupImage("/assets/MC_RIGHT.png", 2);
        left = setupImage("/assets/MC_LEFT.png", 2);

    }

    public BufferedImage[] setupImage(String imagePath, int numSprites){
        BufferedImage[] images = new BufferedImage[numSprites];
        try{
            InputStream is = getClass().getResourceAsStream(imagePath);
            if (is == null) {
                System.err.println("Error: Could not find resource at path: " + imagePath);
                return images;
            }
            BufferedImage sheet = ImageIO.read(is);
            int expectedWidth = numSprites * 16;
            if(sheet.getWidth() != expectedWidth){
                System.err.println("Error: Image at " + imagePath + " is too narrow.");
                System.err.println("Expected width >= " + expectedWidth + ", but actual width is " + sheet.getWidth());
                return images;
            }

            for(int i = 0; i < numSprites; i++){
                // each sprite is 16x16
                images[i] = sheet.getSubimage(i*16 , 0, 16, 16);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }

    public void update(){
    boolean isMoving = keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed ;
     if(isMoving) {
         if (keyH.upPressed) {
             direction = "up";
             y -= speed;
         }
       else  if (keyH.downPressed) {
             direction = "down";
             y += speed;
         }
       else  if (keyH.leftPressed) {
             direction = "left";
             x -= speed;
         }
       else  if (keyH.rightPressed) {
             direction = "right";
             x += speed;
         }

         //animation counter
         spriteCounter++;
         if (spriteCounter > 10) {
             spriteNum++;
             //reset left/right sprites
             int maxSprites = 2;
             if (direction.equals("up") || direction.equals("down")) {
                 maxSprites = 3;
             }
             if (spriteNum >= maxSprites) {
                 spriteNum = 0;
             }
             spriteCounter = 0;
             //reset to idle frame
     }
         } else {
             spriteNum = 0; }

    }
    public void draw(Graphics2D g2d) {
      /*  g2d.setColor(Color.white);

        g2d.fillRect(x, y, gp.tileSize, gp.tileSize);*/

        BufferedImage image = null;

        switch(direction){
            case "up": image = up[spriteNum];
            break;
            case "down": image = down[spriteNum];
            break;
            case "right":
                if (spriteNum >= right.length) {
                    spriteNum = 0;
                }
                image = right[spriteNum];
            break;
            case "left":
                if (spriteNum >= left.length) {
                    spriteNum = 0;
                }
                image = left[spriteNum];
            break;

        }
       if(image != null){
        g2d.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
    }
}
