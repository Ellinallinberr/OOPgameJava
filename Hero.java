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
    protected boolean damagedThisTurn;
    protected String team;

    public Hero(String name, String className, int maxHealth, int health, int armor, int x, int y, int initiative, String team) {
        this.name = name;
        this.className = className;
        this.maxHealth = maxHealth;
        this.health = health;
        this.armor = armor;
        this.position = new Coordinates(x, y);
        this.initiative = initiative;
        this.damagedThisTurn = false;
    } 
    public int getInitiative() {
        return initiative;
    }
    public int getArmor() {
        return armor;
    }

    public int getHealth() {
        return health;
    }

    public boolean resetDamagedThisTurn() {
        return damagedThisTurn = false;
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

    public String getStats() {
        return ("units." + this.className + ": " + this.name + " " + this.position + " Armor:" + this.armor + " HP:" + this.health + "/" + this.maxHealth);
    }

    public Optional<Hero> findNearestAliveEnemy(ArrayList<Hero> enemies) {
        Hero nearestEnemy = null;
        double minDistance = Double.MAX_VALUE;

        for (Hero enemy : enemies) {
            double distance = this.position.distance(enemy.position);

            if ((distance < minDistance) && enemy.isAlive()) {
                minDistance = distance;
                nearestEnemy = enemy;
            }
        }

        return Optional.ofNullable(nearestEnemy);
    }

    public Optional<Hero> findNearestAliveAlly(ArrayList<Hero> allies) {
        Hero nearestAlly = null;
        double minDistance = Double.MAX_VALUE;

        for (Hero ally : allies) {
            double distance = this.position.distance(ally.position);

            if ((distance < minDistance) && ally.isAlive()) {
                minDistance = distance;
                nearestAlly = ally;
            }
        }

        return Optional.ofNullable(nearestAlly);
    }

    public abstract void step(ArrayList<Hero> enemies, ArrayList<Hero> allies);

    public String getName() {
        return this.name;
    }

    public void takeDamage(int damage) {
        int effectiveDamage = Math.max(damage - this.armor, 0);
        this.health -= effectiveDamage;
        this.armor -= Math.min(damage, this.armor); // Уменьшаем броню на количество полученного урона
    
        // Проверка на отрицательное здоровье и корректировка
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void attack(Hero target, int minDamage, int maxDamage) {
        int damage = getRandomDamage(minDamage, maxDamage);
        target.takeDamage(damage);

        // Вывод информации о нанесенном уроне
        System.out.println(this.getClassName() + " " + this.name + " атакует " + target.getClassName() + " " + target.getName() +
                " урон:" + damage);
    }

    private int getRandomDamage(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
    public Coordinates getPosition() {
        return this.position;
    }
    
}