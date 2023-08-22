package la.ch.bedag.servlet;

import jakarta.servlet.ServletException;
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

//@WebServlet(name = "WebRechner", value = "/rechner")
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
                        <label>result: </label>
                    </body>
                </html>
                """);

        long x = Long.parseLong(request.getParameter("x"));
        long y = Long.parseLong(request.getParameter("y"));
        String type = request.getParameter("type").toUpperCase();

        Calculator calculator;
        if (type.equals(Type.ADDITION.toString())) {
            calculator = new Addition(x, y);
        } else if (type.equals(Type.SUBTRACTION.toString())) {
            calculator = new Subtraction(x, y);
        } else if (type.equals(Type.MULTIPLICATION.toString())) {
            calculator = new Multiplication(x, y);
        } else {
            calculator = new Divide(x, y);
        }

        out.println(calculator.calc());
        LOGGER.log(Level.INFO, "Get titel");
    }
}
