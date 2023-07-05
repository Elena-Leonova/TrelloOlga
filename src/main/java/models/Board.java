package models;

public class Board {
    String name;

    public String getName() {
        return name;
    }

    public Board withName(String name) {
        this.name = name;
        return this;
    }
}
