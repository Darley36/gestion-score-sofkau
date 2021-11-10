package co.com.sofka.wsscore.domain.game.event;

import co.com.sofka.wsscore.domain.game.Horse;
import co.com.sofka.wsscore.domain.generic.DomainEvent;

import java.util.List;

public class HorseAssigned extends DomainEvent {




    private final List<Horse> horses;

    public HorseAssigned(List<Horse> horses) {
        super("sofkau.program.horseassigned");



        this.horses = horses;
    }


    public List<Horse> getHorses() {
        return horses;
    }


}
