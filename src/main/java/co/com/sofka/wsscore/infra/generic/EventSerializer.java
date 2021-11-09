package co.com.sofka.wsscore.infra.generic;

import co.com.sofka.wsscore.domain.generic.DomainEvent;

import java.lang.reflect.Type;

public final class EventSerializer extends AbstractSerializer {

    private static co.com.sofka.wsscore.infra.generic.EventSerializer eventSerializer;

    private EventSerializer() {
        super();
    }

    public static synchronized co.com.sofka.wsscore.infra.generic.EventSerializer instance() {
        if (co.com.sofka.wsscore.infra.generic.EventSerializer.eventSerializer == null) {
            co.com.sofka.wsscore.infra.generic.EventSerializer.eventSerializer = new co.com.sofka.wsscore.infra.generic.EventSerializer();
        }
        System.out.println("infra 13" + eventSerializer);
        return co.com.sofka.wsscore.infra.generic.EventSerializer.eventSerializer;
    }


    public <T extends DomainEvent> T deserialize(String aSerialization, final Class<?> aType) {
        System.out.println("infra 14" + aSerialization);
        System.out.println("infra 15" + aType);
        return gson.fromJson(aSerialization, (Type) aType);
    }

    public String serialize(DomainEvent object) {
        System.out.println("infra 16" + object);
        return gson.toJson(object);
    }

}