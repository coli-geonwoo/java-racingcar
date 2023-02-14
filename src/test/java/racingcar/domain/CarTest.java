package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;
import racingcar.util.RandomIntGenerator;
import util.DeterminedIntGenerator;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Car.WRONG_LENGTH_OF_NAME_ANNOUNCEMENT;

class CarTest {

    @ParameterizedTest
    @DisplayName("1회 이동 시도")
    @CsvSource(value = {"1:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void shouldPlusOneAtMovedCountWhenMove(int number, int addedMovedCount) {
        // given
        Car targetCar = new Car("test", new DeterminedIntGenerator(number));
        // when
        targetCar.tryMove();
        // then
        assertThat(targetCar.getName()).isEqualTo(targetCar.getName()).as("이름이 같아야 한다.");
        assertThat(targetCar.getMovedCount()).isEqualTo(addedMovedCount)
                .as("tryMove 안에서 4가 넘는 숫자가 canMove로 전달되어야만 이동 횟수는 1이 더해진다.");
    }

    @Test
    @DisplayName("올바른 이름으로 생성")
    void shouldCreateCarCorrectlyWhenUseAppropriateName() {
        // given
        String appropriateName = "테스트이름";
        // when
        Car car = new Car(appropriateName, new RandomIntGenerator());
        // then
        assertThat(car.getName()).isEqualTo(appropriateName);
    }

    @ParameterizedTest
    @DisplayName("예외 발생 - 잘못된 이름 길이")
    @ValueSource(strings = {"아주 긴 이름입니다", " "})
    void shouldThrowIllegalArgumentExceptionWhenUseLongName(String inputName) {
        // given
        String wrongName = inputName;
        // when TODO: then 분리
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(wrongName, new RandomIntGenerator());
                }).withMessage(WRONG_LENGTH_OF_NAME_ANNOUNCEMENT);
    }
}