package nextstep.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupGeneratorTest {

    @Test
    @DisplayName("자동차 그룹 생성 실패 테스트")
    void test001CreateCarGroupSuccessTest() {
        assertThatThrownBy(() -> {
            CarGroupGenerator.create(null);
        }).isInstanceOf(RuntimeException.class).hasMessage("적합하지 않은 자동차명 입니다.");
    }

    @Test
    @DisplayName("자동차 그룹 생성 성공 테스트")
    void test002CreateCarGroupSuccessTest() {
        CarGroup carGroup = CarGroupGenerator.create("a,b,c");
        assertThat(carGroup.getCarList()).contains(new Car("a"), new Car("b"), new Car("c"));
    }
}