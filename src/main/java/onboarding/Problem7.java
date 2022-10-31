package onboarding;

import java.util.*;

public class Problem7 {
    private static final int MUTUAL_SCORE = 10;
    private static final int VISIT_SCORE = 1;

    private static final int MAX_RESULT = 5;

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

        for (String visitor : visitorsNotfriend) { // 친구가 아닌 방문자에게 1점 추가
            if (!recommendations.containsKey(visitor)) { // 처음 인식된 이름이면 등록 + 1점 추가
                recommendations.put(visitor, VISIT_SCORE);
            } else {                                     // 이미 있는 이름일 시, 기존 점수에 1점 추가
                recommendations.put(visitor, recommendations.get(visitor) + VISIT_SCORE);
            }
        }

        List<Map.Entry<String, Integer>> recommendedFriends = new LinkedList<>(recommendations.entrySet());
        Collections.sort(recommendedFriends, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() == o1.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        List<String> result = new ArrayList<>();

        int iteration = 0;
        if (recommendedFriends.size() > MAX_RESULT) {
            iteration = MAX_RESULT;
        } else {
            iteration = recommendedFriends.size();
        }

        for (int i=0; i<iteration; i++) {
            result.add(recommendedFriends.get(i).getKey());
        }

        return result;
    }
}
