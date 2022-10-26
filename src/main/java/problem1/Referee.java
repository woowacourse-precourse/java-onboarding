package problem1;

import java.util.List;

public class Referee {

    public static final int CONTINOUS_CRITERION = 1;
    public static final int START_PAGE_NUMBER_LEFT = 1;
    public static final int START_PAGE_NUMBER_RIGHT = 2;
    public static final int END_PAGE_NUMBER_LEFT = 399;
    public static final int END_PAGE_NUMBER_RIGHT = 400;
    public static final String INPUT_EXCEPTION_MESSAGE = "올바르지 않은 입력 값 입니다.";

    private final Player pobi;
    private final Player crong;

    public Referee(List<Integer> pobi, List<Integer> crong) {
        validate(pobi, crong);

        this.pobi = new Player(pobi);
        this.crong = new Player(crong);
    }

    private void validate(List<Integer> pobi, List<Integer> crong) {
        validate(pobi);
        validate(crong);
    }

    private void validate(List<Integer> player) {
        int leftPageNumber = player.get(Player.LEFT_PAGE_INDEX);
        int rightPageNumber = player.get(Player.RIGHT_PAGE_INDEX);

        if (!isRightPage(leftPageNumber, rightPageNumber)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
        if (!isContinuousPage(leftPageNumber, rightPageNumber)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
        if (isStartPage(leftPageNumber, rightPageNumber)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
        if (isEndPage(leftPageNumber, rightPageNumber)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private boolean isEndPage(int leftPageNumber, int rightPageNumber) {
        return leftPageNumber == END_PAGE_NUMBER_LEFT
                && rightPageNumber == END_PAGE_NUMBER_RIGHT;
    }

    private boolean isStartPage(int leftPageNumber, int rightPageNumber) {
        return leftPageNumber == START_PAGE_NUMBER_LEFT
                && rightPageNumber == START_PAGE_NUMBER_RIGHT;
    }

    private boolean isContinuousPage(int leftPageNumber, int rightPageNumber) {
        return rightPageNumber - leftPageNumber == CONTINOUS_CRITERION;
    }

    private boolean isRightPage(int left, int right) {
        return left % 2 != 0 && right % 2 == 0;
    }

    public GameResultStatus playGame() {
        int pobiScore = pobi.calculateTotalScore();
        int crongScore = crong.calculateTotalScore();

        return playGame(pobiScore, crongScore);
    }

    private GameResultStatus playGame(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return GameResultStatus.POBI_WIN;
        }
        if (crongScore > pobiScore) {
            return GameResultStatus.CRONG_WIN;
        }
        return GameResultStatus.DRAW;
    }
}
