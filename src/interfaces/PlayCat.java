package interfaces;

import models.Cat;

public class PlayCat implements Strategy {
    @Override
    public void changeState(Cat cat) {
        if (cat.getAge() >= 1 && cat.getAge() <= 5) {
            cat.setMood(cat.getMood() + 7);
            cat.setHealth(cat.getHealth() + 7);
            cat.setHungry(cat.getHungry() - 3);
        }
        if (cat.getAge() >= 6 && cat.getAge() <= 10) {
            cat.setMood(cat.getMood() + 5);
            cat.setHealth(cat.getHealth() + 5);
            cat.setHungry(cat.getHungry() - 5);
        }
        if (cat.getAge() >= 11) {
            cat.setMood(cat.getMood() + 4);
            cat.setHealth(cat.getHealth() + 4);
            cat.setHungry(cat.getHungry() - 6);
        }
        System.out.println("Вы поиграли с " + cat.getName() + ", возраст " + cat.getAge());
    }
}
