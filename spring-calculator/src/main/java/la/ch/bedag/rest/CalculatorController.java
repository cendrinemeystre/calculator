package la.ch.bedag.rest;

import jakarta.validation.Valid;
import la.ch.bedag.calculator.Addition;
import la.ch.bedag.calculator.Divide;
import la.ch.bedag.calculator.Multiplication;
import la.ch.bedag.calculator.Subtraction;
import la.ch.bedag.calculator.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    private final Addition addition;

    private final Subtraction subtraction;

    private final Multiplication multiplication;

    private final Divide divide;

    @Autowired
    public CalculatorController(Addition addition, Subtraction subtraction, Multiplication multiplication, Divide divide) {
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
        this.divide = divide;
    }

    @GetMapping(value = "/calc")
    public String addCalcView(Model model) {
        model.addAttribute("request", new CalculatorRequest(0, 0, Type.ADDITION));
        model.addAttribute("resultSuccess", false);
        return "calc";
    }

    @PostMapping("/calc")
    public String postCalculation(Model model, @Valid @ModelAttribute("request") CalculatorRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("resultSuccess", false);
            return "calc";
        }

        long x = request.getX();
        long y = request.getY();
        String type = request.getType().name();

        long result = switch (Type.valueOf(type.toUpperCase())) {
            case ADDITION -> addition.calc(x, y);
            case SUBTRACTION -> subtraction.calc(x, y);
            case MULTIPLICATION -> multiplication.calc(x, y);
            case DIVIDE -> divide.calc(x, y);
        };

        model.addAttribute("result", result);
        model.addAttribute("resultSuccess", true);
        return "calc";
    }
}
