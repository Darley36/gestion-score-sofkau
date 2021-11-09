package co.com.sofka.wsscore.domain.game;

import java.util.Objects;

public class Horse {
    private final String id;
    private final String name;

    public Horse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String id() {
        return id;
    }
    public String name() {
        return name;
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
