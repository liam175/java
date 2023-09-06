package new_page.read_write;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class data{
    static String address = "C:\\Users\\lostl\\OneDrive\\Documents\\code\\java\\np_v1\\src\\main\\java\\new_page\\read_write\\data.json";

    JSONObject data_json;
    JSONArray subject;

    public data(int p){
        try {
            Object o = new JSONParser().parse(new FileReader(address));
            data_json = (JSONObject) o;
            JSONArray subjects = (JSONArray) data_json.get("subjects");
        
            subject = (JSONArray) subjects.get(p);
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }

    public String get_title(){
        try{
        return (String)subject.get(0);
        }catch(Exception e){
            return "null";
        }
    }

    public Color get_col(){
        try{
        JSONArray color_array = (JSONArray) subject.get(1);
        Color out = new Color((int)(long) color_array.get(0),(int)(long) color_array.get(1),(int)(long) color_array.get(2));
        return out;
        }catch(Exception e){
            return new Color(255, 0, 255);
        }
    }

    public JSONArray get_tasks() {
        try{
            return (JSONArray) subject.get(2);
        }catch(Exception e){
             return null;
        }
    }
    public void saveColor(Color c){
         JSONArray color_array = new JSONArray();
         color_array.add(0, c.getRed());
         color_array.add(1, c.getGreen());
         color_array.add(2, c.getBlue());
        subject.remove(1);
        subject.add(1, color_array);
        
         try (FileWriter file = new FileWriter(address))
            {
                file.write(data_json.toString());
                System.out.println("Successfully updated json object to file...!!");
            }catch (Exception e) {
                
            }
    }
    public void save_tasks(JSONArray newTasks, String title){
        subject.remove(2);
        subject.add(2, newTasks);
        subject.remove(0);
        subject.add(0, title);
        //data_json.replace("subjects", subject);
        System.out.println(newTasks);
        try (FileWriter file = new FileWriter(address))
            {
                file.write(data_json.toString());
                System.out.println("Successfully updated json object to file...!!");
            }catch (Exception e) {
                
            }
    }
}
