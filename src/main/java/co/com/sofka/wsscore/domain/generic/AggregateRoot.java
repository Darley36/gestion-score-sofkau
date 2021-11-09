package co.com.sofka.wsscore.domain.generic;

import java.util.List;

public abstract class AggregateRoot {

    private final String id;
    private final ChangeEventSubscriber changeEventSubscriber;

    protected AggregateRoot(String id) {
        this.id = id;
        this.changeEventSubscriber = new ChangeEventSubscriber();
    }

    protected final void subscribe(EventChange eventChange) {
        System.out.println("domain 1 "+eventChange);
        changeEventSubscriber.subscribe(eventChange);
    }

    protected ChangeEventSubscriber.ChangeApply appendChange(DomainEvent event) {
        event.setAggregateId(id);
        System.out.println("domain 2 "+event);
        return changeEventSubscriber.appendChange(event);
    }

    protected void applyEvent(DomainEvent domainEvent) {
        System.out.println("domain 3 "+domainEvent);
        changeEventSubscriber.applyEvent(domainEvent);
    }

    public List<DomainEvent> getUncommittedChanges() {
        System.out.println("domain 4 getUncommittedChanges");
        return List.copyOf(changeEventSubscriber.getChanges());
    }
}
