package co.com.sofka.wsscore.domain.game;

import co.com.sofka.wsscore.domain.game.event.HorseAssigned;
import co.com.sofka.wsscore.domain.game.event.GameCreated;
import co.com.sofka.wsscore.domain.generic.EventChange;

import java.util.HashMap;

public class GameEventChange implements EventChange {

    public GameEventChange(Game game){
        listener((GameCreated event)-> {
            game.name = event.getName();
            game.horses = new HashMap<>();
        });
        listener((HorseAssigned event) -> {
            var horse =  new Horse(event.getHorsesId(), event.getName());
            event.getHorses().forEach(horse::addHorse);
            game.horses.put(event.getHorsesId(), horse);
        });
    }
}
