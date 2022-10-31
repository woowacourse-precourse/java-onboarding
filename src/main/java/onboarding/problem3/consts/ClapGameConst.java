package onboarding.problem3.consts;

/**
 * 3, 6, 9 게임에서 사용할 설정 값을 상수로 정의한 추상 클래스
 */
public abstract class ClapGameConst {

    /**
     * 3, 6, 9 게임이 시작 숫자 값
     */
    public static final int CLAP_GAME_START_VALUE = 3;

    /**
     * 박수를 처야 할 숫자(3)
     */
    public static final int CLAP_THREE_VALUE = 3;

    /**
     * 박수를 쳐야 할 숫자(6)
     */
    public static final int CLAP_SIX_VALUE = 6;

    /**
     * 박수를 쳐야 할 숫자(9)
     */
    public static final int CLAP_NINE_VALUE = 9;

    /**
     * 박수를 치지 않았을 때 증가시킬 박수 횟수
     */
    public static final int NOT_CLAPPED_VALUE = 0;

    /**
     * 박수를 쳤을 때 증가시킬 박수 횟수
     */
    public static final int CLAPPED_VALUE = 1;
}
