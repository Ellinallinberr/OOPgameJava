import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static ArrayList<Hero> darkSide = new ArrayList<>();
    static ArrayList<Hero> lightSide = new ArrayList<>();
    static HashMap<Hero, ArrayList<Double>> allDistance = new HashMap<>();

    public static void main(String[] args) {
        int numberOfTeams = 10;
        createTeams(numberOfTeams);
    
        int roundNumber = 1; // Начальный номер раунда
    
        while (!lightSide.isEmpty() && !darkSide.isEmpty() && roundNumber <= 22) {
            System.out.println("Раунд " + roundNumber);
            System.out.println("Команда Света:");
            lightSide.forEach(System.out::println);
            System.out.println("---------------------------------------");
            System.out.println("Команда Тьмы:");
            darkSide.forEach(System.out::println);
    
            // Сброс флага damagedThisTurn для всех героев
            lightSide.forEach(Hero::resetDamagedThisTurn);
            darkSide.forEach(Hero::resetDamagedThisTurn);
    
            // Сортировка героев по убыванию инициативы
            lightSide.sort(Comparator.comparingInt(Hero::getInitiative).reversed());
            darkSide.sort(Comparator.comparingInt(Hero::getInitiative).reversed());
    
            // Выполнение действий для героев в порядке убывания инициативы
            for (Hero hero : lightSide) {
                hero.step(darkSide);
            }
    
            for (Hero hero : darkSide) {
                hero.step(lightSide);
            }
    
            // Отображение текущего состояния поля после действий
            View.displayField(lightSide, darkSide, false); // Отображение команды Света
            View.displayField(lightSide, darkSide, true); // Отображение команды Тьмы
    
            // Увеличение номера раунда
            roundNumber++;
        }
    
        System.out.println("Игра завершена!");
    }

    static String getName() {
        return Names.values()[random.nextInt(Names.values().length - 1)].toString();
    }

    static void createTeams(int numbers) {
        for (int i = 0; i < numbers; i++) {
            Hero lightSideHero = getRandomHero(random.nextInt(4), i, 0);
            Hero darkSideHero = getRandomHero(random.nextInt(3) + 4, i, 9);
            lightSide.add(lightSideHero);
            darkSide.add(darkSideHero);
        }
    }

    static Hero getRandomHero(int choice, int x, int y) {
        switch (choice) {
            case 0:
                return new Monk(getName(), x, y);
            case 1:
                return new Spearman(getName(), x, y);
            case 2:
                return new Crossbowman(getName(), x, y);
            case 3:
                return new Peasant(getName(), x, y);
            case 4:
                return new Mage(getName(), x, y);
            case 5:
                return new Rogue(getName(), x, y);
            case 6:
                return new Sniper(getName(), x, y);
            default:
                return null;
        }
    }
}