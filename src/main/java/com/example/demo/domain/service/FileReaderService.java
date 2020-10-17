package com.example.demo.domain.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class FileReaderService {

    private final String FILE_PATH = "test.csv";

    public void read() {
        try {
            // FirstTypeDtoにCSVのデータをマッピング
            System.out.println("--- FirstTypeDtoにCSVのデータをマッピング ---");
            this.parse("com.example.demo.dto.FirstTypeDto");

            System.out.println();

            // SecondTypeDtoにCSVのデータをマッピング
            System.out.println("--- SecondTypeDtoにCSVのデータをマッピング ---");
            this.parse("com.example.demo.dto.SecondTypeDto");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> void parse(String className) throws IOException {
        FileReader fileReader;
        try {
                fileReader = new FileReader(new ClassPathResource(FILE_PATH).getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        CSVReader reader = new CSVReader(fileReader);

        Class type;
        try {
            // 引数で受け取ったクラス名からClassを定義
            type = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            reader.close();
            return;
        }

        // Iteratorのクラス名は相称型(T)で定義した上で
        // CsvToBeanBuilder#withType に該当するクラスを設定
        Iterator<T> iterator = new CsvToBeanBuilder(reader)
            .withType(type)
            .withSeparator(',')
            .build()
            .iterator();

        while (iterator.hasNext()) {
            T dto = iterator.next();
            System.out.println(dto.getClass());
            System.out.println(dto);
        }
    }

}
