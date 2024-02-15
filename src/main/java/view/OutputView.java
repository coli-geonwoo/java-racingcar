package view;

import domain.Car;
import java.util.List;

public class OutputView {

    // TODO: Constant 관리하는 클래스 만들어서 메시지 + 상수 한번에 관리하기
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNING_MESSAGE = "가 최종 우승했습니다.";

    public static void printCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public static void printRound() {
        System.out.println(INPUT_ROUND);
    }

    public static void printRoundResult() {
        System.out.println(GAME_RESULT);
    }

    public static void printScore(List<Car> carList) {
        // TODO: toString override vs getter 사용  고민해보기
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + new String("-").repeat(car.getScore()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + WINNING_MESSAGE);
    }
}