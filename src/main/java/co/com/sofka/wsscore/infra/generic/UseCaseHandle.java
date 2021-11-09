package co.com.sofka.wsscore.infra.generic;

import co.com.sofka.wsscore.domain.generic.DomainEvent;
import co.com.sofka.wsscore.domain.generic.EventStoreRepository;
import co.com.sofka.wsscore.domain.generic.StoredEvent;
import co.com.sofka.wsscore.infra.message.BusService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public abstract class UseCaseHandle {
    @Inject
    private  EventStoreRepository repository;

    @Inject
    private BusService busService;;

    public void saveProgram(String programId, List<DomainEvent> events) {
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            //events.forEach(domainEvent -> System.out.println("infra 20" + domainEvent.getAggregateId()+ " " + domainEvent.getType() + " "+domainEvent.getInstant()+ " " + domainEvent.getId()));
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("program", programId, storedEvent));

        events.forEach(busService::send);
    }
}
