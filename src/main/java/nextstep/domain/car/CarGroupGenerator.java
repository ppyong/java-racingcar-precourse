package nextstep.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarGroupGenerator {

    public static CarGroup create(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new RuntimeException("적합하지 않은 자동차명 입니다.");
        }

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            carList.add(new Car(carName));
        }
        return new CarGroup(carList);
    }
}
