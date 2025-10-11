package models;

import enums.State;

public class Cat {
    private String name;
    private int age;
    private double hungry;
    private double mood;
    private double health;
    private State state;
    private boolean isActed;

    public Cat(String name, int age, double hungry, double mood, double health) {
        this.name = name;
        this.age = Math.max(1, Math.min(18, age));
        this.hungry = Math.max(0, Math.min(100, hungry));
        this.mood = Math.max(0, Math.min(100, mood));
        this.health = Math.max(0, Math.min(100, health));
        this.isActed = false;
    }

    public Cat() {
        this.isActed = false;
    }

    public void act(State state) {
        if (!isActed) {
            state.changeState(this);
            setActed(true);
        } else {
            System.out.println("Вы уже делали этой действие с " + name + " в этот день.");
        }
    }

    public void feedCat() {
        if (age >= 1 && age <= 5) {
            setHungry(hungry + 7);
            setMood(mood + 7);
        }
        if (age >= 6 && age <= 10) {
            setHungry(hungry + 5);
            setMood(mood + 5);
        }
        if (age >= 11) {
            setHungry(hungry + 4);
            setMood(mood + 4);
        }
        System.out.println("Вы покормили " + name + ", возраст " + age);
    }

    public void cureCat() {
        if (age >= 1 && age <= 5) {
            setHealth(health + 7);
            setMood(mood - 3);
            setHungry(hungry - 3);
        }
        if (age >= 6 && age <= 10) {
            setHealth(health + 5);
            setMood(mood - 5);
            setHungry(hungry - 5);
        }
        if (age >= 11) {
            setHealth(health + 4);
            setMood(mood - 6);
            setHungry(hungry - 6);
        }
        System.out.println("Вы полечили " + name + ", возраст " + age);
    }

    public void playCat() {
        if (age >= 1 && age <= 5) {
            setMood(mood + 7);
            setHealth(health + 7);
            setHungry(hungry - 3);
        }
        if (age >= 6 && age <= 10) {
            setMood(mood + 5);
            setHealth(health + 5);
            setHungry(hungry - 5);
        }
        if (age >= 11) {
            setMood(mood + 4);
            setHealth(health + 4);
            setHungry(hungry - 6);
        }
        System.out.println("Вы поиграли с " + name + ", возраст " + age);
    }

    public double getAverage() {
        return Math.round((hungry + mood + health) / 3);
    }

    @Override
    public String toString() {
        String actedName = (isActed ? "* " : "") + name;
        return String.format("%8s | %7d | %8.0f | %10.0f | %7.0f | %15.0f |", actedName, age, health, mood, hungry, getAverage());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHungry() {
        return hungry;
    }

    public double getMood() {
        return mood;
    }

    public double getHealth() {
        return health;
    }

    public boolean isActed() {
        return isActed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHungry(double hungry) {
        this.hungry = Math.max(0, Math.min(100, hungry));
    }

    public void setMood(double mood) {
        this.mood = Math.max(0, Math.min(100, mood));
    }

    public void setHealth(double health) {
        this.health = Math.max(0, Math.min(100, health));
    }

    public void setActed(boolean acted) {
        isActed = acted;
    }
}
