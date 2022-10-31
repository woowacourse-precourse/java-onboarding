package onboarding.problem7.consts;

/**
 * 친구와 관련된 값을 상수로 정의한 추상 클래스
 */
public abstract class FriendConst {

    /**
     * 친구 A 인덱스(0)
     */
    public static final int FRIEND_A_INDEX = 0;

    /**
     * 친구 B 인덱스(1)
     */
    public static final int FRIEND_B_INDEX = 1;

    /**
     * 최대 친구 추천 수
     */
    public static final int RECOMMEND_FRIEND_LIST_LIMIT = 5;

    /**
     * 사용자와 함께 아는 친구의 수의 점수
     */
    public static final int FRIEND_RELATION_SCORE = 10;

    /**
     * 사용자의 타임 라인에 방문한 횟수의 점수
     */
    public static final int VISITOR_SCORE = 1;
}
