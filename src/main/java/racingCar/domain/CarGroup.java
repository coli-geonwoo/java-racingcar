package racingCar.domain;

import racingCar.dto.CarDto;
import racingCar.util.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class CarGroup {

    private static final int MIN_CAR_SIZE = 2;
    private final List<Car> carGroup;

    public CarGroup(List<String> carNames) {
        validateDuplicate(carNames);
        validateSize(carNames);

        this.carGroup = carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public void moveCars(NumberGenerator numberGenerator) {
        for (Car car : carGroup) {
            int pickedNumber = numberGenerator.generateNumber();
            car.move(pickedNumber);
        }
    }

    public int getHighestPosition() {
        return carGroup.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차가 존재하지 않습니다."))
                .getPosition();
    }

    public List<CarDto> findWinners() {
        int highestPosition = this.getHighestPosition();
        return carGroup.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .map(Car::toCarDto)
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<String> carNames) {
        Set<String> distinctNames = new HashSet<>(carNames);
        if (carNames.size() != distinctNames.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 있을 수 없습니다.");
        }
    }

    private void validateSize(List<String> carNames) {
        if (carNames.size() < MIN_CAR_SIZE) {
            throw new IllegalArgumentException("자동차의 개수는 2개 이상으로 입력해주세요.");
        }
    }

    public List<CarDto> toCarDtos() {
        return carGroup.stream()
                .map(car -> car.toCarDto())
                .collect(Collectors.toList());
    }
}