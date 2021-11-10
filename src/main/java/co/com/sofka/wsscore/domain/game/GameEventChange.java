package co.com.sofka.wsscore.domain.game;

import co.com.sofka.wsscore.domain.game.event.HorseAssigned;
import co.com.sofka.wsscore.domain.game.event.GameCreated;
import co.com.sofka.wsscore.domain.generic.EventChange;

import java.util.ArrayList;
import java.util.HashMap;

public class GameEventChange implements EventChange {

    public GameEventChange(Game game){
        listener((GameCreated event)-> {
            game.name = event.getName();
            game.horses = new ArrayList<Horse>();
        });
        listener((HorseAssigned event) -> {

            game.horses = event.getHorses();
        });
    }
}
