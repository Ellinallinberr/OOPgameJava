
public class Peasant extends Hero {
    public Peasant(String name, int x, int y) {
        super(name, "Peasant", 100, 100, 0, x, y);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }
}
