package com.example.week04;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MathAPI {

    @RequestMapping(value = "/plus/{n1}/{n2}")
    public double myPlus(@PathVariable("n1") double n1,@PathVariable("n2") double n2){
        return n1+n2;
    }
    @RequestMapping(value = "/minus/{n1}/{n2}")
    public double myMinus(@PathVariable("n1") double n1,@PathVariable("n2") double n2){
        return n1-n2;
    }
    @RequestMapping(value = "/divide/{n1}/{n2}")
    public double myDivide(@PathVariable("n1") double n1,@PathVariable("n2") double n2){
        return n1/n2;
    }
    @RequestMapping(value = "/multi/{n1}/{n2}")
    public double myMulti(@PathVariable("n1") double n1,@PathVariable("n2") double n2){
        return n1*n2;
    }
    @RequestMapping(value = "/mod/{n1}/{n2}")
    public double myMod(@PathVariable("n1") double n1,@PathVariable("n2") double n2){
        return n1%n2;
    }
    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public double myMax(@RequestBody ArrayList<Double> arr){
        return Math.max(arr.get(0),arr.get(1));
    }

}
