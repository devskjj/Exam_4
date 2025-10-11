import enums.State;
import interfaces.CureCat;
import interfaces.FeedCat;
import interfaces.PlayCat;
import models.Cat;
import models.CatsManager;
import util.Json;
import util.UserInput;

import java.util.List;

public class Application {
    public static void runApplication() {
        boolean run = true;

        CatsManager cats = Json.read("cats.json");
        List<Cat> catsList = cats.getCatList();

        cats.showCatList();

        while (run) {
            System.out.println("Выберите действие:\n" +
                    "1 - Покормить кота\n" +
                    "2 - Поиграть с котом\n" +
                    "3 - Лечить кота\n" +
                    "4 - Следующий день\n" +
                    "5 - Сортировать по критериям\n" +
                    "9 - Завести нового питомца\n" +
                    "0 - Выйти из программы");
            switch (UserInput.getIntInput(0, 9)) {
                case 1 -> catsList.get(chooseCat(catsList)).act(new FeedCat());
                case 2 -> catsList.get(chooseCat(catsList)).act(new PlayCat());
                case 3 -> catsList.get(chooseCat(catsList)).act(new CureCat());
                case 4 -> cats.nextDay();
                case 5 -> cats.selectSort();
                case 9 -> cats.addCat();
                case 0 -> run = false;
            }
            cats.showCatList();

            Json.write("cats.json", cats);
        }
    }

    public static int chooseCat(List<Cat> catsList) {
        System.out.println("Выберите номер кота, с которым хотите совершить действие.");
        return UserInput.getIntInput(1, catsList.size()) - 1;
    }
}
