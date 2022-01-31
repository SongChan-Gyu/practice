package com.example.testing.jpa.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class AccountController {

//    private final AccountRepository accountRepository;
//    @PostMapping("/account")
//    @ResponseBody
//    public String makeAccount(@RequestBody GeoDto geoDto){
//        Account temp = new Account();
//        temp.setUsername("새로운 글!");
//        temp.setLocation(new GeoJsonPoint(Double.parseDouble(geoDto.getLatitude()), Double.parseDouble(geoDto.getLongtitude())));
//        return accountRepository.save(temp).getId();
//    }
    @GetMapping("/account1")
    public @ResponseBody String page(){
        return "account";
    }
}
