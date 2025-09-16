package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Door extends SuperObjects {

    public Obj_Door() {

        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/door_closed.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
