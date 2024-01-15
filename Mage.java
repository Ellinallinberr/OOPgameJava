import java.util.ArrayList;

public class Mage extends Hero {
    // Конструктор Mage
    public Mage(String name, int x, int y) {
        super(name, "Mage", 150, 150, 10, x, y, 1);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }

    // Добавим метод step()
    public void step(ArrayList<Hero> enemies) {
        // Логика действий мага в ходе
    }
}
