package onboarding;

import java.util.*;

class Friend {
    private String name;
    private int score;

    // Getter
    public String getName() {
        return this.name;
    }
    public Integer getScore() {
        return this.score;
    }

    // Setter
    public void setName(String name){
        this.name = name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void updateScore(int addScore) {
        this.score += addScore;
    }
}

public class Problem7 {
    // List<Friend<name, score>> friendsScores 생성
    List<Friend> list = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // updateFriends : 친구 목록 생성
        // scoreCoFriend : friends를 순회하며 userFriend와 함께 아는 친구에 대해 score 10점 추가
        // scoreVisitor : visitors를 순회하며 방문자의 score 1점씩 추가
        // scores를 점수 내림차순, 이름 오름차순으로 정렬
        // 상위 5명 선택
        // score가 0인 사람 제외
        List<String> answer = Collections.emptyList();
        return answer;
    }
}


