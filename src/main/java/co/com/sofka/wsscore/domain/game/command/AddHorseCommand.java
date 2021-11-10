package co.com.sofka.wsscore.domain.game.command;

import co.com.sofka.wsscore.domain.game.Horse;
import co.com.sofka.wsscore.domain.generic.Command;

import java.util.List;

public class AddHorseCommand extends Command {
    private String gameId;

    private List<Horse> horses;

    public AddHorseCommand() {

    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }



    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }


}
