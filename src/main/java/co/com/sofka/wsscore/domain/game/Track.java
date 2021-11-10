package co.com.sofka.wsscore.domain.game;

public class Track {
    private int length;
    private int numberOfHorses;
    private String name;

    public Track() {
    }

    public Track(int length, int numberOfHorses, String name) {
        this.length = length;
        this.numberOfHorses = numberOfHorses;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumberOfHorses() {
        return numberOfHorses;
    }

    public void setNumberOfHorses(int numberOfHorses) {
        this.numberOfHorses = numberOfHorses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
