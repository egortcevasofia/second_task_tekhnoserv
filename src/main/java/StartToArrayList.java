import entity.Entity;
import entity.ResultEntity;
import service.*;

import java.util.ArrayList;

public class StartToArrayList {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Неверно заданы пути для файлов чтения и записи," +
                    " в параметры необходимо передать три пути к расположению файлов:" +
                    " первый и второй - пути для считывания, третий - для записи");
            return;
        }
        ReadAndValidateService readAndValidateService = new ReadAndValidateService();
        InnerJoinArrayListService innerJoinArrayListService = new InnerJoinArrayListService();
        InnerJoinLinkedListService innerJoinLinkedListService = new InnerJoinLinkedListService();
        InnerJoinHashMapService innerJoinHashMapService = new InnerJoinHashMapService();
        ConvertService convertService = new ConvertService();
        WriteService writeService = new WriteService();

        /**В конфигурацию необходимо передать следующие пути к файлам в заданом порядке
        1. Файл для считывания №1
        2. Файл для считывания №2
        3. Файл для записи для ArrayList/HashMap/LinkedList
         Выполнять программу строго для одного варианта, не нужные варианты можно заккоментировать
         */

        ArrayList<Entity> firstList = readAndValidateService.readToArrayList(args[0]);
        ArrayList<Entity> secondList = readAndValidateService.readToArrayList(args[1]);

//        ArrayList<ResultEntity> resultListArray = innerJoinArrayListService.innerJoinArray(firstList, secondList);
//        writeService.writeToFile(resultListArray, args[2]);

//        ArrayList<ResultEntity> resultListMap = innerJoinHashMapService.innerJoinMap(convertService.convertToMap(firstList),
//                convertService.convertToMap(secondList));
//        writeService.writeToFile(resultListMap, args[2]);

        ArrayList<ResultEntity> resultListLinked = innerJoinLinkedListService.innerJoinLinkedList(convertService.convertToLinkedList(firstList),
                convertService.convertToLinkedList(secondList));
        writeService.writeToFile(resultListLinked, args[2]);




    }
}
