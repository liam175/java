package new_page.read_write;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class settings {

    public JSONObject settings_json = new JSONObject();

    public settings() {
        try {
            Object o = new JSONParser().parse(new FileReader("C:\\Users\\lostl\\OneDrive\\Documents\\code\\java\\n" + //
                    "p_v1\\src\\main\\java\\n" + //
                    "ew_page\\read_write\\settings.json"));
            settings_json = (JSONObject) o;
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    int pull_int(String var) {
        int out = -1;
        long in = (long) settings_json.get(var);
        out = (int) in;
        return out;
    }

    public int[] get_xy(int buffer, int width, int height) {
        int[] out = { 0, 0 };

        switch (pull_int("position")) {
            case 0:
                out = new int[] { buffer, buffer };
                break;
            case 1:
                out = new int[] { 1920 - buffer - width, buffer };
                break;
            case 2:
                out = new int[] { 1920 - buffer - width, 1080 - buffer - height };
                break;
            case 3:
                out = new int[] { buffer, 1080 - height - buffer };
                break;
        }
        return out;
    }

    public Color get_col(String var) {
        int[] buff = { 255, 0, 255 }; // will return magenta if the pull messes up

        JSONArray j_array = (JSONArray) settings_json.get("cover_color");

        buff[0] = (int) (long) j_array.get(0);
        buff[1] = (int) (long) j_array.get(1);
        buff[2] = (int) (long) j_array.get(2);

        return new Color(buff[0],buff[1],buff[2]);
    }
}
