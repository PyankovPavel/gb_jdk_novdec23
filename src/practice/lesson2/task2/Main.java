package practice.lesson2.task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Developer> developers = new ArrayList<>();

        developers.add(new Frontender());
        developers.add(new Backender());
        developers.add(new Fullstacker());
        developers.add(new Frontender());
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i) instanceof Frontender) {
                (developers.get(i)).developGUI();
            }
        }

    }

}
