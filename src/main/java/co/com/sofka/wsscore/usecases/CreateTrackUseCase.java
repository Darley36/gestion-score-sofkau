package co.com.sofka.wsscore.usecases;

import co.com.sofka.wsscore.domain.game.Track;
import co.com.sofka.wsscore.domain.game.command.CreateTrackCommand;
import co.com.sofka.wsscore.domain.generic.DomainEvent;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateTrackUseCase implements Function<CreateTrackCommand, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(CreateTrackCommand command){
        var track = new Track(command.getTrackId(), command.getName());
        return track.getUncommittedChanges();
    }
}
