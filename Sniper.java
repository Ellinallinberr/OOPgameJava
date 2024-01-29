import java.util.ArrayList;
import java.util.Optional;

public class Sniper extends Hero {
    

    private int bolts;

    public Sniper(String name,int x, int y) {
        super (name, "Sniper", 150, 150, 10, x, y, 3);
        this.bolts = 10;
    }
   
    
    @Override
    public String toString() {
        return this.getStats() + " Bolts:" + bolts;
    }

    public void step(ArrayList<Hero> enemies) {
        // Проверка, жив ли лучник и есть ли у него стрелы
        if (isAlive() && bolts > 0) {
            Optional<Hero> nearestEnemy = findNearestEnemy(enemies);

            if (nearestEnemy.isPresent()) {
                // Выстрелить по ближайшему противнику
                attack(nearestEnemy.get(), 30, 50); // Урон для дальних атак
                bolts--; 
            }
        } else {
            // Лучник мертв или без стрел – выходим из метода
            System.out.println("Sniper "+ this.name+ " не имеет пуль");
        }
    }
}