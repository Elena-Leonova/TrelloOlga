package models;

public class WorkSpace {
    String name;

    public String getName() {
        return name;
    }

    public WorkSpace withName(String name) {
        this.name = name;
        return this;
    }
}
