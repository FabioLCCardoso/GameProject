package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Chest extends SuperObjects{

   public Obj_Chest(){
    name = "Chest";
        try{
        image = ImageIO.read(getClass().getResourceAsStream("/assets/chest.png"));
    }catch(
    IOException e){
        e.printStackTrace();
    }
} }
