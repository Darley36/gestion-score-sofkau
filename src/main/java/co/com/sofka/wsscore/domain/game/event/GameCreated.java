package co.com.sofka.wsscore.domain.game.event;

import co.com.sofka.wsscore.domain.generic.DomainEvent;

public class GameCreated extends DomainEvent {

    private final String name;

    public GameCreated(String name) {
        super("sofkau.program.gamecreated");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
