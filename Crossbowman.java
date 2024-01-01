public class Crossbowman extends Hero{
    public Crossbowman(String name, int x, int y) {
        super(name, "Crossbowman", 150, 150, 10, x, y);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }
}
