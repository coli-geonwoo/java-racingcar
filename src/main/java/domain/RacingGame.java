package domain;

import java.util.Collections;
import java.util.List;

public class RacingGame {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_BOUNDARY_NUMBER = 4;

    public static List<Car> getWinners(List<Car> cars) {

        Collections.sort(cars);
        Car maxScoreCar = cars.get(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.compareTo(maxScoreCar) == 0)
                .toList();

        return winners;
    }

    public static void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            if (willMove()) {
                car.move();
            }
        }
    }

    //TODO 움직이는 로직의 확장성 고민해보기
    private static boolean willMove() {
        int randomNumber = (int) (Math.random() * RANDOM_NUMBER_RANGE);
        return randomNumber >= MOVE_BOUNDARY_NUMBER;
    }
}
