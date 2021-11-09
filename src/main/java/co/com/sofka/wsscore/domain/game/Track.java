package co.com.sofka.wsscore.domain.game;

import co.com.sofka.wsscore.domain.game.event.HorseAssigned;
import co.com.sofka.wsscore.domain.game.event.TrackCreated;
import co.com.sofka.wsscore.domain.generic.AggregateRoot;
import co.com.sofka.wsscore.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class Track extends AggregateRoot {
    protected Map<String, Horse> horses;
    protected String name;

    public Track(String trackId, String name) {
        super(trackId);
        subscribe(new TrackEventChange(this));
        appendChange(new TrackCreated(name)).apply();
    }

    private Track(String id){
        super(id);
        subscribe(new TrackEventChange(this));
    }

    public static Track from(String id, List<DomainEvent> events){
        System.out.println("domain 17 "+events);
        var track = new Track(id);
        events.forEach(track::applyEvent);
        return track;
    }

    public String name() {
        return name;
    }

    public void addHorse(String horsesId, String name,List<String> horses){
        appendChange(new HorseAssigned(horsesId,name,horses)).apply();
    }
}
