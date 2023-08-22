package la.ch.bedag.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import la.ch.bedag.rechner.Type;

import java.io.IOException;

@WebFilter(urlPatterns = {"/calculator?"}, filterName = "TypeFilter", servletNames = "Calculator")
public class TypeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String t = request.getParameter("type").toUpperCase();
        for (Type type : Type.values()) {
            if (type.equals(t)) {
                System.out.println("Type: " + t);
            }
        }
        System.out.println(t);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
