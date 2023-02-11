package racingcar;

public class GameTime {

    private static final int MAX_GAME_TIME = 500;
    private static final int RANGE_BOUNDARY = 0;

    private int gameTime;

    public GameTime(String gameTime) {
        int parsedGameTime = validateParsing(gameTime);
        validateMaxGameTime(parsedGameTime);
        validatePositive(parsedGameTime);
        this.gameTime = parsedGameTime;
    }

    private static void validatePositive(int parsedGameTime) {
        if (parsedGameTime <= RANGE_BOUNDARY) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력 가능합니다.");
        }
    }

    private static void validateMaxGameTime(int gameTimeParsed) {
        if (gameTimeParsed >= MAX_GAME_TIME) {
            throw new IllegalArgumentException("[ERROR] 500회 미만으로 입력해주세요.");
        }
    }

    private static int validateParsing(String gameTime) {
        try {
            int gameTimeParsed = Integer.parseInt(gameTime);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(gameTime);
    }

    public boolean isNotZero() {
        return gameTime != 0;
    }

    public void runOnce() {
        gameTime--;
    }
}