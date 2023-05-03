package thermal_calculation.controllers;

import thermal_calculation.services.CalculationService;
import thermal_calculation.services.TransformerService;
import thermal_calculation.models.Transformer;
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
    private final CalculationService calculationService;
    private final TransformerService transformerService;

    @GetMapping("/")
    public String menu(Model model){
        model.addAttribute("tr", calculationService.getTr());
        model.addAttribute("power", calculationService.getPower());
        model.addAttribute("condition", calculationService.getCondition());
        return "menu";
    }

    @GetMapping("/choiceTrans")
    public String choiceTrans(Model model){
        model.addAttribute("list", transformerService.list());
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
    public String applyParam(@RequestParam(value="temperature") double temperature,
                             @RequestParam(value="n") int n,
                             @RequestParam(value="smax") double smax,
                             @RequestParam(value="iter") double iter,
                             @RequestParam(value="tmMax") double tmMax,
                             @RequestParam(value="tnntMax") double tnntMax){
        calculationService.setParam(temperature, n, smax, iter, tmMax, tnntMax);
        return "redirect:/";
    }

    @GetMapping("/chart")
    public String chart(Model model){
        model.addAttribute("dataPointsList", calculationService.result());
        return "chart";
    }

    @GetMapping("/calculate")
    public String calculate(){
        calculationService.calculation();
        return "redirect:/";
    }

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
        calculationService.setTrans(transformerService.getTrByID(id));
        return "redirect:/";
    }
}
