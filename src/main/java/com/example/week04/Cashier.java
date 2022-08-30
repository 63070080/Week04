package com.example.week04;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {

    @RequestMapping(value = "/getChange/{money}")
    public Change getChange(@PathVariable("money") int money){
        return new Change(money);
    }
}
