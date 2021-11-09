package co.com.sofka.wsscore.domain.game.command;

import co.com.sofka.wsscore.domain.generic.Command;

import java.util.List;

public class AddHorseCommand extends Command {
    private String trackId;
    private String horseId;
    private String name;
    private List<String> horses;

    public AddHorseCommand() {

    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getHorseId() {
        return horseId;
    }

    public void setHorseId(String horseId) {
        this.horseId = horseId;
    }

    public List<String> getHorses() {
        return horses;
    }

    public void setHorses(List<String> horses) {
        this.horses = horses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
