package interfaces;

import models.Cat;

import java.util.Random;

public class FeedCat implements Strategy {
    Random random = new Random();

    @Override
    public void changeState(Cat cat) {
        if (cat.getAge() >= 1 && cat.getAge() <= 5) {
            if (random.nextDouble() < 0.2) {
                double damage = random.nextDouble(20, 40);
                cat.setHealth(cat.getHealth() - damage);
                cat.setMood(cat.getMood() - damage);
                System.out.printf("%s отравился! Здоровье и настроение упали на %.0f%n", cat.getName(), damage);
            } else {
                cat.setHungry(cat.getHungry() + 7);
                cat.setMood((cat.getMood() + 7));
            }

        }

        if (cat.getAge() >= 6 && cat.getAge() <= 10) {
            if (random.nextDouble() < 0.2) {
                double damage = random.nextDouble(20, 40);
                cat.setHealth(cat.getHealth() - damage);
                cat.setMood(cat.getMood() - damage);
                System.out.printf("%s отравился! Здоровье и настроение упали на %.0f%n", cat.getName(), damage);
            } else {
                cat.setHungry(cat.getHungry() + 5);
                cat.setMood((cat.getMood() + 5));
            }
        }

        if (cat.getAge() >= 11) {
            if (random.nextDouble() < 0.2) {
                double damage = random.nextDouble(20, 40);
                cat.setHealth(cat.getHealth() - damage);
                cat.setMood(cat.getMood() - damage);
                System.out.printf("%s отравился! Здоровье и настроение упали на %.0f%n", cat.getName(), damage);
            } else {
                cat.setHungry(cat.getHungry() + 4);
                cat.setMood((cat.getMood() + 4));
            }
        }

        System.out.println("Вы покормили " + cat.getName() + ", возраст " + cat.getAge());
    }
}
