package main;

import objects.Obj_Chest;
import objects.Obj_Door;
import objects.Obj_Key;

public class AssetSetter {
    PanelSettings gp;

    public AssetSetter(PanelSettings gp) {
        this.gp = gp;

    }

    public void setObject(){

        gp.obj[0] = new Obj_Key();

        //ITEM POSITION (CHANGE LATER)
        gp.obj[0].worldX = 23 * gp.tileSize ;
        gp.obj[0].worldY = 7 * gp.tileSize ;

        gp.obj[1] = new Obj_Key();
        gp.obj[1].worldX = 23 * gp.tileSize ;
        gp.obj[1].worldY = 40 * gp.tileSize ;

        gp.obj[2] = new Obj_Key();
        gp.obj[2].worldX = 38 * gp.tileSize ;
        gp.obj[2].worldY = 8 * gp.tileSize ;

        gp.obj[3] = new Obj_Door();
        gp.obj[3].worldX = 10 * gp.tileSize ;
        gp.obj[3].worldY = 11 * gp.tileSize ;

        gp.obj[4] = new Obj_Door();
        gp.obj[4].worldX = 8 * gp.tileSize ;
        gp.obj[4].worldY = 28 * gp.tileSize ;

        gp.obj[5] = new Obj_Door();
        gp.obj[5].worldX = 12 * gp.tileSize ;
        gp.obj[5].worldY = 22 * gp.tileSize ;

        gp.obj[6] = new Obj_Chest();
        gp.obj[6].worldX = 10 * gp.tileSize ;
        gp.obj[6].worldY = 7 * gp.tileSize ;


    }
}
