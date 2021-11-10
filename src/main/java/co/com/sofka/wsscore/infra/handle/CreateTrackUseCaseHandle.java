package co.com.sofka.wsscore.infra.handle;

import co.com.sofka.wsscore.domain.game.command.CreateGameCommand;
import co.com.sofka.wsscore.domain.game.command.CreateTrackCommand;
import co.com.sofka.wsscore.infra.generic.UseCaseHandle;
import co.com.sofka.wsscore.usecases.CreateGameUseCase;
import co.com.sofka.wsscore.usecases.CreateTrackUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateTrackUseCaseHandle extends UseCaseHandle {
    private final CreateTrackUseCase createTrackUseCase;

    public CreateTrackUseCaseHandle(CreateTrackUseCase createTrackUseCase) {
        this.createTrackUseCase = createTrackUseCase;
    }

    @ConsumeEvent(value = "sofkau.program.createtrack")
    void consumeBlocking(CreateTrackCommand command) {
        var events = createTrackUseCase.apply(command);
        saveProgram(command.getGameId(), events);
    }
}
