import models.Cat;
import models.CatsManager;
import util.Json;

import java.util.Comparator;
import java.util.List;

public class Application {
    public static void runApplication() {
        CatsManager cats = Json.read("cats.json");
        List<Cat> catsList = cats.getCatList();

        cats.showCatList();

        cats.addCat();
        cats.showCatList();

//        catsList.forEach(System.out::println);
//
//        catsList.sort(Comparator.comparing(Cat::getAverage).reversed());
//
//        catsList.forEach(System.out::println);

//        Json.write("cats.json", cats);
    }
}
