package co.com.sofka.wsscore.usecases;

import co.com.sofka.wsscore.domain.game.Game;
import co.com.sofka.wsscore.domain.game.command.CreateGameCommand;
import co.com.sofka.wsscore.domain.generic.DomainEvent;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateGameUseCase implements Function<CreateGameCommand, List<DomainEvent>> {

    @Override
    public List<DomainEvent> apply(CreateGameCommand command){
        var game = new Game(command.getGameId(), command.getName());
        return game.getUncommittedChanges();
    }
}
