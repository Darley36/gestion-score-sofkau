package co.com.sofka.wsscore.domain.game.event;

import co.com.sofka.wsscore.domain.generic.DomainEvent;

public class PositionChanged extends DomainEvent {

    public PositionChanged() {
        super("sofkau.program.positionchanged");
    }
}
