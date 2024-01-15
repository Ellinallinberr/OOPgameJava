// "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах"
// 
// "Peasant, Rogue, Sniper, Mag, Spearman, Crossbowman, Monk"
import java.util.ArrayList;
import java.util.Optional;

abstract public class Hero {
    protected String name;
    protected String className;
    protected int maxHealth, health, armor;
    protected Coordinates position;
    protected int initiative;

    public Hero(String name, String className, int maxHealth, int health, int armor, int x, int y, int initiative) {
        this.name = name;
        this.className = className;
        this.maxHealth = maxHealth;
        this.health = health;
        this.armor = armor;
        this.position = new Coordinates(x, y);
        this.initiative = initiative;
    }
    public int getInitiative() {
        return initiative;
    }

    public void getDistance(ArrayList<Hero> enemies) {
        for (Hero enemy : enemies) {
            System.out.printf("%.2f, ", position.distance(enemy.position));
        }
        System.out.println();
    }

    public String getClassName() {
        return this.className;
    }
    public boolean isAlive() {
        return health > 0;
    }

    public String getStats(String className) {
        return ("units." + className + ": " + this.name + " " + this.position + " Armor:" + this.armor + " HP:" + this.health + "/" + this.maxHealth);
    }

    public Optional<Hero> findNearestEnemy(ArrayList<Hero> enemies) {
        Hero nearestEnemy = null;
        double minDistance = Double.MAX_VALUE;

        for (Hero enemy : enemies) {
            double distance = this.position.distance(enemy.position);

            if (distance < minDistance) {
                minDistance = distance;
                nearestEnemy = enemy;
            }
        }

        return Optional.ofNullable(nearestEnemy);
    }
    public void step() {
    }
    public String getName() {
        return null;
    }
}
