package co.com.sofka.wsscore.domain.game.event;

import co.com.sofka.wsscore.domain.generic.DomainEvent;

import java.util.List;

public class HorseAssigned extends DomainEvent {

    private final String horsesId;
    private final String name;
    private final List<String> horses;

    public HorseAssigned(String horsesId, String name, List<String> horses) {
        super("sofkau.program.horseassigned");
        this.horsesId = horsesId;
        this.name = name;
        this.horses = horses;
    }


    public List<String> getHorses() {
        return horses;
    }

    public String getHorsesId() {
        return horsesId;
    }

    public String getName() {
        return name;
    }
}
