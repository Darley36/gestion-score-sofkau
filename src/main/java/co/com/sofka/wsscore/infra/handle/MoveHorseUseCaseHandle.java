package co.com.sofka.wsscore.infra.handle;

import co.com.sofka.wsscore.domain.game.command.MoveHorseCommand;
import co.com.sofka.wsscore.domain.game.command.StartGameCommand;
import co.com.sofka.wsscore.infra.generic.UseCaseHandle;
import co.com.sofka.wsscore.usecases.MoveHorseUseCase;
import co.com.sofka.wsscore.usecases.StartGameUseCase;
import io.quarkus.vertx.ConsumeEvent;

public class MoveHorseUseCaseHandle extends UseCaseHandle {
    private final MoveHorseUseCase moveHorseUseCase;

    public MoveHorseUseCaseHandle(MoveHorseUseCase moveHorseUseCase) {
        this.moveHorseUseCase = moveHorseUseCase;
    }

    @ConsumeEvent(value = "sofkau.program.movehorse")
    void consumeBlocking(MoveHorseCommand command) {
        var events = moveHorseUseCase.apply(command);
        saveProgram(command.getGameId(), events);
    }
}
