package nextstep.domain.car;

public class Position {

    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Position move(int move) {
        return new Position(this.value + move);
    }
}
