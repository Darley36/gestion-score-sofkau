package co.com.sofka.wsscore.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Horse {
    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String color;
    private  String name;

    public Horse(){

    }
    public Horse(String color, String name) {
        this.color = color;
        this.name = name;

    }

    public String getColor() {
        return color;
    }
    public String getName() {
        return name;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(color, horse.color) && Objects.equals(name, horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, name);
    }
}
