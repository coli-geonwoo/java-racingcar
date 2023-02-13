package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerMakerTest {
    @Test
    @DisplayName("승자를 정확히 가려내는지 확인한다")
    void prizeWinnersTest() {
        Cars cars = new Cars(List.of("박정훈", "김혜수", "윤예지", "원하연"));
        List<Car> movedCars = cars.getLatestResult();
        movedCars.stream()
                .filter(car -> car.getName().equals("박정훈"))
                .forEach(car -> car.move(new TestNumberGenerator(4)));

        assertThat(WinnerMaker.getWinnerCarsName(cars.getLatestResult()))
                .isEqualTo(List.of("박정훈"));
    }
}
