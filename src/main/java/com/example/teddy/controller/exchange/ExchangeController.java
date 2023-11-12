package com.example.teddy.controller.exchange;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
*   환율 컨트롤러
*   2023.11.11 박근목
* */
@Controller
public class ExchangeController {

    @GetMapping("/exchange/list")
    public String exchange() {
        System.out.println("ExchangeController.exchange");
        return "exchange/list";
    }

}
