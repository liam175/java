package new_page.display;

import java.awt.Color;

import java.awt.Font;

import java.awt.font.TextAttribute;

import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.json.simple.JSONArray;

import new_page.read_write.data;

public class task extends JPanel {

    public JTextField name;
    public JTextArea description;
    public JCheckBox checkBox;
    public JTextField dueDate;

    public JSONArray this_task;

    Font basic = new Font("ariel", Font.PLAIN, 15);
    Font basic_striked;

    data save_data;

    JSONArray root;

    int taskNum;

    task(JSONArray jArray, int task_num, Color color, data d) {
        this.setBounds(05, 100 + 190 * task_num, 490, 180);
        this.setBackground(color);
        this.setLayout(null);

        try {
            save_data = d;

            taskNum = task_num;

            root = jArray;

            this_task = (JSONArray) jArray.get(task_num);

            Map fontAttr = basic.getAttributes();
            fontAttr.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            basic_striked = new Font(fontAttr);

            name = new JTextField((String) this_task.get(0), 1);
            name.setBounds(5, 5, 320, 50);
            name.setBorder(null);
            name.setHorizontalAlignment(JTextField.CENTER);
            name.setFont(new Font("ariel", Font.PLAIN, 30));

            description = new JTextArea((String) this_task.get(1));

            if ((boolean) this_task.get(2)) {
                description.setFont(basic_striked);
            } else {
                description.setFont(basic);
            }

            description.setBounds(5, 65, 420, 110);
            description.setLineWrap(true);
            description.setBorder(null);

            checkBox = new JCheckBox("", (boolean) this_task.get(2));
            checkBox.setBounds(435, 65, 50, 110);
            checkBox.setBorder(null);

            dueDate = new JTextField((String) this_task.get(3), 1);
            dueDate.setBounds(340, 5, 145, 50);
            dueDate.setBorder(null);

            this.add(name);
            this.add(dueDate);
            this.add(description);
            this.add(checkBox);

        } catch (Exception e) {

        }
    }

    void saveFile(String title) {
        this_task.clear();
        this_task.add(0, name.getText());
        this_task.add(1, description.getText());
        this_task.add(2, checkBox.isSelected());
        this_task.add(3, dueDate.getText());
        root.remove(taskNum);
        root.add(taskNum, this_task);
        save_data.save_tasks(root, title);
        // System.out.println(description.getWidth());
    }
}
