import java.util.ArrayList;
import java.util.Arrays;


public class View {

    public static void displayField(ArrayList<Hero> lightSide, ArrayList<Hero> darkSide, boolean isDarkSide) {
        int fieldSize = 10; // Размер поля
        String[][] field = new String[fieldSize][fieldSize];

        // Заполнение поля пустыми символами
        for (String[] row : field) {
            Arrays.fill(row, "_");
        }

        // Размещение героев на поле для команды Света
        for (Hero hero : lightSide) {
            Coordinates position = hero.getPosition();
            String symbol = getSymbolAndColorForHero(hero, isDarkSide);
            field[position.getY()][position.getX()] = symbol;
        }

        // Размещение героев на поле для команды Тьмы
        for (Hero hero : darkSide) {
            Coordinates position = hero.getPosition();
            String symbol = getSymbolAndColorForHero(hero, isDarkSide);
            field[position.getY()][position.getX()] = symbol;
        }

        // Отображение поля в консоли
        for (String[] row : field) {
            for (String cell : row) {
                System.out.print("|" + cell);
            }
            System.out.println("|");
        }
        System.out.println("-------------------------------");
    }

    private static String getSymbolAndColorForHero(Hero hero, boolean isDarkSide) {
        // Вернуть символ и цвет в зависимости от типа героя
        String color = getColorForHero(hero, isDarkSide);
        String symbol;
        switch (hero.getClassName()) {
            case "Peasant":
                symbol = "P";
                break;
            case "Rogue":
                symbol = "R";
                break;
            case "Sniper":
                symbol = "S";
                break;
            case "Mage":
                symbol = "M";
                break;
            case "Spearman":
                symbol = "A";
                break;
            case "Crossbowman":
                symbol = "C";
                break;
            case "Monk":
                symbol = "N";
                break;
            default:
                symbol = "?"; // Символ по умолчанию для неизвестного типа героя
        }

        return color + symbol + AnsiColors.RESET;
    }

    private static String getColorForHero(Hero hero, boolean isDarkSide) {
        String color = AnsiColors.RESET;
    
        // Определение цвета в зависимости от команды
        if (isDarkSide) {
            // Красный цвет для команды Тьмы
            if (hero.isDamagedThisTurn()) {
                // Желтый цвет, если герой получил урон
                color = AnsiColors.YELLOW;
            } else {
                color = AnsiColors.RED;
            }
        } else {
            // Синий цвет для команды Света
            if (hero.isDamagedThisTurn()) {
                // Желтый цвет, если герой получил урон
                color = AnsiColors.YELLOW;
            } else {
                color = AnsiColors.BLUE;
            }
        }
    
        return color;
    }
     // для команды Света
}