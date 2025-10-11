package interfaces;

import models.Cat;

import java.util.Random;

public class PlayCat implements Strategy {
    Random random = new Random();

    @Override
    public void changeState(Cat cat) {
        if (cat.getAge() >= 1 && cat.getAge() <= 5) {
            if (random.nextDouble() < 0.1) {
                double damage = random.nextDouble(20, 40);
                cat.setHealth(cat.getHealth() - damage);
                cat.setMood(cat.getMood() - damage);
                System.out.printf("%s травмировался! Здоровье и настроение упали на %.0f%n", cat.getName(), damage);
            } else {
                cat.setMood(cat.getMood() + 7);
                cat.setHealth(cat.getHealth() + 7);
                cat.setHungry(cat.getHungry() - 3);
            }
        }

        if (cat.getAge() >= 6 && cat.getAge() <= 10) {
            if (random.nextDouble() < 0.1) {
                double damage = random.nextDouble(20, 40);
                cat.setHealth(cat.getHealth() - damage);
                cat.setMood(cat.getMood() - damage);
                System.out.printf("%s травмировался! Здоровье и настроение упали на %.0f%n", cat.getName(), damage);
            } else {
                cat.setMood(cat.getMood() + 5);
                cat.setHealth(cat.getHealth() + 5);
                cat.setHungry(cat.getHungry() - 5);
            }
        }

        if (cat.getAge() >= 11) {
            if (random.nextDouble() < 0.1) {
                double damage = random.nextDouble(20, 40);
                cat.setHealth(cat.getHealth() - damage);
                cat.setMood(cat.getMood() - damage);
                System.out.printf("%s травмировался! Здоровье и настроение упали на %.0f%n", cat.getName(), damage);
            } else {
                cat.setMood(cat.getMood() + 4);
                cat.setHealth(cat.getHealth() + 4);
                cat.setHungry(cat.getHungry() - 6);
            }
        }

        System.out.println("Вы поиграли с " + cat.getName() + ", возраст " + cat.getAge());
    }
}
