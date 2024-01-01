package chapter02;

import chapter02.Prob046.Player;

public class Prob055 {

    private static Player2 createPlayer(PlayerTypes playerType) {
        switch (playerType) {
            case TENNIS:
                return new TennisPlayer();
            case FOOTBALL:
                return new FootballPlayer();
            case SNOOKER:
                return new SnookerPlayer();
            case UNKNOWN:
                throw new RuntimeException("Player type is unknown");
            default:
                throw new IllegalArgumentException(
                    "Invalid player type: " + playerType
                );
        }
    }

    private static Player2 createPlayer2(PlayerTypes playerType) {
        Player2 player2 = null;

        Player2 player = null;

        switch (playerType) {
            case TENNIS:
                player = new TennisPlayer();
                break;
            case FOOTBALL:
                player = new FootballPlayer();
                break;
            case SNOOKER:
                player = new SnookerPlayer();
                break;
            case UNKNOWN:
                throw new RuntimeException("Player type is unknown");
            default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        }

        return player;
    }

    private static Player2 createPlayer3(PlayerTypes playerType) {
        return switch (playerType) {
            case TENNIS -> new TennisPlayer();
            case FOOTBALL -> new FootballPlayer();
            case SNOOKER -> new SnookerPlayer();
            case GOLF -> {
                int x = 5;
                yield new Player2();
            }
            case VOLLEY -> null;
            case UNKNOWN -> throw new RuntimeException();
        };
    }

}

class Player2 {

}

class SnookerPlayer extends Player2 {

}

class TennisPlayer extends Player2 {

}

class FootballPlayer extends Player2 {

}

enum PlayerTypes {
    TENNIS,
    FOOTBALL,
    SNOOKER,
    GOLF,
    VOLLEY,
    UNKNOWN
}
