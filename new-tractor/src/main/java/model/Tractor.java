package model;

public class Tractor {

    private final Direction currentDirection;
    private final Position currentPosition;

    public Tractor(Direction direction, Position currentPosition){
        this.currentDirection = direction;
        this.currentPosition = new Position(currentPosition);
    }


    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }
}
