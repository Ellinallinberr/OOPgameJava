import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numberOfTeams = 10;
        createTeams(numberOfTeams);

        System.out.println("Команда Света:");
        lightSide.forEach(System.out::println);
        System.out.println("---------------------------------------");
        System.out.println("Команда Тьмы:");
        darkSide.forEach(System.out::println);
    }

    static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length - 1)].toString();
    }

    static void createTeams(int numbers) {
        for (int i = 0; i < numbers; i++) {
            Hero lightSideHero = getRandomHero(random.nextInt(4), i, 0);
            Hero darkSideHero = getRandomHero(random.nextInt(3) + 4, i, 9);
            lightSide.add(lightSide.stream().anyMatch(hero -> hero.className == "Crossbowman") && !lightSide.stream().anyMatch(hero -> hero.className == "Peasant")  ?  getRandomHero(3, i, 0) : lightSideHero);
            darkSide.add(darkSide.stream().anyMatch(hero -> hero.className == "Sniper") && !darkSide.stream().anyMatch(hero -> hero.className == "Peasant")  ?  getRandomHero(3, i, 9) : darkSideHero);
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

    static Random random = new Random();
    static ArrayList<Hero> darkSide = new ArrayList<>();
    static ArrayList<Hero> lightSide = new ArrayList<>();

    static HashMap<Hero, ArrayList<Double>> allDistance = new HashMap<>();
}
