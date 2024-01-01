public class Sniper extends Hero{
    public Sniper(String name, int x, int y) {
        super(name, "Sniper", 150, 150, 10, x, y);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }
}
