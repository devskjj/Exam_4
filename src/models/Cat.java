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
        this.age = age;
        this.hungry = hungry;
        this.mood = mood;
        this.health = health;
    }

    public Cat() {
        this.isActed = false;
    }

    public double getAverage() {
        return Math.ceil((hungry + mood + health) / 3);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hungry=" + hungry +
                ", mood=" + mood +
                ", health=" + health +
                ", average=" + getAverage() +
                '}';
    }
}
