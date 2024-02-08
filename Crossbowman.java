import java.util.ArrayList;
import java.util.Optional;

public class Crossbowman extends Hero {
    private int bolts; // Поле, обозначающее количество стрел

    public Crossbowman(String name, int x, int y, String team) {
        super(name, "Crossbowman", 150, 150, 10, x, y, 3, team);
        this.bolts = 10; // Изначальное количество стрел
    }

    @Override
    public String toString() {
        return this.getStats() + " Bolts:" + bolts;
    }

    public void step(ArrayList<Hero> enemies, ArrayList<Hero> allies) {
        // Проверка, жив ли лучник и есть ли у него стрелы
        if (isAlive() && bolts > 0) {
            Optional<Hero> nearestEnemy = findNearestAliveEnemy(enemies);
    
            if (nearestEnemy.isPresent()) {
                // Выстрелить по ближайшему противнику
                attack(nearestEnemy.get(), 30, 50); // Урон для дальних атак
                bolts--; // Уменьшить количество стрел
            }
        } else {
            // Передача стрел крестьянам, если у лучника нет стрел
            for (Hero ally : enemies) {
                if (ally instanceof Peasant) {
                    Peasant peasantAlly = (Peasant) ally;
                    if (peasantAlly.getBolts() > 0) {
                        peasantAlly.setBolts(peasantAlly.getBolts() - 1); // Уменьшить количество стрел у крестьянина
                        this.bolts++; // Увеличить количество стрел у лучника
                        System.out.println("Crossbowman " + this.name + " получил стрелу от крестьянина " + peasantAlly.getName());
                        break; // Прерываем цикл, после того как стрела передана
                    }
                }
            }
        }
    }

    public int getBolts() {
        return bolts;
    }

    public void setBolts(int bolts) {
        this.bolts = bolts;
    }
}