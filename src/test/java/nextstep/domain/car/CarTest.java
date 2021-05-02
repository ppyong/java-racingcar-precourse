package nextstep.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("4이하 숫자 입력 시 이동 실패 테스트")
    void test001MoveFailTest() {
        Car car = new Car("abc");
        int initialPosition = car.getPosition().getValue();
        int movePosition = 1;
        car.move(movePosition);
        assertThat(car.getPosition().getValue()).isNotEqualTo(initialPosition + movePosition);
    }

    @Test
    @DisplayName("4이하 숫자 입력 시 이동 성공 테스트")
    void test002MoveSuccessTest() {
        Car car = new Car("abc");
        int initialPosition = car.getPosition().getValue();
        int movePosition = 5;
        car.move(movePosition);
        assertThat(car.getPosition().getValue()).isEqualTo(initialPosition + movePosition);
    }
}