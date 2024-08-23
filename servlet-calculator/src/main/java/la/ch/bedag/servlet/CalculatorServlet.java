package la.ch.bedag.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import la.ch.bedag.rechner.Addition;
import la.ch.bedag.rechner.Calculator;
import la.ch.bedag.rechner.Divide;
import la.ch.bedag.rechner.Multiplication;
import la.ch.bedag.rechner.Subtraction;
import la.ch.bedag.rechner.Type;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Calculator", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    private final Logger LOGGER = Logger.getLogger(CalculatorServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("""
                <html>
                    <body>
                        <form action='' method='get'>
                            <label>x: <input name='x' style='width: 50px'/></label>
                            <label>y: <input name='y' style='width: 50px'/></label>
                            <br>
                            <br>
                            <button type='submit' name='type' value='addition'>Addition</button>
                            <button type='submit' name='type' value='subtraction'>Subtraction</button>
                            <br>
                            <button type='submit' name='type' value='multiplication'>Multiplication</button>
                            <button type='submit' name='type' value='divide'>Divide</button>
                        </form>
                        <label>Result: </label>
                    </body>
                </html>
                """);

        long x = Long.parseLong(request.getParameter("x"));
        long y = Long.parseLong(request.getParameter("y"));
        String type = request.getParameter("type").toUpperCase();

        Calculator calculator;
        switch (Type.valueOf(type)) {
            case ADDITION -> {
                calculator = new Addition(x, y);
                out.println(calculator.calc());
                LOGGER.log(Level.INFO, "Added");
            }
            case SUBTRACTION -> {
                calculator = new Subtraction(x, y);
                out.println(calculator.calc());
                LOGGER.log(Level.INFO, "Subtracted");
            }
            case MULTIPLICATION -> {
                calculator = new Multiplication(x, y);
                out.println(calculator.calc());
                LOGGER.log(Level.INFO, "Multiplied");
            }
            case DIVIDE -> {
                calculator = new Divide(x, y);
                out.println(calculator.calc());
                LOGGER.log(Level.INFO, "Divided");
            }
        }
    }
}
