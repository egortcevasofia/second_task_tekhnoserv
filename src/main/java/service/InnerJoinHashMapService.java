package service;

import entity.ResultEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InnerJoinHashMapService {

    public ArrayList<ResultEntity> innerJoinMap(HashMap<Long, ArrayList<String>> firstMap, HashMap<Long, ArrayList<String>> secondMap) {
        ArrayList<ResultEntity> resultList = new ArrayList<>();
        for (Map.Entry<Long, ArrayList<String>> entry : firstMap.entrySet()) {
            Long id = entry.getKey();
            if (secondMap.containsKey(id)) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    for (int k = 0; k < secondMap.get(id).size(); k++) {
                        resultList.add(new ResultEntity(id, firstMap.get(id).get(i), secondMap.get(id).get(k)));
                    }

                }
            }

        }
        return resultList;
    }

}
