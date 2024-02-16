package service;

import domain.Car;

import java.util.List;

public class RacingGame {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_BOUNDARY_NUMBER = 4;

    public static List<String> getWinnerNames(List<Car> cars) {
        // TODO getter를 사용하지 않고 비교방식을 생각해보기
        // TODO 예외에 메시지를 담기
        int maxScore = cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(RuntimeException::new);

        List<String> winnerNames = cars.stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .toList();

        return winnerNames;
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
