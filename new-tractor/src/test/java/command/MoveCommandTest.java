package command;

import model.Direction;
import model.Position;
import model.Tractor;
import org.junit.Assert;
import org.junit.Test;

public class MoveCommandTest {
    private final MoveCommand command = new MoveCommand();

    @Test
    public void positionChangeTest() {
        Position initialPosition = new Position(0, 0);
        Position expectedPosition = new Position(0, 1);

        Tractor t = new Tractor(Direction.NORTH, initialPosition);
        Tractor movedTractor = command.apply(t);
        Assert.assertEquals(expectedPosition, movedTractor.getCurrentPosition());
        Assert.assertNotEquals(expectedPosition, t.getCurrentPosition());
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
