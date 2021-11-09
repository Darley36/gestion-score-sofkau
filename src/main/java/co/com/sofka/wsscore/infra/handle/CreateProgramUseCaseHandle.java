package co.com.sofka.wsscore.infra.handle;

import co.com.sofka.wsscore.domain.program.command.CreateProgramCommand;
import co.com.sofka.wsscore.infra.generic.UseCaseHandle;
import co.com.sofka.wsscore.usecases.CreateProgramUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateProgramUseCaseHandle extends UseCaseHandle {

    private final CreateProgramUseCase createProgramUseCase;

    public CreateProgramUseCaseHandle(CreateProgramUseCase createProgramUseCase) {
        this.createProgramUseCase = createProgramUseCase;
        System.out.println("infra 26" + createProgramUseCase);
    }

    @ConsumeEvent(value = "sofkau.program.createprogram")
    void consumeBlocking(CreateProgramCommand command) {
        var events = createProgramUseCase.apply(command);
        events.forEach(domainEvent -> System.out.println("infra 27" + domainEvent.getAggregateId()+ " " + domainEvent.getType() + " "+domainEvent.getInstant()+ " " + domainEvent.getId()));
        System.out.println("infra 28");
        saveProgram(command.getProgramId(), events);
    }
}