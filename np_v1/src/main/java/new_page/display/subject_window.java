package new_page.display;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import org.json.simple.JSONArray;

import new_page.read_write.data;

public class subject_window extends JPanel{
    
    public data d;

    public Color tabCol;
    public String title;
    public JSONArray tasks;
    public JButton saveButton;
    public JColorChooser colorChooser;
    public JButton colorButton;

    public JButton nexButton;
    public JButton backButton;
    public JButton addButton;

    task task_boxes[];

    JTextField title_box;
    public subject_window(int pos){

        d = new data(pos);
        tabCol = d.get_col();
        title = d.get_title();
        tasks = d.get_tasks();
        this.setLayout(null);
        this.setBounds(200, 0, 500, 800);
        this.setBackground(colorMod(-5));

        task_boxes = new task[]{new task(tasks,0,colorMod(10),d),new task(tasks,1,tabCol,d)};


        saveButton = new JButton("save");
        saveButton.setBounds(425, 25, 50, 50);
        saveButton.setBorder(null);
        saveButton.setBackground(colorMod(10));
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i =0;i<task_boxes.length;i++){
                    task_boxes[i].saveFile(title_box.getText());
                }
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        title_box = new JTextField(title, 1);
        title_box.setBounds(100, 25, 300, 50);
        title_box.setBorder(null);
        title_box.setFont(new Font("ariel", Font.PLAIN, 30));
        title_box.setHorizontalAlignment(JTextField.CENTER);
        title_box.setBackground(colorMod(10));

        colorChooser = new JColorChooser(tabCol);
        colorChooser.setBounds(05, 85, 500, 500);
        colorChooser.setVisible(false);

        colorButton = new JButton("color");
        colorButton.setBounds(10, 25, 65, 50);
        colorButton.setBackground(colorMod(10));
        colorButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                if(colorChooser.isVisible()){
                    colorChooser.setVisible(false);
                    tabCol= colorChooser.getColor();
                    resetColors();
                }else{ colorChooser.setVisible(true);}
                
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });

        nexButton = new JButton(">");
        nexButton.setBounds(425, 725, 50, 50);
        nexButton.setBorder(null);
        nexButton.setBackground(colorMod(10));

        backButton = new JButton("<");
        backButton.setBounds(25, 725, 50, 50);
        backButton.setBorder(null);
        backButton.setBackground(colorMod(10));

        addButton = new JButton("+");
        addButton.setBounds(225, 725, 50, 50);
        addButton.setBorder(null);
        addButton.setBackground(colorMod(10));

        this.add(colorChooser);
        this.add(title_box);
        this.add(saveButton);
        this.add(colorButton);
        this.add(nexButton);
        this.add(backButton);
        this.add(addButton);
        
        for(int i = 0;i< task_boxes.length;i++){
            this.add(task_boxes[i]);
            //  System.out.println(i);
        }
        this.setVisible(false);
    }

    void resetColors(){
        this.setBackground(tabCol);
        colorButton.setBackground(colorMod(10));
        saveButton.setBackground(colorMod(10));
        title_box.setBackground(colorMod(10));
        d.saveColor(tabCol);
        for(int i =0;i< task_boxes.length;i++){
            task_boxes[i].setBackground(colorMod(20));
        }
    }
    Color colorMod(int mod_amount){
        int red = tabCol.getRed()-mod_amount;
        int green = tabCol.getGreen()-mod_amount;
        int blue = tabCol.getBlue()-mod_amount;

        if(red<0){red = 0;}else if(red>255){red=255;}
        if(green<0){green = 0;}else if(green>255){green=255;}
        if(blue<0){blue = 0;}else if(blue>255){blue=255;}
        Color out = new Color(red,green,blue);
        return out;
    }
}
