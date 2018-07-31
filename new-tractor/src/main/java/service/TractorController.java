package service;

import exception.TractorInDitchException;
import model.Field;
import model.Tractor;

import java.util.function.Function;

/**
 *
 * The class controls the tractor.
 *
 */
public class TractorController {

    private final CommandParserImpl commandParser = new CommandParserImpl();
    private Tractor tractor;

    private final Field field;

    public TractorController(Tractor tractor, Field field) {
        this.tractor = tractor;
        this.field = field;
    }

    /**
     * @param action the action to be executed on tractor
     * @throws TractorInDitchException when tractor goes beyond the field
     */
    public void executeTractorAction(String action) throws TractorInDitchException {
        Function<Tractor,Tractor> command = commandParser.parseCommand(action);
        Tractor newTractor = command.apply(this.tractor);

        if (!field.isOnTheField(newTractor.getCurrentPosition())) {
            throw new TractorInDitchException();
        }

        this.tractor = newTractor;

    }

    public Tractor getTractor() {
        return tractor;
    }
}
