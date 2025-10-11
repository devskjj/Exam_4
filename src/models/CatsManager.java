package models;

import java.util.ArrayList;
import java.util.List;

public class CatsManager {
    private List<Cat> catsList;

    public CatsManager() {
        this.catsList = new ArrayList<>();
    }

    public List<Cat> getCatsList() {
        return catsList;
    }
}
