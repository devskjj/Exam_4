import enums.State;
import interfaces.CureCat;
import interfaces.FeedCat;
import interfaces.PlayCat;
import models.Cat;
import models.CatsManager;
import util.Json;
import util.UserInput;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Application {
    public static void runApplication() {
        boolean run = true;
        boolean nextDay = false;

        CatsManager cats = Json.read("cats.json");
        List<Cat> catsList = cats.getCatList();

//        cats.showCatList();
//
//        cats.addCat();


        while (run) {
            cats.showCatList();
            System.out.println("Выберите действие:\n" +
                    "1 - Покормить кота\n" +
                    "2 - Поиграть с котом\n" +
                    "3 - Лечить кота\n" +
                    "4 - Следующий день\n" +
                    "5 - Сортировать по критериям\n" +
                    "9 - Завести нового питомца\n" +
                    "0 - Выйти из программы");
            switch (UserInput.getIntInput(0, 9)) {
                case 1 -> catsList.get(chooseCat(catsList)).act(State.FEEDED);
                case 2 -> catsList.get(chooseCat(catsList)).act(State.PLAYED);
                case 3 -> catsList.get(chooseCat(catsList)).act(State.CURED);
                case 4 -> cats.nextDay();
                case 5 -> cats.selectSort();
                case 9 -> cats.addCat();
                case 0 -> run = false;
            }
//            cats.showCatList();

            Json.write("cats.json", cats);
        }


    }

    public static int chooseCat(List<Cat> catsList) {
        System.out.println("Выберите номер кота, с которым хотите совершить действие.");
        return UserInput.getIntInput(1, catsList.size()) - 1;
    }


}
