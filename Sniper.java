import java.util.ArrayList;

public class Sniper extends Hero{
    public Sniper(String name, int x, int y) {
        super(name, "Sniper", 150, 150, 10, x, y);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }
    public Hero findNearestEnemy(ArrayList<Hero> enemies) {
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

    return nearestEnemy;
}
}
