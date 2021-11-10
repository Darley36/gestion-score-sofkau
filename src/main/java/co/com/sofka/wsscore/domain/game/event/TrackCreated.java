package co.com.sofka.wsscore.domain.game.event;

import co.com.sofka.wsscore.domain.generic.DomainEvent;

public class TrackCreated extends DomainEvent {

    private final int length;
    private final int numberOfHorses;
    private final String name;

    public TrackCreated(int length, int numberOfHorses, String name) {
        super("sofkau.program.trackcreated");
        this.length = length;
        this.numberOfHorses = numberOfHorses;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public int getNumberOfHorses() {
        return numberOfHorses;
    }

    public String getName() {
        return name;
    }
}
