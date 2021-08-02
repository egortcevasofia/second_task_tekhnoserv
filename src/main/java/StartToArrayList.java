import entity.Entity;
import entity.ResultEntity;
import service.*;

import java.util.ArrayList;

public class StartToArrayList {
    public static void main(String[] args) {
        InnerJoinArrayListService innerJoinArrayListService = new InnerJoinArrayListService();
        ReadAndValidateService readAndValidateService = new ReadAndValidateService();
        InnerJoinHashMapService innerJoinHashMapService = new InnerJoinHashMapService();
        ConvertService convertService = new ConvertService();
        WriteService writeService = new WriteService();

        /**В конфигурацию необходимо передать следующие пути к файлам в заданом порядке
        1. Файл для считывания №1
        2. Файл для считывания №2
        3. Файл для записи для ArrayList
        4. Файл для записи для HashMap
        5. файл для записи для LinkedList(Пока не реализовано)*/

        ArrayList<Entity> firstList = readAndValidateService.readToArrayList(args[0]);
        ArrayList<Entity> secondList = readAndValidateService.readToArrayList(args[1]);

        ArrayList<ResultEntity> resultListArray = innerJoinArrayListService.innerJoinArray(firstList, secondList);
        writeService.writeToFile(resultListArray, args[2]);

        ArrayList<ResultEntity> resultListMap = innerJoinHashMapService.innerJoinMap(convertService.convertToMap(firstList),
                convertService.convertToMap(secondList));
        writeService.writeToFile(resultListMap, args[3]);

    }
}
