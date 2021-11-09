package co.com.sofka.wsscore.domain.generic;

import java.util.*;
import java.util.function.Consumer;

public class ChangeEventSubscriber {
    private final List<DomainEvent> changes = new LinkedList<>();
    private final Set<Consumer<? super DomainEvent>> observables = new HashSet<>();


    public List<DomainEvent> getChanges() {
        return changes;
    }


    public final ChangeApply appendChange(DomainEvent event) {
        System.out.println("domain 5 "+event);
        changes.add(event);
        return () -> applyEvent(event);
    }


    public final void subscribe(EventChange eventChange) {
        System.out.println("domain 6"+eventChange);
        this.observables.addAll(eventChange.behaviors);
    }


    public final void applyEvent(DomainEvent domainEvent) {
        System.out.println("domain 7"+domainEvent);
        observables.forEach(consumer -> {
            try {
                consumer.accept(domainEvent);
            } catch (ClassCastException ignored) {
            }
        });
    }



    @FunctionalInterface
    public interface ChangeApply {
        /**
         * Apply.
         */
        void apply();
    }

}