package com.example.demo.dto.GGD;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParkingServiceResultWrapper {

    @JsonProperty("msgBody")
    private ParkingMessageBody msgBody;

    public ParkingMessageBody getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(ParkingMessageBody msgBody) {
        this.msgBody = msgBody;
    }
}


