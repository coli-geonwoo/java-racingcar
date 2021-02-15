package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarGameProgressView {
    private static final String RESULT_HEADER_MESSAGE = "\n실행 결과";

    public void printProgressResult(final Cars cars) {
        System.out.println(RESULT_HEADER_MESSAGE);
        for (Car car : cars.getCars()) {
            printCarStatus(car);
        }
    }

    private void printCarStatus(final Car car) {
        String carStatus = String.format("%s : %s", car.getName(), getCarProgressBarStatus(car.getPosition()));
        System.out.println(carStatus);
    }

    private StringBuilder getCarProgressBarStatus(final int carPosition) {
        StringBuilder progressBarStatus = new StringBuilder();
        for (int i = 0; i < carPosition; ++i) {
            progressBarStatus.append('-');
        }
        return progressBarStatus;
    }
}