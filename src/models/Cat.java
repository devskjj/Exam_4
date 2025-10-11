package models;

public class Cat {
    private String name;
    private int age;
    private double hungry;
    private double mood;
    private double health;
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

    public double getAverage() {
        return Math.ceil((hungry + mood + health) / 3);
    }

    @Override
    public String toString() {
        return  String.format("| %6S | %7d | %8.0f | %10.0f | %7.0f | %15.0f |", name, age, health, mood, hungry, getAverage());
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
        this.hungry = hungry;
    }

    public void setMood(double mood) {
        this.mood = mood;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setActed(boolean acted) {
        isActed = acted;
    }
}
