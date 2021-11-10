package co.com.sofka.wsscore.infra.handle;


import co.com.sofka.wsscore.domain.game.command.CreateGameCommand;
import co.com.sofka.wsscore.infra.generic.UseCaseHandle;
import co.com.sofka.wsscore.usecases.CreateGameUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateGameUseCaseHandle extends UseCaseHandle {
    private final CreateGameUseCase createGameUseCase;

    public CreateGameUseCaseHandle(CreateGameUseCase createGameUseCase) {
        this.createGameUseCase = createGameUseCase;
    }

    @ConsumeEvent(value = "sofkau.program.creategame")
    void consumeBlocking(CreateGameCommand command) {
        var events = createGameUseCase.apply(command);
        saveProgram(command.getGameId(), events);
    }
}
