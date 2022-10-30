package onboarding.problem1.consts;

/**
 * 올바른 페이지가 아닌 경우 발생하는 IllegalArgumentException의 메세지를 상수로 정의한 추상 클래스
 */
public abstract class ExceptionErrorMessageConst {

    /**
     * 페이지의 값이 null인 경우의 예외 메세지
     */
    public static final String INVALID_PAGE_VALUE_MESSAGE = "올바른 페이지 값이 아닙니다.";

    /**
     * 페이지의 값이 3 ~ 398 사이가 아닌 경우의 예외 메세지
     */
    public static final String INVALID_PAGE_RANGE_MESSAGE = "올바른 범위를 가진 페이지가 아닙니다.";

    /**
     * 연속된 페이지가 아닌 경우의 예외 메세지
     */
    public static final String INVALID_PAGE_RELATION_MESSAGE = "연속된 페이지가 아닙니다.";

    /**
     * 오른쪽 페이지가 짝수가 아닌 경우의 예외 메세지
     */
    public static final String RIGHT_PAGE_NOT_EVEN_MESSAGE = "오른쪽 페이지가 짝수가 아닙니다.";

    /**
     * 왼쪽 페이지가 홀수가 아닌 경우의 예외 메세지
     */
    public static final String LEFT_PAGE_NOT_ODD_MESSAGE = "왼쪽 페이지가 홀수가 아닙니다.";
}
