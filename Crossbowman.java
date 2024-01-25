import java.util.ArrayList;
import java.util.Optional;

public class Crossbowman extends Hero {
    private int bolts; // Поле, обозначающее количество стрел

    public Crossbowman(String name, int x, int y) {
        super(name, "Crossbowman", 150, 150, 10, x, y, 3);
        this.bolts = 10; // Изначальное количество стрел
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
                bolts--; // Уменьшить количество стрел
            }
        } else {
            // Лучник мертв или без стрел – выходим из метода
            System.out.println("Crossbowman "+ this.name+ "не имеет стрел");
        }
    }
}