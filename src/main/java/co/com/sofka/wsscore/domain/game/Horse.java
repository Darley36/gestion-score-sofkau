package co.com.sofka.wsscore.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Horse {
    private final String id;
    private final String name;
    private final List<String> horses;

    public Horse(String id, String name) {
        this.id = id;
        this.name = name;
        this.horses = new ArrayList<>();
    }

    public String id() {
        return id;
    }
    public String name() {
        return name;
    }
    public  List<String> horses() {
        return horses;
    }

    public void addHorse(String horse){
        horses.add(horse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(id, horse.id) && Objects.equals(name, horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
