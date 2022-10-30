package onboarding.problem1.consts;

/**
 * 페이지를 검증하기 위한 기준 값을 상수로 정의한 추상 클래스
 */
public abstract class PageValidateConst {

    /**
     * 페이지의 최소 값
     */
    public static final int MINIMUM_PAGE_VALUE = 3;

    /**
     * 페이지의 최대 값
     */
    public static final int MAXIMUM_PAGE_VALUE = 398;

    /**
     * 두 페이지 사이의 차
     */
    public static final int BETWEEN_LEFT_AND_RIGHT_PAGE_VALUE = 1;

    /**
     * 홀짝을 구하기 위한 나머지 값
     */
    public static final int ADD_ODD_REMAINDER_VALUE = 0;

    /**
     * 홀짝을 구하기 위한 연산 값
     */
    public static final int ADD_ODD_DIVISION_VALUE = 2;
}