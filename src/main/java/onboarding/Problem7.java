package onboarding;

import java.util.*;

public class Problem7 {
    private static final int MUTUAL_SCORE = 10;
    private static final int VISIT_SCORE = 1;



    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> friendRelations = new ArrayList<>();
        HashSet<String> userFriends = new HashSet<>();
        HashMap<String, Integer> recommendations = new HashMap<>();
        List<String> visitorsNotfriend = new ArrayList<>();

        for (List<String> friendRelation : friends) { // friends 중에 user와 친구인 항목 제외
            if (friendRelation.contains(user)) {
                userFriends.add(friendRelation.get(0));
            } else {
                friendRelations.add(friendRelation);
            }
        }

        for (List<String> friendRelation : friendRelations) { // 함께 아는 사람에게 10점 추가
            String mutual = friendRelation.get(1);

            if (!recommendations.containsKey(mutual)) { // 처음 인식된 이름이면 등록 + 10점 추가
                recommendations.put(mutual, MUTUAL_SCORE);
            } else {                                    // 이미 있는 이름일 시, 기존 점수에 10점 추가
                recommendations.put(mutual, recommendations.get(mutual) + MUTUAL_SCORE);
            }
        }

        for (String visitor : visitors) { // visitors 중에 user와 친구인 항목 제외
            if (!userFriends.contains(visitor)) {
                visitorsNotfriend.add(visitor);
            }
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
