package service;

import command.MoveCommand;
import command.TurnClockWiseCommand;
import model.Tractor;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class CommandParserImplTest {
    private final CommandParser parser = new CommandParserImpl();

    @Test
    public void parseCorrectCommandTest(){
        Assert.assertTrue(parser.parseCommand(CommandParserImpl.TURN) instanceof TurnClockWiseCommand);
        Assert.assertTrue(parser.parseCommand(CommandParserImpl.MOVE) instanceof MoveCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseIllegalCommandTest(){
        Assert.assertTrue(parser.parseCommand("invalid") instanceof TurnClockWiseCommand);
    }
}
