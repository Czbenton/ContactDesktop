package sample;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zach on 9/13/16.
 */
public class JsonMethods {

    public static void writeJson(String fileNAme, List contact) throws IOException {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(contact);

        File f = new File(fileNAme);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

}
