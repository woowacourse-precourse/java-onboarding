package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    static final int SCORE_FRIEND = 10;
    static final int SCORE_VISITOR = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 아이디 별로 친구 리스트를 저장할 변수 선언
        Map<String, List<String>> friendMap = new HashMap<String, List<String>>();

        // 기능#1 List<List<String>>의 친구 관계를 토대로 각 아이디별 친구 리스트를 만드는 기능
        for(List<String> relation : friends) {
            String user1 = relation.get(0), user2 = relation.get(1);
            if(!friendMap.containsKey(user1)) {
                friendMap.put(user1, new ArrayList<String>());
            }
            if(!friendMap.containsKey(user2)) {
                friendMap.put(user2, new ArrayList<String>());
            }
            friendMap.get(user1).add(user2);
            friendMap.get(user2).add(user1);
        }

        // 점수 계산 결과가 담길 변수 선언
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();

        // 친구 리스트를 토대로 점수 계산
        for(String id : friendMap.get(user)) {
            addScore(friendMap.get(id), scoreMap,SCORE_FRIEND);
        }

        // 방문자 리스트를 토대로 점수 계산
        addScore(visitors, scoreMap,SCORE_VISITOR);

        // 기능#4 "이미 친구인 아이디는 제외하고" 부분
        if(scoreMap.containsKey(user)) // 예외처리 추가. 본인도 제외한다.
            scoreMap.remove(user);
        for(String id : friendMap.get(user)){
            if(scoreMap.containsKey(id))
                scoreMap.remove(id);
        }

        // 기능 #4 "아이디별 점수를 비교해 친구 추천 대상을 골라내는 기능" 부분
        return scoreMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    // 기능#2 친구의 친구 리스트에 아이디가 있으면 그 아이디에 10점 추가하는 기능
    // 기능#3 사용자 타임 라인 방문 기록 리스트에 아이디가 있으면 그 아이디에 1점 추가하는 기능
    // 기능#2, 기능#3 둘 다 문자열 리스트를 받아 점수를 더하는 것이므로 같은 메소드로 구현
    public static void addScore(List<String> list, Map<String, Integer> scoreMap, int score) {
        for(String id : list) {
            if(!scoreMap.containsKey(id)) {
                scoreMap.put(id, score);
                continue;
            }
            scoreMap.replace(id, scoreMap.get(id) + score);
        }
    }
}
