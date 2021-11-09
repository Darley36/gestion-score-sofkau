package co.com.sofka.wsscore.infra.generic;

import co.com.sofka.wsscore.domain.generic.Command;
import co.com.sofka.wsscore.domain.generic.DomainEvent;

import java.lang.reflect.Type;

public final class CommandSerializer extends AbstractSerializer {

    private static co.com.sofka.wsscore.infra.generic.CommandSerializer commandSerializer;

    private CommandSerializer() {
        super();
    }

    public static synchronized co.com.sofka.wsscore.infra.generic.CommandSerializer instance() {
        if (co.com.sofka.wsscore.infra.generic.CommandSerializer.commandSerializer == null) {
            co.com.sofka.wsscore.infra.generic.CommandSerializer.commandSerializer = new co.com.sofka.wsscore.infra.generic.CommandSerializer();
        }
        System.out.println("infra 8" + commandSerializer);
        return co.com.sofka.wsscore.infra.generic.CommandSerializer.commandSerializer;
    }


    public <T extends Command> T deserialize(String aSerialization, final Class<?> aType) {
        System.out.println("infra 9" + aSerialization);
        System.out.println("infra 10" + aType);
        return gson.fromJson(aSerialization, (Type) aType);
    }

    public String serialize(Command object) {
        System.out.println("infra 11" + object);
        return gson.toJson(object);
    }

}