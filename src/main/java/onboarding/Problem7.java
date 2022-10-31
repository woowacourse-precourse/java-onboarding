package onboarding;

import java.util.*;

public class Problem7 {

    // 관계 그래프를 저장할 해시맵
    private static HashMap<String, ArrayList<String>> relation = new HashMap<>();
    // 점수를 저장할 해시맵
    private static HashMap<String, Integer> friendPoint = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 관계 생성
        for (List<String>friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            createRelation(userA, userB);
            createRelation(userB, userA);
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }

    // userA, userB를 담아 관계 HashMap에 저장
    private static void createRelation(String userA, String userB) {
        if (relation.containsKey(userA)){
            relation.get(userA).add(userB);
        }else{
            ArrayList<String> list = new ArrayList<>(Arrays.asList(userB));
            relation.put(userA, list);
        }
    }
}
