package com.example.demo.dto;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FirstTypeDto implements Serializable{

    private static final long serialVersionUID = 1L;

    // 名前
    @CsvBindByPosition(position = 0)
    private String name;

    // 年齢
    @CsvBindByPosition(position = 1)
    private int age;

}
