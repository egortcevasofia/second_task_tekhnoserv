package service;

import entity.Entity;

import java.util.*;

public class ConvertService {
    private Comparator<Entity> comparator = (e1, e2) -> e1.getId().compareTo(e2.getId());


    public HashMap<Long, ArrayList<String>> convertToMap(ArrayList<Entity> listOfEntity) {
        HashMap<Long, ArrayList<String>> map = new HashMap<>();
        for (Entity entity : listOfEntity) {
            ArrayList<String> listOfString = map.getOrDefault(entity.getId(), new ArrayList<String>());
            listOfString.add(entity.getValue());
            map.put(entity.getId(), listOfString);

        }
        return map;
    }

    public LinkedList<Entity> convertToLinkedList(ArrayList<Entity> listOfEntity){
        LinkedList<Entity> linkedListOfEntity = new LinkedList<>(listOfEntity);
        linkedListOfEntity.sort(comparator);
        return linkedListOfEntity;
    }




}
