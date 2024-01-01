public class Spearman extends Hero{
    public Spearman(String name, int x, int y) {
        super(name, "Spearman", 300, 300, 40, x, y);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }
}
