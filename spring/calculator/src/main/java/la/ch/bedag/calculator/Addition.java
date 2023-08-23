package la.ch.bedag.calculator;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Addition extends Calculator {
    private final Logger LOGGER = Logger.getLogger(Addition.class.getName());

    @Override
    public long calc(long x, long y) {
        LOGGER.log(Level.INFO, "Wir addieren");
        return x + y;
    }
}
