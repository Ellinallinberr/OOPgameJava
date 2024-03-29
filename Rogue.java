import java.util.ArrayList;
import java.util.Optional;

public class Rogue extends Hero{
    public Rogue(String name, int x, int y, String team) {
        super(name, "Rogue", 300, 300, 40, x, y,2, team);
    }


    @Override
    public String toString() {
        return this.getStats();
    }
    
    @Override
public void step(ArrayList<Hero> enemies, ArrayList<Hero> allies) {
    
    if (isAlive()) {
        Optional<Hero> nearestEnemy = findNearestAliveEnemy(enemies);

        if (nearestEnemy.isPresent() && nearestEnemy.get().isAlive()) {
            // Получаем координаты ближайшего противника
            Coordinates enemyCoord = nearestEnemy.get().position;

            // Проверяем, находится ли противник в соседней клетке
            if (Math.abs(position.x - enemyCoord.x) <= 1 && Math.abs(position.y - enemyCoord.y) <= 1) {
                // Противник в соседней клетке, наносим повреждение
                attack(nearestEnemy.get());
            } else {
                // Противник не в соседней клетке, двигаемся к нему
                moveTowards(nearestEnemy.get());
            }
        }
    }
}

    private void attack(Hero target) {
        // Логика нанесения урона противнику
        System.out.println("Rogue "+ this.name+ " атакует " + target.getClassName() + " " + target.getName() + ".");
    }

    private void moveTowards(Hero target) {
        // Алгоритм движения к цели
        int dX = target.position.x - position.x;
        int dY = target.position.y - position.y;

        if (Math.abs(dX) > Math.abs(dY)) {
            // Если разница по X больше, двигаемся по X
            position.x += Integer.compare(dX, 0);
        } else {
            // Иначе двигаемся по Y
            position.y += Integer.compare(dY, 0);
        }

        System.out.println("Rogue "+ this.name +" сделал шаг к " + target.getClassName() + " " + target.getName() + ".");
    }
}
