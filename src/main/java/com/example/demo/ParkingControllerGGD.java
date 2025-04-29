package com.example.demo;

import com.example.demo.dto.GGD.ParkingServiceResultWrapper;
import com.example.demo.dto.GGD.ParkingMessageBody;
import com.example.demo.dto.GGD.ParkingInfoDTOGGD;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ParkingControllerGGD {

    private final List<String> regionIds = Arrays.asList(
            "31100", "31110", "31060", "31250", "31160", "31130",
            "31050", "31090", "31040", "31280", "31170", "31030",
            "31210", "31070"
    );

    @GetMapping("/parking_info/gyeonggi")
    public List<ParkingInfoDTOGGD> callApi() {
        List<ParkingInfoDTOGGD> totalList = new ArrayList<>();

        try {
            XmlMapper xmlMapper = new XmlMapper();

            for (String regionId : regionIds) {
                String apiUrl = "https://openapigits.gg.go.kr/api/rest/getParkingPlaceInfoList?serviceKey=YOUR_SERVICE_KEY"
                        + "&laeId=" + regionId;

                HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                StringBuilder xml = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    xml.append(line);
                }
                conn.disconnect();

                ParkingServiceResultWrapper wrapper = xmlMapper.readValue(xml.toString(), ParkingServiceResultWrapper.class);

                if (wrapper != null && wrapper.getMsgBody() != null && wrapper.getMsgBody().getItemList() != null) {
                    ParkingInfoDTOGGD dto = wrapper.getMsgBody().getItemList();
                    dto.setInfoLevel("2");
                    totalList.add(dto);
                } else {
                    System.out.println("[경고] msgBody 또는 itemList 없음 - 지역 ID: " + regionId);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalList;
    }
}






