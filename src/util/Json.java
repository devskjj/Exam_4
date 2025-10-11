package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.CatsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Json {
    private static Gson getGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public static CatsManager read(String fileName) {
        var filePath = Path.of("data", fileName);
        CatsManager cats = new CatsManager();
        try {
            cats = getGson().fromJson(Files.readString(filePath), CatsManager.class);
        } catch (IOException e) {
            System.out.println("Выбранного файла не существует, он пустой или содержит данные в неверном формате.");
            e.printStackTrace();
        }
        return cats;
    }

    public static void write(String fileName, CatsManager cats) {
        var filePath = Path.of("data", fileName);
        var json = getGson().toJson(cats);
        try {
            Files.writeString(filePath, json);
        } catch (IOException e) {
            System.out.println("Запись не удалась. Повторите попытку.");
            e.printStackTrace();
        }
    }
}
