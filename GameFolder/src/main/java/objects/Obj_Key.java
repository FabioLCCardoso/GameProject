package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Key extends SuperObjects{
 //constructor
   public Obj_Key(){
        name = "Key";
        try{
        image = ImageIO.read(getClass().getResourceAsStream("/assets/key.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
