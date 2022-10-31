package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 1. 크루의 이름, 친구 이름 List, List<Suggestion> 을 필드로 가지는 Crew class 생성
*   1-1. Crew(String name): 파라미터로 이름을 받는 생성자
*   1-2. getSuggestions(): suggestion List 를 반환하는 메소드
*   1-3. getKnowEachOtherFriends(Crew crew): Crew 를 파라미터로 받아 현재 크루와 서로 아는 친구의 List 를 반환
* 2. 크루 이름과 추천 점수를 필드로 가지는 Suggestion class 생성
*   2-1. Suggestion(String name): Crew 를 파라미터로 받는 생성자
*   2-2. calculateScore(Map<>, List<>): 친구 map 과 방문기록 list 를 파라미터로 받아 추천 Crew 의 점수를 계산하는 메소드
*   2-3. getScore(): 해당 추천인에 대한 점수를 가져오는 메소드
* 3. 친구 관계 정보를 바탕으로 crew 의 이름을 key, Crew class 를 value 로 가지는 Map 생성
*   3-1. 친구인 크루의 이름을 Crew class 의 List<String> 필드에 저장
* 4. map 의 keySet 중에서 user 와 친구가 아닌 크루들을 List<Suggestion> 필드에 추가하며 점수를 계산
* 5. List<Suggestion> 에서 점수가 0 보다 크고, 이름순으로 정렬을 하여 최대 5명의 crew 의 이름을 반환
*/

class Suggestion {
    private int score;
    private String name;

    public Suggestion(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }
}

class Crew {
    private String name;
    private List<String> friends;
    private List<Suggestion> suggestions;

    public Crew(String name) {
        this.name = name;
        friends = new ArrayList<>();
        suggestions = new ArrayList<>();
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
