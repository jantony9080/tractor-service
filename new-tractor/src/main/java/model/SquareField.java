package model;

public class SquareField implements Field{

    private final int maxX;
    private final int maxY;

    /**
     *
     * @param maxX maximum allowed X coordinate. Must be positive number.
     * @param maxY maximum allowed Y coordinate. Must be positive number.
     * @throws IllegalArgumentException if either maxX or maxY is negative.
     */
    public SquareField(int maxX, int maxY) {
        if(maxX<0 || maxY <0){
            throw new IllegalArgumentException("Fiedls dimensions must bigger or equal to 0");
        }
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public boolean isOnTheField(Position position) {

        if (position.x > maxX || position.y > maxY) {
            return false;
        }
        return true;
    }
}
