package co.com.sofka.wsscore.usecases;

import co.com.sofka.wsscore.domain.game.Game;
import co.com.sofka.wsscore.domain.game.command.MoveHorseCommand;
import co.com.sofka.wsscore.domain.game.command.StartGameCommand;
import co.com.sofka.wsscore.domain.generic.DomainEvent;
import co.com.sofka.wsscore.domain.generic.EventStoreRepository;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class MoveHorseUseCase implements Function<MoveHorseCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public MoveHorseUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(MoveHorseCommand command){
        var events = repository.getEventsBy("program", command.getGameId());
        var game = Game.from(command.getGameId(), events);
        game.moveHorse();
        return game.getUncommittedChanges();
    }
}
