package command;

import model.Direction;
import model.Position;
import model.Tractor;
import org.junit.Assert;
import org.junit.Test;

public class TurnClockWiseCommandTest {

    private final TurnClockWiseCommand command = new TurnClockWiseCommand();

    @Test
    public void testTurn() {
        Direction initialDirection = Direction.EAST;
        Direction expectedDirection = Direction.SOUTH;

        Tractor t = new Tractor(initialDirection, new Position(0, 0));
        Tractor newTractor = command.apply(t);

        Assert.assertEquals(expectedDirection, newTractor.getCurrentDirection());
        Assert.assertNotEquals(expectedDirection, t.getCurrentDirection());

        Tractor newTractor2 = command.apply(t);
        Assert.assertEquals(expectedDirection, newTractor2.getCurrentDirection());

    }

    @Test
    public void testNewInstance() {
        Direction initialDirection = Direction.EAST;
        Tractor t = new Tractor(initialDirection, new Position(0, 0));

        Tractor newTractor = command.apply(t);

        //should be immutable and create new instance
        Assert.assertFalse(newTractor == t);
        Assert.assertFalse(newTractor.getCurrentPosition() == t.getCurrentPosition());

    }


}
