package service;

import entity.Entity;
import exception.IdNotValidException;
import exception.StringNotValidException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class ReadAndValidateService {

    public ArrayList<Entity> readToArrayList(String path) {
        ArrayList<Entity> listOfEntity = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            int numberOfLine = 0;
            System.out.println("Строки в которых обнаружена ошибка, не учитываются при объединении.\n");
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                if (isValid(words, ++numberOfLine)) {
                    Long id = Long.parseLong(words[0]);
                    String value = words[1];
                    Entity entity = new Entity(id, value);
                    listOfEntity.add(entity);
                }
            }
        } catch (IOException e) {
            System.out.println("Произошла проблема при прочтении файла");
        }
        return listOfEntity;
    }


    private Boolean isValid(String[] words, int numberOfLine) {
        try {
            if (words.length != 2)
                throw new StringNotValidException(String.format("В строке %s более или менее 2-х параметров", numberOfLine));
            if (words[0].trim().isEmpty())
                throw new StringNotValidException(String.format("В строке %s ID пустое", numberOfLine));
            if (words[1].trim().isEmpty())
                throw new StringNotValidException(String.format("В строке %s значение пустое", numberOfLine));
            if (Long.parseLong(words[0]) <= 0)
                throw new IdNotValidException(String.format("В строке %s в поле ID отрицательное число", numberOfLine));

        } catch (NumberFormatException e) {
            System.out.println(String.format("В строке %s в поле ID записано не числовое значение или дробное число", numberOfLine));
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}




