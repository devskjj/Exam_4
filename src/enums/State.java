package enums;

import models.Cat;

public enum State {
    FEEDED() {
        @Override
        public void changeState(Cat cat) {
            cat.feedCat();
        }
    },
    CURED() {
        @Override
        public void changeState(Cat cat) {
            cat.cureCat();
        }
    },
    PLAYED() {
        @Override
        public void changeState(Cat cat) {
            cat.playCat();
        }
    };


    public abstract void changeState(Cat cat);
//    public abstract void cureCat(Cat cat);
//    public abstract void playCat(Cat cat);
}
