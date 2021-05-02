package nextstep.domain.car;

public class Position {

    private int value;

    public int getValue() {
        return this.value;
    }

    public Position move(int move) {
        return new Position();
    }
}
