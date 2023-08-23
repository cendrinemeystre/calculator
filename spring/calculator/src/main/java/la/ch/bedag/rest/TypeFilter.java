package la.ch.bedag.rest;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import la.ch.bedag.calculator.Type;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Order(1)
public class TypeFilter implements Filter {
    private final Logger LOGGER = Logger.getLogger(TypeFilter.class.getName());


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String t = request.getParameter("type").toUpperCase();
        Arrays.stream(Type.values()).forEach(type -> {
            if (type.toString().equals(t)) {
                LOGGER.log(Level.INFO, "Type: " + type);
            }
        });
        chain.doFilter(request, response);
    }
}
