package la.ch.bedag.rechner;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Divide extends Rechner {
    private final Logger LOGGER = Logger.getLogger(Divide.class.getName());

    private final Type type = Type.DIVIDE;

    public Divide(long x, long y) {
        super(x, y);
    }

    @Override
    public long calc() {
        LOGGER.log(Level.INFO, "Wir dividieren");
        return this.x / this.y;
    }

    public Type getType() {
        return this.type;
    }
}
