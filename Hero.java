// "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах"
// 
// "Peasant, Rogue, Sniper, Mag, Spearman, Crossbowman, Monk"
import java.util.ArrayList;

abstract public class Hero {
    protected String name;
    protected String className;
    protected int maxHealth, health, armor;
    protected Coordinates position;


    public Hero(String name, String className, int maxHealth, int health,
                    int armor, int x, int y) {
        this.name = name;
        this.className = className;
        this.maxHealth = maxHealth;
        this.health = health;
        this.armor = armor;
        this.position = new Coordinates(x,y);
    }

    public void getDistance(ArrayList<Hero> enemy){
        for (Hero heroBase : enemy) {
            System.out.printf("%.2f, ",position.distance(heroBase.position));
        }
        System.out.println();
    }

    public String getClassName() {
        return this.className;
    }

    public String getStats(String className) {
        return ("units." + className + ": " + this.name + " " + this.position + " Armor:" + this.armor + " HP:"  + this.health+"/"+this.maxHealth);
    }
}
