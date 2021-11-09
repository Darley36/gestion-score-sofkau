package co.com.sofka.wsscore.domain.game;

import co.com.sofka.wsscore.domain.game.event.TrackCreated;
import co.com.sofka.wsscore.domain.generic.EventChange;

import java.util.HashMap;

public class TrackEventChange implements EventChange {

    public TrackEventChange(Track track){
        listener((TrackCreated event)-> {
            track.name = event.getName();
            track.horses = new HashMap<>();
        });
    }
}
