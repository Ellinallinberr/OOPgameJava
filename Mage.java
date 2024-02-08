import java.util.ArrayList;

public class Mage extends Hero {
    // Конструктор Mage
    public Mage(String name, int x, int y, String team) {
        super(name, "Mage", 150, 150, 10, x, y, 1, team);
    }

    @Override
    public String toString() {
        return this.getStats();
    }

    
    public void step(ArrayList<Hero> enemies , ArrayList<Hero> allies) {
        
    }
}
