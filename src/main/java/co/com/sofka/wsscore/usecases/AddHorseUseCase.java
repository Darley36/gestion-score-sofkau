package co.com.sofka.wsscore.usecases;

import co.com.sofka.wsscore.domain.game.Track;
import co.com.sofka.wsscore.domain.game.command.AddHorseCommand;
import co.com.sofka.wsscore.domain.generic.DomainEvent;
import co.com.sofka.wsscore.domain.generic.EventStoreRepository;
import co.com.sofka.wsscore.domain.program.Program;
import co.com.sofka.wsscore.domain.program.command.AddCourseCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AddHorseUseCase implements Function<AddHorseCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AddHorseUseCase(EventStoreRepository repository){
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AddHorseCommand command) {
        var events = repository.getEventsBy("program", command.getTrackId());
        var program = Track.from(command.getTrackId(), events);

        program.addHorse(command.getHorseId(),command.getName(), command.getHorses());
        return program.getUncommittedChanges();
    }
}
