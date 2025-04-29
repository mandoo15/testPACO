//package com.example.demo;
//
//import com.example.demo.test.testDTO;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//public class testController {
//
//    @GetMapping("/test") // ~~/test 구조의 url로 검색하면 아래 url 연결되서 정보 뜨게 함
//    public String getApi() {
//        String apiUrl = "https://openapi.gg.go.kr/ParkingPlace?"; // open api에서 제공하는 주소
//
//        RestTemplate restTemplate = new RestTemplate(); // 프레임워크에서 제공하는 것. 데이터 처리할 때 사용
//        // restTemplate은 고전적인 방법이지만 간단하다. WebClient가 요즘 뜨는 건데,
//        // 아직 초보이기 때문에 restTemplate 사용!
//        String result = restTemplate.getForObject(apiUrl, String.class); // 응답 전체를 문자열로 받음
//
//        testDTO dto = new testDTO();
//        dto.setAddress(item.path("address")).asText();
//        dto.setParkingName(item.path("stationName")).asText();
//
//        return result; // 결과 반환
//    }
//}
