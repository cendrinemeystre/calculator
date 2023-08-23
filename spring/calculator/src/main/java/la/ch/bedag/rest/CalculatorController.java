package la.ch.bedag.rest;

import jakarta.servlet.http.HttpServletRequest;
import la.ch.bedag.calculator.Addition;
import la.ch.bedag.calculator.Divide;
import la.ch.bedag.calculator.Multiplication;
import la.ch.bedag.calculator.Subtraction;
import la.ch.bedag.calculator.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    private Addition addition;

    @Autowired
    private Subtraction subtraction;

    @Autowired
    private Multiplication multiplication;

    @Autowired
    private Divide divide;

    @GetMapping("/")
    public String getCalculation(HttpServletRequest request, Model model) {
        long x = Long.parseLong(request.getParameter("x"));
        long y = Long.parseLong(request.getParameter("y"));
        String type = request.getParameter("type").toUpperCase();

        long result = switch (Type.valueOf(type.toUpperCase())) {
            case ADDITION -> addition.calc(x, y);
            case SUBTRACTION -> subtraction.calc(x, y);
            case MULTIPLICATION -> multiplication.calc(x, y);
            case DIVIDE -> divide.calc(x, y);
        };

        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("result", result);

        return "index";
    }
}
