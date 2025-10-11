package models;

import jdk.jshell.execution.Util;
import util.UserInput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CatsManager {
    private List<Cat> catsList;

    public CatsManager() {
        this.catsList = new ArrayList<>();
    }

    public void addCat() {
        Cat cat = new Cat();
        Random random= new Random();

        System.out.println("Введите имя кота");
        cat.setName(UserInput.getStrInput());

        System.out.println("Введите возраст кота");
        cat.setAge(UserInput.getIntInput(1, 18));

        cat.setHealth(20 + (80 - 20) * random.nextDouble());
        cat.setMood(20 + (80 - 20) * random.nextDouble());
        cat.setHungry(20 + (80 - 20) * random.nextDouble());

        this.catsList.add(cat);
    }

    public void showCatList() {
        System.out.printf("| %8s | %7s | %7s | %10s | %7s | %15s |%n", "Имя", "Возраст", "Здоровье", "Настроение", "Сытость", "Средний уровень");
        catsList.stream().sorted(Comparator.comparing(Cat::getAverage).reversed()).forEach(System.out::println);
    }

    public List<Cat> getCatList() {
        return catsList;
    }
}
