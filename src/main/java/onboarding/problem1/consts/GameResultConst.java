package onboarding.problem1.consts;

/**
 * 페이지 게임의 결과를 상수로 정의한 추상 클래스
 */
public abstract class GameResultConst {

    /**
     * 예외 상황이 발생했을 때의 값
     */
    public static final int EXCEPTION_RESULT_VALUE = -1;

    /**
     * 무승부일 때의 값
     */
    public static final int TIE_RESULT_VALUE = 0;

    /**
     * 플레이어 A(포비)가 이겼을 때의 값
     */
    public static final int PLAYER_A_WIN_RESULT_VALUE = 1;

    /**
     * 플레이어 B(크롱)가 이겼을 때의 값
     */
    public static final int PLAYER_B_WIN_RESULT_VALUE = 2;
}
