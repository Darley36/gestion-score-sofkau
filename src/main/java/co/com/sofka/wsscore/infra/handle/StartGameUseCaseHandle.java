package co.com.sofka.wsscore.infra.handle;

import co.com.sofka.wsscore.domain.game.command.CreateGameCommand;
import co.com.sofka.wsscore.domain.game.command.StartGameCommand;
import co.com.sofka.wsscore.infra.generic.UseCaseHandle;
import co.com.sofka.wsscore.usecases.CreateGameUseCase;
import co.com.sofka.wsscore.usecases.StartGameUseCase;
import io.quarkus.vertx.ConsumeEvent;

public class StartGameUseCaseHandle extends UseCaseHandle {
    private final StartGameUseCase startGameUseCase;

    public StartGameUseCaseHandle(StartGameUseCase startGameUseCase) {
        this.startGameUseCase = startGameUseCase;
    }

    @ConsumeEvent(value = "sofkau.program.startgame")
    void consumeBlocking(StartGameCommand command) {
        var events = startGameUseCase.apply(command);
        saveProgram(command.getGameId(), events);
    }
}
