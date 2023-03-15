package com.example.thermalcalculation.controllers;

import com.example.thermalcalculation.transformer.Calculation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


@Controller
@RequiredArgsConstructor
@RequestMapping("/loadChart")
public class ControllerLoad {

    private final Calculation calculation;
    @GetMapping
    public String loadChart(){
        return "loadChart";
    }

    @PostMapping("/setLoad")
    public String setLoad(@RequestParam(value="power") String[] power){
        calculation.power = Arrays.stream(power)
                .mapToDouble(Double::parseDouble)
                .toArray();
        return "redirect:/";
    }
}
