package co.com.sofka.wsscore.infra.entrypoint;


import co.com.sofka.wsscore.domain.game.command.*;
import co.com.sofka.wsscore.domain.program.command.AddCourseCommand;
import co.com.sofka.wsscore.domain.program.command.AssignScoreCommand;
import co.com.sofka.wsscore.domain.program.command.CreateProgramCommand;
import io.vertx.mutiny.core.eventbus.EventBus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class CommandController {

    private final EventBus bus;

    public CommandController(EventBus bus){
        this.bus = bus;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/assignScore")
    public Response executor(AssignScoreCommand command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createProgram")
    public Response executor(CreateProgramCommand command) {
        bus.publish(command.getType(), command);//emitir comandos, los casos de uso
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addCourse")
    public Response executor(AddCourseCommand command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/game/createGame")
    public Response executor(CreateGameCommand command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/game/addHorse")
    public Response executor(AddHorseCommand command) {
        System.out.println(command.getHorses().get(0).getColor());
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/game/createTrack")
    public Response executor(CreateTrackCommand command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/game/startGame")
    public Response executor(StartGameCommand command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/game/moveHorse")
    public Response executor(MoveHorseCommand command) {
        bus.publish(command.getType(), command);
        return Response.ok().build();
    }

}