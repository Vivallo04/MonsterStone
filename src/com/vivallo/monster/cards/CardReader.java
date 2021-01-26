package com.vivallo.monster.cards;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface CardReader {


    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    JSONParser parser = new JSONParser();

    public static void readFile() throws Exception {

       try {

           Object obj = parser.parse(new FileReader("cards.json"));
           JSONObject jsonObject = (JSONObject) obj;
           String name = (String) jsonObject.get("name");
           System.out.println("Name is:" + name);

           String id = (String) jsonObject.get("id");
           System.out.println("ID is: " + id);


           //Loop Array
           JSONArray array = (JSONArray) jsonObject.get("");
           Iterator<String> iterator = array.iterator();

           while (iterator.hasNext()) {
               System.out.println("");
           }


       } catch (FileNotFoundException e) {
           logger.log(Level.SEVERE, "Couldn't find \"cards.json\" file");

       } catch (Exception e) {
            e.printStackTrace();
       }
    }

}
