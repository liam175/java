package new_page.display;
import java.awt.Color;

import new_page.read_write.settings;

public class variables {
    public int[] dimensions = {10,700,800,400};//buffer width, width, height, closed width
    public Color cover_color;
    variables(settings s){
        cover_color = s.get_col("cover_color");
    }
}
