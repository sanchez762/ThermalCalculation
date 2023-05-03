package thermal_calculation.controllers;

import thermal_calculation.services.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


@Controller
@RequiredArgsConstructor
@RequestMapping("/load")
public class ControllerLoad {
    private final CalculationService calculationService;

    @GetMapping
    public String loadChart(){
        return "load";
    }

    @PostMapping("/setLoad")
    public String setLoad(@RequestParam(value="power") String[] power){
        calculationService.setLoad(Arrays.stream(power)
                .mapToDouble(Double::parseDouble)
                .toArray());
        return "redirect:/";
    }
}
