package model;

public enum Direction {

    NORTH {
        @Override
        public Direction nextClockwiseDirection() {
            return EAST;
        }

        @Override
        public Position moveAlong(Position position) {
            return new Position(position.x, position.y + 1);
        }
    },
    EAST {
        @Override
        public Direction nextClockwiseDirection() {
            return SOUTH;
        }

        @Override
        public Position moveAlong(Position position) {
            return new Position(position.x + 1, position.y);
        }
    },
    SOUTH {
        @Override
        public Direction nextClockwiseDirection() {
            return WEST;
        }

        @Override
        public Position moveAlong(Position position) {
            return new Position(position.x, position.y - 1);
        }
    },
    WEST {
        @Override
        public Direction nextClockwiseDirection() {
            return NORTH;
        }

        @Override
        public Position moveAlong(Position position) {
            return new Position(position.x - 1, position.y);
        }
    };


    public abstract Direction nextClockwiseDirection();

    /**
     * @param position start position
     * @return new position after move
     */
    public abstract Position moveAlong(Position position);
}


