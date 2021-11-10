package co.com.sofka.wsscore.domain.game.command;

import co.com.sofka.wsscore.domain.generic.Command;

public class CreateTrackCommand extends Command {

    private  int length;
    private  int numberOfHorses;
    private  String name;
    private String gameId;

    public CreateTrackCommand() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumberOfHorses() {
        return numberOfHorses;
    }

    public void setNumberOfHorses(int numberOfHorses) {
        this.numberOfHorses = numberOfHorses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
