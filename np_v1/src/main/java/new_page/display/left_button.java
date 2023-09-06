package new_page.display;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class left_button extends JButton{
    subject_window window;

    public left_button(int pos){
        window = new subject_window(pos);

        this.setBounds(0, pos*100, 200, 100);
        this.setFont(new Font("ariel", Font.PLAIN, 30));
        this.setBorder(null);
        this.setText(window.title);
        this.setBackground(window.tabCol);
    }
    
}
