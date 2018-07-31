package service;

import command.MoveCommand;
import command.TurnClockWiseCommand;
import model.Tractor;

import java.util.function.Function;

public class CommandParserImpl implements CommandParser {

    public static final String MOVE = "F";
    public static final String TURN = "T";

    public CommandParserImpl() {
    }

    @Override
    public Function<Tractor, Tractor> parseCommand(String action) {
        switch (action) {
            case MOVE:
                return new MoveCommand();
            case TURN:
                return new TurnClockWiseCommand();
            default:
                throw new IllegalArgumentException("unknown action: " + action);
        }
    }
}