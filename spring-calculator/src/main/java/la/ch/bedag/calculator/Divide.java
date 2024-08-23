package la.ch.bedag.calculator;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Divide extends Calculator {
    private final Logger LOGGER = Logger.getLogger(Divide.class.getName());

    @Override
    public long calc(long x, long y) {
        LOGGER.log(Level.INFO, "Wir dividieren");
        return x / y;
    }
}
