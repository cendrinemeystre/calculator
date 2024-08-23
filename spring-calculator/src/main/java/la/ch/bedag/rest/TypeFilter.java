package la.ch.bedag.rest;

import java.util.logging.Logger;

//@Component
//@Order(1)
public class TypeFilter {
    private final Logger LOGGER = Logger.getLogger(TypeFilter.class.getName());

//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String t = request.getParameter("type").toUpperCase();
//        Arrays.stream(Type.values()).forEach(type -> {
//            if (type.toString().equals(t)) {
//                LOGGER.log(Level.INFO, "Type: " + type);
//            }
//        });
//        chain.doFilter(request, response);
//    }
}
