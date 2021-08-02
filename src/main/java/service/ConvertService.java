package service;

import entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class ConvertService {

    public HashMap<Long, ArrayList<String>> convertToMap(ArrayList<Entity> listOfEntity) {
        HashMap<Long, ArrayList<String>> map = new HashMap<>();
        for (Entity entity : listOfEntity) {
            ArrayList<String> listOfString = map.getOrDefault(entity.getId(), new ArrayList<String>());
            listOfString.add(entity.getValue());
            map.put(entity.getId(), listOfString);

        }
        return map;
    }

}
