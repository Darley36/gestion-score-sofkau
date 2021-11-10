package co.com.sofka.wsscore.domain.game.command;

import co.com.sofka.wsscore.domain.generic.Command;

public class CreateGameCommand extends Command {

    private String gameId;
    private String name;
    private boolean state;

    public CreateGameCommand(){

    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
