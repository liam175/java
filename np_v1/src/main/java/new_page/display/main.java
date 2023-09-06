package new_page.display;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import new_page.read_write.settings;

public class main {

    public JFrame frame;

    settings i_settings = new settings();

    variables vars = new variables(i_settings);

    left_button[] buttons = {new left_button(0)};

    public main(){               
        frame = new JFrame("New Page");
        new_display(true);
        for(int i = 0;i<buttons.length;i++){
            frame.add(buttons[i]);
            frame.add(buttons[i].window);
        }
    }
    

    public void display_dimension(boolean state){
        int width;
        if(state){
            width = vars.dimensions[1];
        }else{
            width = vars.dimensions[3];
        }

        int[] position = i_settings.get_xy(vars.dimensions[0],width,vars.dimensions[2]);

        frame.getContentPane().setBackground(vars.cover_color);
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, width, vars.dimensions[2], 100, 100));
        frame.setSize(width, vars.dimensions[2]);
        frame.setLocation(position[0], position[1]);
    }

    public void new_display(boolean state) {//weather the book is open or not
        frame.dispose();
        display_dimension(state);
        frame.setVisible(true);        
    }
}
