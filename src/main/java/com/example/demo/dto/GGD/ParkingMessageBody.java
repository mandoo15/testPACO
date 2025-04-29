package com.example.demo.dto.GGD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParkingMessageBody {

    @JsonProperty("itemList")  // 여기는 단일 객체
    private ParkingInfoDTOGGD itemList;

    public ParkingInfoDTOGGD getItemList() {
        return itemList;
    }

    public void setItemList(ParkingInfoDTOGGD itemList) {
        this.itemList = itemList;
    }
}






