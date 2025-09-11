package Tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.PanelSettings;

import javax.imageio.ImageIO;

public class TileManager {

    PanelSettings gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(PanelSettings gp) {
        this.gp = gp;

        tile = new Tile[10]; //10 kinds of tiles (CHANGE LATER)
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/worldmap01.txt");
    }

    //maps and sprites are just placeholders for now!!
    public void getTileImage(){

        try{
        tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/assets/grass.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/assets/brick.png"));
            tile[1].collision = true;
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/assets/water.png"));
            tile[2].collision = true;
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/assets/dirt.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/assets/tree.png"));
            tile[4].collision = true;
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/assets/sand.png"));



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadMap(String filePath){
        try{
        InputStream is = getClass().getResourceAsStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int col = 0;
        int row = 0;
        while(col < gp.maxWorldCol && row < gp.maxWorldRow){

            String line = br.readLine();
        //This scans the txt file tile by tile (col to col, after 16 cols it descends to next row and repeat)
            while(col < gp.maxWorldCol){
                String numbers[] = line.split(" ");

                int num = Integer.parseInt(numbers[col]);

                mapTileNum[col][row] = num;
                col++;
            }
            if(col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }
        br.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void draw(Graphics2D g2d){
       /* g2d.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2d.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2d.drawImage(tile[2].image, 96, 0, gp.tileSize, gp.tileSize, null); */

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            //render only visible tiles
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                g2d.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            worldCol ++;


            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
