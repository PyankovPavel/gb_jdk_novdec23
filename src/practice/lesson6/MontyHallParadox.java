package practice.lesson6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {

    public static void main(String[] args) {
        Random random = new Random();
        int totalSteps = 1000;

        Map<Integer, Boolean> results = new HashMap<>();

        for (int i = 1; i <= totalSteps; i++) {
            int prizeDoor = random.nextInt(3);
            int initialChoice = random.nextInt(3);

            int doorToReveal = getDoorToReveal(random, prizeDoor, initialChoice);
            int finalChoice = getFinalChoice(random, initialChoice, doorToReveal);

            boolean winWithoutSwitch = initialChoice == prizeDoor;

            results.put(i, winWithoutSwitch);
        }

        int positiveResults = (int) results.values()
                .stream()
                .filter(result -> result)
                .count();

        int negativeResults = totalSteps - positiveResults;

        double percentagePositive = (double) positiveResults / totalSteps * 100;
        double percentageNegative = (double) negativeResults / totalSteps * 100;

        System.out.println("Позитивные результаты: " + positiveResults);
        System.out.println("Негативные результаты: " + negativeResults);
        System.out.printf("Процент положительных результатов: %.2f%%\n", percentagePositive);
        System.out.printf("Процент негативных результатов: %.2f%%\n", percentageNegative);
    }

    private static int getDoorToReveal(Random random, int prizeDoor, int initialChoice) {
        int doorToReveal;
        do {
            doorToReveal = random.nextInt(3);
        } while (doorToReveal == prizeDoor || doorToReveal == initialChoice);
        return doorToReveal;
    }

    private static int getFinalChoice(Random random, int initialChoice, int doorToReveal) {
        int finalChoice;
        do {
            finalChoice = random.nextInt(3);
        } while (finalChoice == initialChoice || finalChoice == doorToReveal);
        return finalChoice;
    }
}
