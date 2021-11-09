package co.com.sofka.wsscore.infra.handle;

import co.com.sofka.wsscore.domain.game.command.AddHorseCommand;
import co.com.sofka.wsscore.domain.program.command.AddCourseCommand;
import co.com.sofka.wsscore.infra.generic.UseCaseHandle;
import co.com.sofka.wsscore.usecases.AddCourseUseCase;
import co.com.sofka.wsscore.usecases.AddHorseUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddHorseUseCaseHandle extends UseCaseHandle {

    private final AddHorseUseCase addHorseUseCase;

    public AddHorseUseCaseHandle(AddHorseUseCase addHorseUseCase) {
        this.addHorseUseCase = addHorseUseCase;
    }

    @ConsumeEvent(value = "sofkau.program.addhorses")
    void consumeBlocking(AddHorseCommand command) {
        var events = addHorseUseCase.apply(command);
        saveProgram(command.getTrackId(), events);
    }
}
