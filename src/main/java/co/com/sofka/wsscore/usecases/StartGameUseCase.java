package co.com.sofka.wsscore.usecases;

import co.com.sofka.wsscore.domain.game.Game;
import co.com.sofka.wsscore.domain.game.command.StartGameCommand;
import co.com.sofka.wsscore.domain.generic.DomainEvent;
import co.com.sofka.wsscore.domain.generic.EventStoreRepository;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class StartGameUseCase implements Function<StartGameCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public StartGameUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(StartGameCommand command){
        var events = repository.getEventsBy("program", command.getGameId());
        var game = Game.from(command.getGameId(), events);
        game.startGame();
        return game.getUncommittedChanges();
    }
}
