package co.com.sofka.wsscore.infra.generic;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.Instant;

/**
 * The type Abstract serializer.
 */
public abstract class AbstractSerializer {
    /**
     * The Gson.
     */
    protected Gson gson;

    /**
     * Instantiates a new Abstract serializer.
     */
    protected AbstractSerializer() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(Instant.class, new co.com.sofka.wsscore.infra.generic.AbstractSerializer.DateSerializer())
                .registerTypeAdapter(Instant.class, new co.com.sofka.wsscore.infra.generic.AbstractSerializer.DateDeserializer())
                .serializeNulls()
                .create();
    }

    /**
     * Gets gson.
     *
     * @return the gson
     */
    public Gson getGson() {
        return gson;
    }

    private static class DateSerializer implements JsonSerializer<Instant> {
        @Override
        public JsonElement serialize(Instant source, Type typeOfSource, JsonSerializationContext context) {
            System.out.println("Infra 1 " + source);
            System.out.println("Infra 2 " + typeOfSource);
            System.out.println("Infra 3 " + context);
            return new JsonPrimitive(Long.toString(source.toEpochMilli()));
        }
    }

    private static class DateDeserializer implements JsonDeserializer<Instant> {
        @Override
        public Instant deserialize(JsonElement json, Type typeOfTarget, JsonDeserializationContext context) {
            long time = Long.parseLong(json.getAsJsonPrimitive().getAsString());
            System.out.println("Infra 4" + json);
            System.out.println("Infra 5" + typeOfTarget);
            System.out.println("Infra 6" + context);
            System.out.println("Infra 7" + time);
            return Instant.ofEpochMilli(time);
        }
    }
}