package co.com.sofka.wsscore.domain.game.event;

import co.com.sofka.wsscore.domain.generic.DomainEvent;

public class GameStarted extends DomainEvent {
    public GameStarted() {
        super("sofkau.program.gamestarted");
    }
}
