import java.util.ArrayList;
import java.util.Optional;

public class Sniper extends Hero {
    // ... (остальные поля и методы)

    public Sniper(String name, String className, int maxHealth, int health, int armor, int x, int y, int initiative) {
        super(name, className, maxHealth, health, armor, x, y, initiative);
        this.bullets = 5;
    }

    // Исправленный метод с совместимым возвращаемым типом
    @Override
    public Optional<Hero> findNearestEnemy(ArrayList<Hero> enemies) {
        Hero nearestEnemy = null;
        double minDistance = Double.MAX_VALUE;
        double maxAttackRange = 13.0; // Максимальный диапазон атаки

        for (Hero enemy : enemies) {
            double distance = this.position.distance(enemy.position);

            if (distance < minDistance && distance <= maxAttackRange) {
                minDistance = distance;
                nearestEnemy = enemy;
            }
        }

        return Optional.ofNullable(nearestEnemy);
    }
}