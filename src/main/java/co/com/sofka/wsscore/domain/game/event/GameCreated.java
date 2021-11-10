package co.com.sofka.wsscore.domain.game.event;

import co.com.sofka.wsscore.domain.generic.DomainEvent;

public class GameCreated extends DomainEvent {

    private final String name;
    private final boolean state;

    public GameCreated(String name, boolean state) {
        super("sofkau.program.gamecreated");
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public boolean isState() {
        return state;
    }
}
