package co.com.sofka.wsscore.infra.materialize;

import co.com.sofka.wsscore.domain.game.event.HorseAssigned;
import co.com.sofka.wsscore.domain.game.event.TrackCreated;
import co.com.sofka.wsscore.domain.program.event.CourseAssigned;
import co.com.sofka.wsscore.domain.program.event.ProgramCreated;
import co.com.sofka.wsscore.domain.program.event.ScoreAssigned;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class ProgramHandle {
    private final MongoClient mongoClient;

    public ProgramHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }


    @ConsumeEvent(value = "sofkau.program.programcreated", blocking = true)
    void consumeProgramCreated(ProgramCreated event) {
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("name", event.getName());
        System.out.println("infra 29 " + document +" "+event.getName());
        mongoClient.getDatabase("queries")
                .getCollection("program")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofkau.program.trackcreated", blocking = true)
    void consumeProgramCreated(TrackCreated event) {
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("name", event.getName());
        mongoClient.getDatabase("queries")
                .getCollection("program")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofkau.program.horseassigned", blocking = true)
    void consumeHorseAssigned(HorseAssigned event) {
        BasicDBObject document = new BasicDBObject();
        document.put("horses."+event.getHorsesId()+".name",event.getName());
        event.getHorses().forEach(horses -> {
            var key = "horses."+event.getHorsesId()+".horses."+Math.abs(horses.hashCode());
            document.put(key+".name", horses);
        });

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);

        mongoClient.getDatabase("queries")
                .getCollection("program")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }

    @ConsumeEvent(value = "sofkau.program.courseassigned", blocking = true)
    void consumeCourseAssigned(CourseAssigned event) {
        BasicDBObject document = new BasicDBObject();
        document.put("courses."+event.getCourseId()+".name", event.getName());
        System.out.println("infra 30" + document);
        event.getCategories().forEach(category -> {
            var key = "courses."+event.getCourseId()+".categories."+Math.abs(category.hashCode());
            document.put(key+".name", category);
        });

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);

        mongoClient.getDatabase("queries")
                .getCollection("program")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }


    @ConsumeEvent(value = "sofkau.program.scoreassigned", blocking = true)
    void consumeScoreAssigned(ScoreAssigned event) {
        BasicDBObject document = new BasicDBObject();
        var key = "courses."+event.getCourseId()+".categories."+Math.abs(event.getCategory().hashCode());
        document.put(key+".scores."+Math.abs(event.getUser().hashCode())+".user", event.getUser());
        document.put(key+".scores."+Math.abs(event.getUser().hashCode())+".value", event.getValue());
        document.put(key+".scores."+Math.abs(event.getUser().hashCode())+".date", event.getDate());
        System.out.println("infra 31 " + document);
        BasicDBObject updateObject = new BasicDBObject();
        System.out.println("infra 32 " + updateObject);
        updateObject.put("$set", document);

        mongoClient.getDatabase("queries")
                .getCollection("program")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }
}