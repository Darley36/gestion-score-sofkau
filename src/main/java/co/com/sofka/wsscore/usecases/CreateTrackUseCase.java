package co.com.sofka.wsscore.usecases;

import co.com.sofka.wsscore.domain.game.Game;
import co.com.sofka.wsscore.domain.game.Track;
import co.com.sofka.wsscore.domain.game.command.CreateGameCommand;
import co.com.sofka.wsscore.domain.game.command.CreateTrackCommand;
import co.com.sofka.wsscore.domain.generic.DomainEvent;
import co.com.sofka.wsscore.domain.generic.EventStoreRepository;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateTrackUseCase implements Function<CreateTrackCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public CreateTrackUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(CreateTrackCommand command){
        var events = repository.getEventsBy("program", command.getGameId());
        var game = Game.from(command.getGameId(), events);

        game.createTrack(command.getLength(), command.getNumberOfHorses(), command.getName());
        return game.getUncommittedChanges();
    }
}
