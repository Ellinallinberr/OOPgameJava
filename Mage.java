
public class Mage extends Hero{
    public Mage(String name, int x, int y) {
        super(name, "Mage", 100, 100, 20, x,y);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }
}
