package la.ch.bedag.rechner;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Addition extends Calculator {
    private final Logger LOGGER = Logger.getLogger(Addition.class.getName());

    private final Type type = Type.ADDITION;

    public Addition(long x, long y) {
        super(x, y);
    }

    @Override
    public long calc() {
        LOGGER.log(Level.INFO, "Wir addieren");
        return this.x + this.y;
    }

    public Type getType() {
        return this.type;
    }

}
