package service;

import entity.Entity;
import entity.ResultEntity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class InnerJoinLinkedListService {
    public ArrayList<ResultEntity> innerJoinLinkedList(LinkedList<Entity> firstList, LinkedList<Entity> secondList) {
        int count = 1;
        ArrayList<ResultEntity> resultList = new ArrayList<>();
        ListIterator firstIterator = firstList.listIterator();
        ListIterator secondIterator = secondList.listIterator();
        while (firstIterator.hasNext()) {
            Entity firstEntity = (Entity) firstIterator.next();
            while (secondIterator.hasNext()) {
                Entity secondEntity = (Entity) secondIterator.next();


                if (firstEntity.getId() < secondEntity.getId()) {
                    while (count > 0) {
                        secondIterator.previous();
                        count = count - 1;
                    }
                    count = 1;
                    System.out.println(firstEntity.getId() + " " + secondEntity.getId());
                    break;//Здесь происходит firstIterator.next();
                }

                if (firstEntity.getId().equals(secondEntity.getId())) {

                    resultList.add(new ResultEntity(firstEntity.getId(), firstEntity.getValue(), secondEntity.getValue()));
                    count++;
                    System.out.println(firstEntity.getId() + " " + secondEntity.getId());

                }

                if (!secondIterator.hasNext()) {
                    while (count > 0) {
                        secondIterator.previous();
                        count = count - 1;
                    }
                    count = 1;
                    break;
                }

            }

        }

        return resultList;
    }


}
