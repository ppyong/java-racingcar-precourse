package nextstep.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupTest {

    @Test
    @DisplayName("우승 자동차 구하기 테스트")
    void test001FindWinnerSuccessTest() {
        CarGroup carGroup = CarGroupGenerator.create("a,b,c");
        carGroup.move();
        List<Car> carList = carGroup.getCarList()
                                    .stream()
                                    .sorted()
                                    .collect(Collectors.toList());

        int winnerPosition = carList.get(carList.size() - 1).getPosition().getValue();
        for (Car car : carGroup.findWinnerCarList()) {
            assertThat(car.getPosition().getValue()).isEqualTo(winnerPosition);
        }
    }
}