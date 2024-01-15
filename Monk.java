public class Monk extends Hero {
    public Monk(String name, int x, int y) {
        super(name, "Monk", 100, 100, 20, x, y,1);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }
}
