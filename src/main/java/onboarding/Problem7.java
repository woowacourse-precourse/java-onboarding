package onboarding;

import java.util.*;

public class Problem7 {
    static final int LIMIT_RESULT_NUM = 5;
    static Map<String, Set<String>> relations = new HashMap<>();
    static Set<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 한 사람의 친구 관계 형성
        buildRelations(friends);

        // relations에서 user, user와 이미 친구인 인원들 제거
        userFriends = relations.remove(user);
        if (userFriends == null) {
            userFriends = new HashSet<>();
        }
        for (String userFriend: userFriends) {
            relations.remove(userFriend);
        }

        return new ArrayList<>();
    }

    private static void buildRelations(List<List<String>> friends) {
        String human1, human2;
        Set<String> human1Relation, human2Relation;

        for (List<String> friend: friends) {
            human1 = friend.get(0);
            human2 = friend.get(1);

            if (!relations.containsKey(human1)) {
                human1Relation = new HashSet<>();
                relations.put(human1, human1Relation);
            } else {
                human1Relation = relations.get(human1);
            }
            human1Relation.add(human2);

            if (!relations.containsKey(human2)) {
                human2Relation = new HashSet<>();
                relations.put(human2, human2Relation);
            } else {
                human2Relation = relations.get(human2);
            }
            human2Relation.add(human1);
        }
    }

}
