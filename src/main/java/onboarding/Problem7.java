package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();



        return answer;
    }


    // sns관계설정
    public static Map<String, List<String>> snsRelation (List<List<String>> friends) {

        Map<String, List<String>> relation = new HashMap<>(); // K : 사람 V : K와의 관계에 있는 사람들

        for (List<String> friend : friends) {
            userFriends(relation, friend.get(0), friend.get(1)); //
            userFriends(relation, friend.get(1), friend.get(0));
        }

        return relation;
    }


    // user의 친구관계 설정
    public static void userFriends(Map<String, List<String>> relation, String person, String personFriends) {
        if (relation.containsKey(person)) {
            relation.get(person).add(personFriends);
        } else {
            List<String> friends = new ArrayList<>();
            friends.add(personFriends);
            relation.put(person, friends);
        }
    }
}
