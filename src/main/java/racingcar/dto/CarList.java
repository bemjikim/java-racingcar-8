package racingcar.dto;

public class CarList {
    private final String name;
    private int moveCount;

    public CarList(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public void moveFoward() {
        this.moveCount++;
    }

    public void moveBackward() {}

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
