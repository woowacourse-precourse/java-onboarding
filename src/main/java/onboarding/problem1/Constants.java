package onboarding.problem1;

public final class Constants {
    public static final int RESULT_POBI_WIN = 1;
    public static final int RESULT_CRONG_WIN = 2;
    public static final int RESULT_TIE = 0;
    public static final int RESULT_EXCEPTION = -1;
    public static final int ADDITION_INITIAL_VALUE = 0;
    public static final int MULTIPLICATION_INITIAL_VALUE = 1;
    public static final String LINE_BREAK = "\n";
    public static final String ERROR_MESSAGE = "[ERROR] %s";
    public static final int PLAYER_LENGTH = 2;
    public static final int LEFT_PAGE_INDEX = 0;
    public static final int RIGHT_PAGE_INDEX = 1;
    public static final int QUOTIENT = 2;
    public static final int LEFT_REMAINDER = 1;
    public static final int RIGHT_REMAINDER = 0;
    public static final int PAGE_GAP = 1;
    public static final String ERROR_PAGE_GAP = "pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.";
    public static final String ERROR_PAGE_ODD_AND_EVEN = "왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이다.";
    public static final String ERROR_LENGTH = "pobi와 crong의 길이는 2이다.";
    public static final String REGEX_NO_SPACE = "";
    public static final int MIN_PAGE_NUMBER = 1;
    public static final int MAX_PAGE_NUMBER = 400;
    public static final String ERROR_PAGE_RANGE = "1부터 시작되는 400 페이지의 책입니다.";

    private Constants() {
    }
}
