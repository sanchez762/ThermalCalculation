package com.example.thermalcalculation.controllers;

import com.example.thermalcalculation.services.TransformerService;
import com.example.thermalcalculation.transformer.Calculation;
import com.example.thermalcalculation.transformer.Transformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


@Controller
@RequiredArgsConstructor
public class ControllerMenu {
    private final TransformerService transformerService;
    private final Calculation calculation;
    @GetMapping("/")
    public String menu(Model model){
        model.addAttribute("tr", calculation.trans);
        model.addAttribute("power", calculation.power);
        return "menu";
    }
    /*@GetMapping("/")
    public String menu(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("menu", transformerService.list(name));
        return "menu";
    }*/
    @GetMapping("/choiceTrans")
    public String choiceTrans(Model model){
        model.addAttribute("list", transformerService.list(null));
        return "choiceTrans";
    }

    @GetMapping("/trans/{id}")
    public String transInfo(@PathVariable Long id, Model model){
        model.addAttribute("transformer", transformerService.getTrByID(id));
        return "trans-info";
    }
    @GetMapping("/parameters")
    public String parameters(){
        return "parameters";
    }
    @PostMapping("/parameters/apply")
    public String applyParam(@RequestParam(value="t") double t,
                             @RequestParam(value="n") int n,
                             @RequestParam(value="smax") double smax,
                             @RequestParam(value="iter") double iter,
                             @RequestParam(value="tmMax") double tmMax,
                             @RequestParam(value="tnntMax") double tnntMax,
                             Model model){
        calculation.n = n;
        calculation.t = t;
        calculation.smax = smax;
        calculation.iter = iter;
        calculation.tmMax = tmMax;
        calculation.tnntMax = tnntMax;
        return "redirect:/";
    }
    @GetMapping("/chart")
    public String chart(Model model){
        calculation.calculation();
        model.addAttribute("dataPointsList", calculation.list);
        return "chart";
    }

    /*@GetMapping("/calculate")
    public String calculate(){
        calculation.calculation();
        return "redirect:/";
    }*/

    @PostMapping("/trans/create")
    public String createTrans(Transformer transformer){
        transformerService.saveTrans(transformer);
        return "redirect:/choiceTrans";
    }

    @PostMapping("/trans/delete/{id}")
    public String deleteTr(@PathVariable Long id){
        transformerService.delete(id);
        return "redirect:/choiceTrans";
    }
    @PostMapping("/setTrans/{id}")
    public String setTr(@PathVariable Long id){
        calculation.trans = transformerService.getTrByID(id);
        return "redirect:/";
    }
}
