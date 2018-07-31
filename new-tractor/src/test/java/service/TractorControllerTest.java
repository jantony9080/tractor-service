package service;

import exception.TractorInDitchException;
import model.Direction;
import model.Field;
import model.Position;
import model.SquareField;
import model.Tractor;
import org.junit.Assert;
import org.junit.Test;

public class TractorControllerTest {
    private final Field testField = new SquareField(2,2);
    @Test
    public void executeCommandsTest() throws TractorInDitchException {
        final Direction initialDirection = Direction.EAST;
        final Position initialPosition = new Position(0,0);
        final Tractor initialTractor = new Tractor(initialDirection,initialPosition);
        final TractorController controller = new TractorController(initialTractor,testField);

        controller.executeTractorAction("F");
        Assert.assertEquals(new Position(1,0),controller.getTractor().getCurrentPosition());
        Assert.assertEquals(initialDirection,controller.getTractor().getCurrentDirection());

        controller.executeTractorAction("F");
        Assert.assertEquals(new Position(2,0),controller.getTractor().getCurrentPosition());
        Assert.assertEquals(initialDirection,controller.getTractor().getCurrentDirection());

        controller.executeTractorAction("T");
        Assert.assertEquals(new Position(2,0),controller.getTractor().getCurrentPosition());
        Assert.assertEquals(Direction.SOUTH,controller.getTractor().getCurrentDirection());

        controller.executeTractorAction("T");
        Assert.assertEquals(new Position(2,0),controller.getTractor().getCurrentPosition());
        Assert.assertEquals(Direction.WEST,controller.getTractor().getCurrentDirection());

        controller.executeTractorAction("T");
        Assert.assertEquals(new Position(2,0),controller.getTractor().getCurrentPosition());
        Assert.assertEquals(Direction.NORTH,controller.getTractor().getCurrentDirection());

        controller.executeTractorAction("F");
        Assert.assertEquals(new Position(2,1),controller.getTractor().getCurrentPosition());
        Assert.assertEquals(Direction.NORTH,controller.getTractor().getCurrentDirection());
    }

    @Test(expected = TractorInDitchException.class)
    public void tractorInDitchTest() throws TractorInDitchException {
        final Direction initialDirection = Direction.EAST;
        final Position initialPosition = new Position(0,0);
        final Tractor initialTractor = new Tractor(initialDirection,initialPosition);
        final TractorController controller = new TractorController(initialTractor,testField);
        controller.executeTractorAction("F");
        controller.executeTractorAction("F");
        controller.executeTractorAction("F");
    }
}
