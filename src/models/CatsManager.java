package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CatsManager {
    private List<Cat> catsList;

    public CatsManager() {
        this.catsList = new ArrayList<>();
    }

    public void showCatList() {
        System.out.printf("| %6S | %7s | %7s | %10s | %7s | %15s |%n", "Имя", "Возраст", "Здоровье", "Настроение", "Сытость", "Средний уровень");
        catsList.stream().sorted(Comparator.comparing(Cat::getAverage).reversed()).forEach(cat -> {
            System.out.println((cat.isActed() ? "* " : "") + cat);
        });
    }

    public List<Cat> getCatList() {
        return catsList;
    }
}
