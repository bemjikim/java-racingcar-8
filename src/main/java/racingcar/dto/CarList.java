package racingcar.dto;

public class CarList {
    private static final int MOVING_FORWARD = 4;
    private final String name;
    private int moveCount;

    public CarList(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public void moveForward() {
        this.moveCount++;
    }

    public void checkMoveForward(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD) {
            moveForward();
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
