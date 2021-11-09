package co.com.sofka.wsscore.infra.generic;


import co.com.sofka.wsscore.domain.generic.StoredEvent;

public final class StoredEventSerializer extends AbstractSerializer {

    private static co.com.sofka.wsscore.infra.generic.StoredEventSerializer eventSerializer;

    private StoredEventSerializer() {
        super();
    }


    public static synchronized co.com.sofka.wsscore.infra.generic.StoredEventSerializer instance() {
        if (co.com.sofka.wsscore.infra.generic.StoredEventSerializer.eventSerializer == null) {
            co.com.sofka.wsscore.infra.generic.StoredEventSerializer.eventSerializer = new co.com.sofka.wsscore.infra.generic.StoredEventSerializer();
        }
        System.out.println("infra 17" + eventSerializer);
        System.out.println("infra 18" + co.com.sofka.wsscore.infra.generic.StoredEventSerializer.eventSerializer);
        return co.com.sofka.wsscore.infra.generic.StoredEventSerializer.eventSerializer;
    }


    public StoredEvent deserialize(String aSerialization, Class<StoredEvent> aType) {
        return gson.fromJson(aSerialization, aType);
    }


    public String serialize(StoredEvent object) {
        return gson.toJson(object);
    }

}