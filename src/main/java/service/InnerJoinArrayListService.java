package service;

import entity.Entity;
import entity.ResultEntity;

import java.util.ArrayList;

public class InnerJoinArrayListService {

    public ArrayList<ResultEntity> innerJoinArray(ArrayList<Entity> firstList, ArrayList<Entity> secondList) {
        ArrayList<ResultEntity> resultList = new ArrayList<>();
        for (int i = 0; i < firstList.size(); i++) {
            for (int j = 0; j < secondList.size(); j++) {
                if (firstList.get(i).getId().equals(secondList.get(j).getId())) {
                    resultList.add(new ResultEntity(firstList.get(i).getId(),
                            firstList.get(i).getValue(),
                            secondList.get(j).getValue()));
                }
            }
        }
        return resultList;
    }
char c = 123;


}
