package onboarding.problem7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class User implements Comparable<User> {
    private final Integer KNOWS_FRIEND_COUNT = 10; // 아는 친구 점수
    private final Integer VISITOR_COUNT      = 1; // 방문자 점수

    private final String            name;
    private final Map<String, User> friends = new LinkedHashMap<>();

    private RecommendationScore recommendationScore;

    public User(String name) {
        this.name                = name;
        this.recommendationScore = RecommendationScore.generateZeroScore();
    }

    public String name() {
        return name;
    }

    /**
     * 친구 등록
     *
     * @param user
     */
    public void addFriend(User user) {
        this.friends.put(user.name, user);
        user.friends.put(name, this);
    }

    /**
     * 방문한 조건으로 점수가 추가됩니다.
     */
    public void plusScoreCaseVisitors() {
        recommendationScore = recommendationScore.plusScore(VISITOR_COUNT);
    }

    /**
     * 친구의 친구는 10점을 더합니다.
     */
    public void plusScoreCaseFriendsAFriend() {
        friends.values()
               .forEach(this::plusScoreCaseFriendsAFriends);
    }

    private void plusScoreCaseFriend() {
        this.recommendationScore = this.recommendationScore.plusScore(KNOWS_FRIEND_COUNT);
    }

    private void plusScoreCaseFriendsAFriends(User user) {
        user.friends.values()
                    .forEach(User::plusScoreCaseFriend);
    }

    /**
     * 현재 점수가 0점입니까?
     *
     * @return
     */
    public boolean isZeroScore() {
        return this.recommendationScore.score() == 0;
    }

    public boolean isFriend(User user) {
        return friends.containsKey(user.name);
    }

    public Integer score() {
        return recommendationScore.score();
    }

    public Map<String, User> friends() {
        return friends;
    }

    /**
     * 나 그리고 현재 내 친구가 아닙니까?
     *
     * @param user
     * @return
     */
    public boolean isNotMeAndFriend(User user) {
        if (this == user) {
            return false;
        }
        return !this.isFriend(user);
    }

    @Override
    public String toString() {
        return "username : " + name + " , score : " + score();
    }

    /**
     * 점수는 내림차순이며 이름이 같은 경우에는 오름차순으로 정렬합니다.
     *
     * @param that
     * @return
     */
    @Override
    public int compareTo(User that) {
        if (Objects.equals(this.recommendationScore, that.recommendationScore)) {
            return that.name.compareTo(name);
        }
        // 내림차순
        return recommendationScore.compareTo(that.recommendationScore);
    }


}
