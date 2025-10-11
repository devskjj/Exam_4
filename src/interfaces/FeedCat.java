package interfaces;

import models.Cat;

public class FeedCat implements Strategy {

    @Override
    public void changeState(Cat cat) {
        if (cat.getAge() >= 1 && cat.getAge() <= 5) {
            cat.setHungry(cat.getHungry() + 7);
            cat.setMood((cat.getMood() + 7));
        }
        if (cat.getAge() >= 6 && cat.getAge() <= 10) {
            cat.setHungry(cat.getHungry() + 5);
            cat.setMood((cat.getMood() + 5));
        }
        if (cat.getAge() >= 11) {
            cat.setHungry(cat.getHungry() + 4);
            cat.setMood((cat.getMood() + 4));
        }
        System.out.println("Вы покормили " + cat.getName() + ", возраст " + cat.getAge());
    }
}
