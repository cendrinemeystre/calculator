package la.ch.bedag.rechner;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Subtraction extends Rechner {
    private final Logger LOGGER = Logger.getLogger(Subtraction.class.getName());

    private final Type type = Type.SUBTRACTION;

    public Subtraction(long x, long y) {
        super(x, y);
    }

    @Override
    public long calc() {
        LOGGER.log(Level.INFO, "Wir subtrahieren");
        return this.x - this.y;
    }

    public Type getType() {
        return this.type;
    }
}
