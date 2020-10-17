package com.example.demo.dto;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SecondTypeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    // ほげほげ
    @CsvBindByPosition(position = 0)
    String hoge;

    // ふがふが
    @CsvBindByPosition(position = 1)
    int fuga;

}
