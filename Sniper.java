import java.util.ArrayList;
import java.util.Optional;

public class Sniper extends Hero {
    

    private int bolts;

    public Sniper(String name, String className, int maxHealth, int health, int armor, int x, int y, int initiative) {
        super(name, className, maxHealth, health, armor, x, y, initiative);
        this.bolts = 10;
    }
    @Override
    public String toString() {
        return this.getStats(this.getClassName()) + " Bolts:" + bolts;
    }

    public void step(ArrayList<Hero> enemies) {
        // Проверка, жив ли лучник и есть ли у него стрелы
        if (isAlive() && bolts > 0) {
            Optional<Hero> nearestEnemy = findNearestEnemy(enemies);

            if (nearestEnemy != null) {
                // Выстрелить по ближайшему противнику
                shoot(nearestEnemy);
                bolts--; // Уменьшить количество стрел
            }
        } else {
            // Лучник мертв или без стрел – выходим из метода
            System.out.println("Sniper cannot shoot.");
        }
    }

    private void shoot(Optional<Hero> nearestEnemy) {
        // Логика выстрела по цели
        System.out.println("Sniper shoots at " + nearestEnemy.get().getClassName() + " " + nearestEnemy.get().getName() + ".");
    }
}