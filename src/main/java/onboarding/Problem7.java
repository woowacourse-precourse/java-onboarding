package onboarding;

import java.util.*;
import java.util.stream.Stream;

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
    List<Friend> scores = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // updateFriends : 친구 목록 생성
            // 1. friends를 1중 배열로 Flatten
            // 2. 배열 중복 제거
            // 3. 배열에서 user 제거
            // 4. 1중 배열 friends로 scores 리스트 업데이트
        // scoreCoFriend : friends를 순회하며 userFriend와 함께 아는 친구에 대해 score 10점 추가
        // scoreVisitor : visitors를 순회하며 방문자의 score 1점씩 추가
        // scores를 점수 내림차순, 이름 오름차순으로 정렬
        // 상위 5명 선택
        // score가 0인 사람 제외
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> flatten2DimStringList(List<List<String>> string2DimList) {
        List<String> flattenList = string2DimList.stream().reduce(new ArrayList<>(), (x, y) -> {
            x.addAll(y);
            return x;
        });
        return flattenList;
    }

    static List<String> dropDuplicate(List<String> stringList) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(stringList);
        List<String> listWithoutDuplicates = new ArrayList<>(linkedHashSet);
        return listWithoutDuplicates;
    }
}


