package command;


import model.Direction;
import model.Position;
import model.Tractor;

import java.util.function.Function;

/**
 * moves tractor forward for 1 step
 */
public class MoveCommand implements Function<Tractor,Tractor> {

    @Override
    public Tractor apply(Tractor tractor) {
        Direction tractorCurrentDirection = tractor.getCurrentDirection();
        Position tractorCurrentPosition = tractor.getCurrentPosition();
        return new Tractor(tractorCurrentDirection,tractorCurrentDirection.moveAlong(tractorCurrentPosition));
    }
}
