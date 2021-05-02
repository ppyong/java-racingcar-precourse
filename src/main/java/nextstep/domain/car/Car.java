package nextstep.domain.car;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final static int MIN_MOVE_POSITION = 4;
    private final static int MAX_NAME_LENGTH = 5;

    private String name;
    private Position position;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름은 5자리를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = new Position();
    }

    public String getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move(int move) {
        if (isMoveAvailable(move)) {
            this.position = position.move(move);
        }
    }

    private boolean isMoveAvailable(int power) {
        if (power >= MIN_MOVE_POSITION) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position.getValue(), car.position.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position.getValue());
    }

    @Override
    public int compareTo(Car car) {
        return this.getPosition().getValue() - car.getPosition().getValue();
    }
}
