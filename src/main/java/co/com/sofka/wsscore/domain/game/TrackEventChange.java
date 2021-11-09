package co.com.sofka.wsscore.domain.game;

import co.com.sofka.wsscore.domain.game.event.HorseAssigned;
import co.com.sofka.wsscore.domain.game.event.TrackCreated;
import co.com.sofka.wsscore.domain.generic.EventChange;
import co.com.sofka.wsscore.domain.program.Course;
import co.com.sofka.wsscore.domain.program.event.CourseAssigned;

import java.util.HashMap;

public class TrackEventChange implements EventChange {

    public TrackEventChange(Track track){
        listener((TrackCreated event)-> {
            track.name = event.getName();
            track.horses = new HashMap<>();
        });
        listener((HorseAssigned event) -> {
            var horse =  new Horse(event.getHorsesId(), event.getName());
            event.getHorses().forEach(horse::addHorse);
            track.horses.put(event.getHorsesId(), horse);
        });
    }
}
