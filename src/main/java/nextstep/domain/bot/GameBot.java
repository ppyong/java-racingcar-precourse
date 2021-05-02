package nextstep.domain.bot;

import java.util.List;
import java.util.Scanner;
import nextstep.domain.car.Car;
import nextstep.domain.car.CarGroup;
import nextstep.domain.car.CarGroupGenerator;
import nextstep.utils.StringUtils;

public class GameBot {

    private Scanner scanner;

    private void init() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        init();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.nextLine();

        CarGroup carGroup = CarGroupGenerator.create(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int runningCount = scanner.nextInt();

        start(runningCount, carGroup);

        printTopWinnerCar(carGroup.findWinnerCarList());

        destroy();
    }

    private void start(int count, CarGroup carGroup) {
        for (int i = 0; i < count; i++) {
            carGroup.move();
            printCarPosition(carGroup);
        }
    }

    private void printCarPosition(CarGroup carGroup) {
        List<Car> carList = carGroup.getCarList();
        for (Car car : carList) {
            System.out
              .println(String.format("%s: %s", car.getName().getValue(),
                                     StringUtils.padLeft("-", car.getPosition().getValue())));
        }
        System.out.println();
    }

    public void printTopWinnerCar(List<Car> carList) {
        System.out.println(String.format("%s가 최종 우승했습니다.", getNames(carList)));
    }

    private String getNames(List<Car> carList) {
        StringBuilder builder = new StringBuilder();
        for (Car c : carList) {
            builder.append(c.getName().getValue());
            builder.append(",");
        }
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
        return builder.toString();
    }

    private void destroy() {
        scanner.close();
    }
}
