package command;

import model.Direction;
import model.Tractor;

import java.util.function.Function;


/**
 * change tractors direction on 90 degrees clockwise
 */
public class TurnClockWiseCommand implements Function<Tractor,Tractor> {

    @Override
    public Tractor apply(Tractor tractor) {
        Direction newDirection = changeDirectionClockwise(tractor);
        return new Tractor(newDirection, tractor.getCurrentPosition());
    }

    private Direction changeDirectionClockwise(Tractor tractor) {
        return tractor.getCurrentDirection().nextClockwiseDirection();
    }
}
