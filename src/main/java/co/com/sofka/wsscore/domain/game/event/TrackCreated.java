package co.com.sofka.wsscore.domain.game.event;

import co.com.sofka.wsscore.domain.generic.DomainEvent;

public class TrackCreated extends DomainEvent {

    private final String name;

    public TrackCreated(String name) {
        super("sofkau.program.trackcreated");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
