package com.example.thermalcalculation.controllers;

import com.example.thermalcalculation.services.TransformerService;
import com.example.thermalcalculation.transformer.Transformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ControllerMenu {
    private final TransformerService transformerService;
    @GetMapping("/")
    public String menu(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("menu", transformerService.list(name));

        return "menu";
    }

    @GetMapping("/trans/{id}")
    public String transInfo(@PathVariable Long id, Model model){
        model.addAttribute("menu", transformerService.getTrByID(id));
        return "trans-info";
    }

    @PostMapping("/trans/create")
    public String createTrans(Transformer transformer){
        transformerService.saveTrans(transformer);
        return "redirect:/";
    }

    @PostMapping("/trans/delete/{id}")
    public String deleteTr(@PathVariable Long id){
        transformerService.delete(id);
        return "redirect:/";
    }


}
