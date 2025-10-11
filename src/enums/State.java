package enums;

import interfaces.CureCat;
import interfaces.FeedCat;
import interfaces.PlayCat;
import interfaces.Strategy;
import models.Cat;

public enum State {
    FEEDED(new FeedCat()),
    CURED(new CureCat()),
    PLAYED(new PlayCat());

    private final Strategy strategy;

    State(Strategy strategy) {
        this.strategy = strategy;
    }

    public void changeState(Cat cat) {
        strategy.changeState(cat);
    }
//    public abstract void cureCat(Cat cat);
//    public abstract void playCat(Cat cat);
}
