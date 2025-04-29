package com.example.demo;

import com.example.demo.dto.ParkingInfoDTOGJR;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ParkingControllerGJR {

    @GetMapping("/parking_info/real/gyeongju")
    public List<ParkingInfoDTOGJR> callApi() {
        List<ParkingInfoDTOGJR> parkingList = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        try {
            String apiUrl = "https://apis.data.go.kr/5050000/GYJOpenApi//ParkingRemainZoneInfoPage?"
                    + "serviceKey=2g4UkG4HCnw63pTfOXD%2FLX%2Fy3BRi%2BzsW3B57RCDkJ2q5sDYi6rSb8OFqZYnJ9nGTpzVy4fyCRIFF79zqQBEhuA%3D%3D"
                    + "&";

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            urlConnection.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode items = mapper.readTree(result.toString())
                    .path("response").path("body").path("items").path("item");

            for (JsonNode item : items) {
                ParkingInfoDTOGJR dto = mapper.treeToValue(item, ParkingInfoDTOGJR.class);
                dto.setInfoLevel("3"); // 고정값 추가
                parkingList.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return parkingList;
    }
}


