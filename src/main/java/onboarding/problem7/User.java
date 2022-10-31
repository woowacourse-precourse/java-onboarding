package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

public class User {
    //이름
    private String name;
    //점수
    private int score = 0;
    //친구 목록
    private List<User> friends = new ArrayList<>();
    //점수 반환
    public int getScore() {
        return score;
    }
    //0점인지
    public boolean isScoreZero() {
        return score == 0;
    }
    //이름 반환
    public String getName() {
        return name;
    }
    //점수 0점으로
    public void resetScore() {
        score = 0;
    }
    //점수 +1
    public void addScore() {
        score++;
    }
    //이름으로 생성자
    public User(String name) {
        this.name = name;
    }
    //친구 추가
    public void addFriend(User user) {
        friends.add(user);
    }
    //겹치는 친구 점수 계산
    public void calculateFriendsScore(User user) {
        score += countContainedFriends(user) * 10;
    }
    //겹치는 친구 세기
    private int countContainedFriends(User src) {
        int count = 0;
        for (var srcFriend : src.friends)
            if (this.friends.contains(srcFriend)) count++;
        return count;
    }
    //친구인지
    public boolean isFriend(User user) {
        return friends.contains(user);
    }
}
