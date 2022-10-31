package onboarding.problem6.consts;

/**
 * 닉네임과 관련된 값를 상수로 정의한 추상 클래스
 */
public abstract class NicknameConst {

    /**
     * 중복된 닉네임을 검증하기 위한 시작 인덱스
     */
    public static final int NICKNAME_DUPLICATE_START_INDEX = 1;

    /**
     * 닉네임의 일부를 구하기 위한 범위
     */
    public static final int PART_OF_NICKNAME_RANGE = 1;

    /**
     * 중복된 닉네임을 검증할 수 있는 닉네임 최소 길이
     */
    public static final int NICKNAME_MINIMUM_LENGTH = 2;
}
