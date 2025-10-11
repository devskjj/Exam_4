package models;

import util.UserInput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CatsManager {
    private List<Cat> catsList;

    public CatsManager() {
        this.catsList = new ArrayList<>();
    }

    public void addCat() {
        Cat cat = new Cat();
        Random random = new Random();

        System.out.println("Введите имя кота");
        cat.setName(UserInput.getStrInput());

        System.out.println("Введите возраст кота");
        cat.setAge(UserInput.getIntInput(1, 18));

        cat.setHealth(random.nextDouble(20, 80));
        cat.setMood(random.nextDouble(20, 80));
        cat.setHungry(random.nextDouble(20, 80));

        this.catsList.add(cat);
    }

    public void nextDay() {
        Random random = new Random();
        catsList.removeIf(cat -> {
            cat.setHungry(cat.getHungry() - random.nextDouble(1, 5));
            cat.setMood(cat.getMood() + random.nextDouble(-3, 3));
            cat.setHealth(cat.getHealth() + random.nextDouble(-3, 3));
            cat.setActed(false);

            if (cat.getHealth() <= 0) {
                System.out.println("Кот " + cat.getName() + " умер.");
                return true;
            }
            return false;
        });
    }

    public void showCatList() {
        System.out.printf("| %4s | %8s | %7s | %7s | %10s | %7s | %15s |%n", "#", "Имя", "Возраст", "Здоровье", "Настроение", "Сытость", "Средний уровень");

        IntStream.range(0, catsList.size()).forEach(i -> {
            System.out.printf("| %4d | %s%n", i + 1, catsList.get(i).toString());
        });
    }

    public void selectSort() {
        System.out.println("Выберите критерий по:\n" +
                "1 - Имени\n" +
                "2 - Возрасту\n" +
                "3 - Здоровью\n" +
                "4 - Настроению\n" +
                "5 - Сытости\n" +
                "6 - Среднему уровню\n" +
                "0 - Отмена");
        switch (UserInput.getIntInput(0, 6)) {
            case 1 -> catsList = sortBy(Comparator.comparing(Cat::getName).reversed());
            case 2 -> catsList = sortBy(Comparator.comparing(Cat::getAge).reversed());
            case 3 -> catsList = sortBy(Comparator.comparing(Cat::getHealth).reversed());
            case 4 -> catsList = sortBy(Comparator.comparing(Cat::getMood).reversed());
            case 5 -> catsList = sortBy(Comparator.comparing(Cat::getHungry).reversed());
            case 6 -> catsList = sortBy(Comparator.comparing(Cat::getAverage).reversed());
            case 0 -> {
                return;
            }
        }
    }

    public List<Cat> sortBy(Comparator<Cat> comparator) {
        return catsList.stream()
                .sorted(comparator)
                .toList();
    }

    public List<Cat> getCatList() {
        return catsList;
    }
}
