package la.ch.bedag.rechner;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Multiplication extends Rechner {
    private final Logger LOGGER = Logger.getLogger(Multiplication.class.getName());

    private final Type type = Type.MULTIPLICATION;

    public Multiplication(long x, long y) {
        super(x, y);
    }

    @Override
    public long calc() {
        LOGGER.log(Level.INFO, "Wir multiplizieren");
        return this.x * this.y;
    }

    public Type getType() {
        return this.type;
    }
}
