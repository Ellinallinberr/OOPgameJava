import java.util.ArrayList;

public class Peasant extends Hero {
    public Peasant(String name, int x, int y) {
        super(name, "Peasant", 100, 100, 0, x, y, 0);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }
      @Override
    public void step(ArrayList<Hero> enemies) {
        
    }
}
