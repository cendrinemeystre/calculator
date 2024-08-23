package la.ch.bedag.rest;

import la.ch.bedag.calculator.Type;

public class CalculatorRequest {
    private long x;
    private long y;
    private Type type;

    public CalculatorRequest() {
    }

    public CalculatorRequest(long x, long y, Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
