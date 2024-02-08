import java.util.ArrayList;

public class Peasant extends Hero {
    private int bolts; // Поле для хранения количества стрел

    public Peasant(String name, int x, int y) {
        super(name, "Peasant", 100, 100, 0, x, y, 0);
        this.bolts = 10; // Изначальное количество стрел
    }

    @Override
    public String toString() {
        return this.getStats() + " Bolts:" + bolts;
    }

    @Override
    public void step(ArrayList<Hero> enemies) {
        // Логика передачи стрел лучнику
        for (Hero enemy : enemies) {
            if (enemy instanceof Crossbowman) { // Проверяем, является ли противник лучником
                Crossbowman crossbowman = (Crossbowman) enemy;
                if (crossbowman.getBolts() == 0 && bolts > 0) { // Если у лучника закончились стрелы и у крестьянина есть запас
                    crossbowman.setBolts(1); // Лучнику передается одна стрела от крестьянина
                    bolts--; // Уменьшаем количество стрел у крестьянина
                    System.out.println("Peasant " + this.name + " передает стрелу лучнику " + crossbowman.getName());
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