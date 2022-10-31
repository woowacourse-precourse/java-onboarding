package onboarding.problem2.consts;

/**
 * 암호문의 중복된 문자를 확인할 때의 문자 위치를 상수로 정의한 추상 클래스
 */
public abstract class CryptogramIndexConst {

    /**
     * 암호문의 모든 문자를 반복하기 위한 시작 인덱스
     */
    public static final int CHARACTER_START_INDEX = 1;

    /**
     * 암호문이 중복되었는지 확인하기 위해 이전 인덱스를 구하기 위한 값
     */
    public static final int CHARACTER_BEFORE_INDEX = 1;
}