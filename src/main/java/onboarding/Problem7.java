package onboarding;

import java.util.*;

public class Problem7 {

    // 친구 관계를 저장한다.
    // A와 B가 아는 사이고, B와 C가 아는 사이라면 {A, (B)}, {B, (A,C)}, {C, (B)}
    static Map<String, Set<String>> friendsList = new HashMap<>();

    // personA와 personB를 각자의 friendsList에 추가한다.
    static void relateFriend(String personA, String personB){
        // a->b의 관계를 만든다.
        // Set이 없었다면, 새롭게 만든다.
        friendsList.computeIfAbsent(personA, s -> new HashSet<>());
        friendsList.get(personA).add(personB);

        // b->a도 동일하게 수행한다.
        friendsList.computeIfAbsent(personB, s -> new HashSet<>());
        friendsList.get(personB).add(personA);
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 친구 관계를 저장한다.
        for (List<String> friend : friends) {
            String personA = friend.get(0);
            String personB = friend.get(1);

            // 서로의 friendList에 추가
            relateFriend(personA, personB);
        }

        return answer;
    }
}
