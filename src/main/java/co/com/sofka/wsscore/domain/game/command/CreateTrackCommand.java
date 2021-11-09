package co.com.sofka.wsscore.domain.game.command;

import co.com.sofka.wsscore.domain.generic.Command;

public class CreateTrackCommand extends Command {

    private String trackId;
    private String name;

    public CreateTrackCommand(){

    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
