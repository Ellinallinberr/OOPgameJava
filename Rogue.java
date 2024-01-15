public class Rogue extends Hero{
    public Rogue(String name, int x, int y) {
        super(name, "Rogue", 300, 300, 40, x, y,2);
    }


    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }
}
