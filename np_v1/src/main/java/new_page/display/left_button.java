package new_page.display;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class left_button extends JButton{
    subject_window window;

    public left_button(int pos){
        window = new subject_window(pos);
        

        this.setBounds(0, pos*100, 200, 100);
        this.setFont(new Font("ariel", Font.PLAIN, 30));
        this.setBorder(null);
        this.setText(window.title);
        changeColor();

        window.colorButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                changeColor();
            }
            
        });
        if(pos==0){
            window.setBounds(200, 0, 500, 800);
            window.setVisible(true);
        }
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(true);
            }
            
        });
    }
    void changeColor(){
        this.setBackground(window.colorMod(10));
    }
}
