import java.util.ArrayList;

public class Crossbowman extends Hero{
    public Crossbowman(String name, int x, int y) {
        super(name, "Crossbowman", 150, 150, 10, x, y);
    }

    @Override
    public String toString() {
        return this.getStats(this.getClassName());
    }

    public Hero findNearestEnemy(ArrayList<Hero> enemies) {
    Hero nearestEnemy = null;
    double minDistance = Double.MAX_VALUE;
    double maxAttackRange = 10.0; // Максимальный диапазон атаки

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
