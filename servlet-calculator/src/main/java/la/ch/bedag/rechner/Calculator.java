package la.ch.bedag.rechner;

public abstract class Calculator {
    protected long x;
    protected long y;

    protected Calculator(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public abstract long calc();
}
