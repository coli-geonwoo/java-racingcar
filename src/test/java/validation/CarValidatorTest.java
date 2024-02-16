package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static constant.Numbers.MAX_CAR_LENGTH;
import static constant.Numbers.MIN_CAR_LENGTH;
import static org.junit.jupiter.api.Assertions.*;

class CarValidatorTest {
    @Test
    @DisplayName("차 이름 테스트: 정상 입력")
    void validateCarNames_validInputs() {
        // given
        List<String> names = new ArrayList<>(List.of("A", "bb", "cCc", "DdddD"));

        // when - then
        assertDoesNotThrow(() -> CarValidator.validateCarNames(names));
    }

    @Test
    @DisplayName("차 이름 테스트: 예외 입력(1) - 명명 규칙 위반")
    void validateCarNames_invalidInputs() {
        // given
        List<String> nameTooLong = new ArrayList<>(List.of("abcdef"));
        List<String> nameBlank = new ArrayList<>(List.of(""));
        List<String> nameWithIllegalLetter = new ArrayList<>(List.of("ab!"));
        List<String> nameWithDuplication = new ArrayList<>(List.of("aa,bb,bb,cc"));

        // when - then
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(nameTooLong));
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(nameBlank));
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(nameWithIllegalLetter));
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(nameWithDuplication));
    }

    @Test
    @DisplayName("차 대수 테스트 : 정상 범위의 차량 대수가 입력")
    void validateCarNums_validInputs() {
        // given
        List<String> validCarNums = new ArrayList<>();

        // 정상범위(1-100)안의 차량 대수생성
        for (int i = MIN_CAR_LENGTH; i <= MAX_CAR_LENGTH; i++) {
            validCarNums.add(String.valueOf(i));
            assertThrows(IllegalArgumentException.class,
                    () -> CarValidator.validateCarNames(validCarNums));
            }
        }


    @Test
    @DisplayName("차 대수 : 예외 입력 - 예외 범위의 차량 대수가 입력")
    void validateCarNums_invalidInputs() {

        // given
        List<String> exceedCarNums = new ArrayList<>();


        // 예외범위의 차량 대수생성
        List<String> zeroCar = new ArrayList<>();
        for (int i = MIN_CAR_LENGTH; i <= MAX_CAR_LENGTH+2; i++) {
            exceedCarNums.add(String.valueOf(i));
        }

        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(zeroCar));
        assertThrows(IllegalArgumentException.class,
                () -> CarValidator.validateCarNames(exceedCarNums));
    }
}
