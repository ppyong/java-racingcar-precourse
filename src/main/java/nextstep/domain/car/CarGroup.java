package nextstep.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import nextstep.utils.RandomGenerator;

public class CarGroup {

    private List<Car> carList;

    public CarGroup(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void move() {
        List<Car> carList = getCarList();
        for (Car car : carList) {
            int move = RandomGenerator.create();
            car.move(move);
        }
    }

    public List<Car> findWinnerCarList() {
        List<Car> sortedCarList = new ArrayList<>(this.carList);
        Collections.sort(sortedCarList, Comparator.reverseOrder());
        int topPosition = sortedCarList.get(0).getPosition().getValue();

        List<Car> result = new ArrayList<>();
        for (Car car : sortedCarList) {
            filter(result, car, item -> item.getPosition().getValue() == topPosition);
        }
        return result;
    }

    private void filter(List<Car> carList, Car car, Predicate<Car> predicate) {
        if (predicate.test(car)) {
            carList.add(car);
        }
    }
}
