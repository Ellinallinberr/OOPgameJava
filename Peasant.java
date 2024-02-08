import java.util.ArrayList;

public class Peasant extends Hero {
    private int bolts; // Поле для хранения количества стрел

    public Peasant(String name, int x, int y, String team) {
        super(name, "Peasant", 100, 100, 0, x, y, 0, team);
        this.bolts = 10; // Изначальное количество стрел
    }

    @Override
    public String toString() {
        return this.getStats() + " Bolts:" + bolts;
    }

    @Override
    public void step(ArrayList<Hero> enemies, ArrayList<Hero> allies) {
        // Логика передачи стрел лучнику
        shareArrows(allies);
    }

    public int getBolts() {
        return bolts;
    }

    public void setBolts(int bolts) {
        this.bolts = bolts;
    }

    protected void shareArrows(ArrayList<Hero> allies) {
        for (Hero ally : allies) {
            if (ally instanceof Crossbowman) {
                Crossbowman crossbowman = (Crossbowman) ally;
                if (this instanceof Peasant && ((Peasant) this).getBolts() > 0 && crossbowman.getBolts() == 0) {
                    crossbowman.setBolts(1);
                    ((Peasant) this).setBolts(((Peasant) this).getBolts() - 1);
                    System.out.println("Peasant " + this.name + " передает стрелу лучнику " + crossbowman.getName());
                }
            }
        }
    }
}