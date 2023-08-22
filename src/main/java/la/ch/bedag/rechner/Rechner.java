package la.ch.bedag.rechner;

public abstract class Rechner {
    protected long x;
    protected long y;

    protected Rechner(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public abstract long calc();
}
