package onboarding.problem7;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 사용자의 정보를 정의한 클래스
 */
public class Account {

    /**
     * 사용자 ID
     */
    private final String id;

    /**
     * 사용자의 친구 관계
     */
    private final Set<Account> friendsRelation;

    /**
     * 사용자의 친구 추천 점수
     */
    private int score;

    /**
     * 사용자의 ID, 친구 관계, 친구 추천 점수를 초기화하는 생성자
     *
     * @param id 사용자 ID
     */
    public Account(String id) {
        this.id = id;
        this.friendsRelation = new HashSet<>();
        this.score = 0;
    }

    /**
     * 사용자의 친구를 추가하는 메소드
     *
     * @param friend 사용자의 친구
     */
    public void addFriend(Account friend) {
        friendsRelation.add(friend);
    }

    /**
     * 사용자의 ID가 맞는지 확인하는 메소드
     *
     * @param user 사용자 ID
     * @return 사용자의 ID가 맞는지에 대한 여부
     */
    public boolean isAccountId(String user) {
        return this.id.equals(user);
    }

    /**
     * 사용자의 친구가 맞는지 확인하는 메소드
     *
     * @param friendId 사용자 친구 ID
     * @return 사용자 친구 ID가 맞는지에 대한 여부
     */
    public boolean isFriend(String friendId) {
        return friendsRelation.stream().anyMatch(account -> account.isAccountId(friendId));
    }

    /**
     * 사용자의 친구 추천 점수를 추가하는 메소드
     *
     * @param score 친구 추천 점수
     */
    public void addScore(int score) {
        this.score += score;
    }

    /**
     * 사용자의 친구 추천 점수가 0점보다 높은지 확인하는 메소드
     *
     * @return 사용자의 친구 추천 점수가 0점보다 높은지에 대한 여부
     */
    public boolean scoreOverThanZero() {
        return score > 0;
    }

    /**
     * 사용자의 친구 추천 점수와 다른 사용자의 친구 추천 점수가 동일한지 확인하는 메소드
     *
     * @param otherAccount 사용자의 점수와 비교할 다른 사용자
     * @return 사용자의 친구 추천 점수와 다른 사용자의 친구 추천 점수가 동일한지에 대한 여부
     */
    public boolean isEqualsScore(Account otherAccount) {
        return this.score == otherAccount.getScore();
    }

    /**
     * 사용자의 ID를 반환하는 메소드
     *
     * @return 사용자 ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * 사용자의 친구 추천 점수를 반환하는 메소드
     *
     * @return 사용자 친구 추천 점수
     */
    public int getScore() {
        return this.score;
    }

    /**
     * 사용자의 모든 친구 관계를 Stream 타입으로 반환하는 메소드
     *
     * @return Stream 타입의 사용자의 모든 친구 관계
     */
    public Stream<Account> getFriendRelationStream() {
        return friendsRelation.stream();
    }
}
