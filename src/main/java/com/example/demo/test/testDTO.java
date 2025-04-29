package com.example.demo.test;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class testDTO {

    @JacksonXmlProperty(localName = "PARKPLC_NM") // 주차장 이름
    private String parkingName;

    @JacksonXmlProperty(localName = "ADDR") // 주소
    private String address;
}

// row 태그 안에 포함된 주차장 정보를 담는 용도

