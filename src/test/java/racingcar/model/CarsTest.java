package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CarsTest {
    Car car1, car2, car3;
    Cars cars;

    @BeforeEach
    void initialize() {
        car1 = new Car("pobi");
        car2 = new Car("crong");
        car3 = new Car("honux");
        cars = new Cars(Arrays.asList(car1, car2, car3));
    }

    @Test
    void 단독_우승자() {
        car1.forward(true);
        Assertions.assertThat(cars.findWinners()).containsExactly("pobi");
    }

    @Test
    void 공동_우승자() {
        car1.forward(true);
        car2.forward(true);
        Assertions.assertThat(cars.findWinners()).containsExactly("pobi", "crong");
    }
}