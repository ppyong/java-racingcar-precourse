package nextstep;

import nextstep.domain.bot.GameBot;

public class Main {

    public static void main(String[] args) {
        GameBot gameBot = new GameBot();
        try {
            gameBot.run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
