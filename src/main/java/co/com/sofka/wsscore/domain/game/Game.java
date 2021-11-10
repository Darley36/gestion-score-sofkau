package co.com.sofka.wsscore.domain.game;

import co.com.sofka.wsscore.domain.game.event.GameStarted;
import co.com.sofka.wsscore.domain.game.event.HorseAssigned;
import co.com.sofka.wsscore.domain.game.event.GameCreated;
import co.com.sofka.wsscore.domain.game.event.TrackCreated;
import co.com.sofka.wsscore.domain.generic.AggregateRoot;
import co.com.sofka.wsscore.domain.generic.DomainEvent;
import co.com.sofka.wsscore.domain.program.event.ScoreAssigned;

import java.util.List;

public class Game extends AggregateRoot {
    protected List<Horse> horses;
    protected String name;
    protected Track track;
    protected boolean state;

    public Game(String gameId, String name, boolean state) {
        super(gameId);
        subscribe(new GameEventChange(this));
        appendChange(new GameCreated(name,state)).apply();
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

    public boolean state() {
        return state;
    }

    public String name() {
        return name;
    }

    public void addHorse(List<Horse> horses){
        appendChange(new HorseAssigned(horses)).apply();
    }

    public void createTrack(int length, int numberOfHorses, String name){
        appendChange(new TrackCreated(length, numberOfHorses, name)).apply();
    }

    public void startGame() {
        appendChange(new GameStarted()).apply();
    }
}
