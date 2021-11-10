package co.com.sofka.wsscore.domain.game;

import co.com.sofka.wsscore.domain.game.event.HorseAssigned;
import co.com.sofka.wsscore.domain.game.event.GameCreated;
import co.com.sofka.wsscore.domain.generic.AggregateRoot;
import co.com.sofka.wsscore.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Game extends AggregateRoot {
    protected List<Horse> horses;
    protected String name;

    public Game(String gameId, String name) {
        super(gameId);
        subscribe(new GameEventChange(this));
        appendChange(new GameCreated(name)).apply();
    }

    private Game(String id){
        super(id);
        subscribe(new GameEventChange(this));
    }

    public static Game from(String id, List<DomainEvent> events){
        System.out.println("domain 17 "+events);
        var game = new Game(id);
        events.forEach(game::applyEvent);
        return game;
    }

    public String name() {
        return name;
    }

    public void addHorse(List<Horse> horses){
        appendChange(new HorseAssigned(horses)).apply();
    }
}
