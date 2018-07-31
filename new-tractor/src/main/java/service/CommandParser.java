package service;

import model.Tractor;

import java.util.function.Function;

public interface CommandParser {
    Function<Tractor, Tractor> parseCommand(String action);
}
