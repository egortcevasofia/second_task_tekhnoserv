package service;

import entity.ResultEntity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteService {

    public void writeToFile( ArrayList<ResultEntity> resultList, String pathForWrite) {
        try (FileWriter writer = new FileWriter(pathForWrite, false)) {
            for (ResultEntity entity : resultList) {
                writer.write(entity.getId() + " " + entity.getValue1() + " " + entity.getValue2() + "\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }
}
