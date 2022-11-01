package onboarding;

import java.util.*;

public class Problem7 {

    // 친구 관계를 저장한다.
    // A와 B가 아는 사이고, B와 C가 아는 사이라면 {A, (B)}, {B, (A,C)}, {C, (B)}
    private static Map<String, Set<String>> friendsList = new HashMap<>();

    // 사용자들의 점수를 저장할 Map
    private static Map<String, Integer> scores = new HashMap<>();

    // personA와 personB를 각자의 friendsList에 추가한다.
    private static void relateFriend(String personA, String personB){
        // a->b의 관계를 만든다.
        // Set이 없었다면, 새롭게 만든다.
        friendsList.computeIfAbsent(personA, s -> new HashSet<>());
        friendsList.get(personA).add(personB);

        // b->a도 동일하게 수행한다.
        friendsList.computeIfAbsent(personB, s -> new HashSet<>());
        friendsList.get(personB).add(personA);
    }

    // otherUser에게 점수를 score만큼 더한다.
    private static void addScore(String otherUser, String user, int score){
        if (friendsList.get(user).contains(otherUser) || otherUser.equals(user)) return;

        scores.put(otherUser, scores.getOrDefault(otherUser, 0) + score);
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

        // (user의 친구)의 친구인 nearFriend를 돈다.
        for (String userFriend : friendsList.get(user)) {
            for (String nearFriend : friendsList.get(userFriend)) {
                // 10점을 더한다.
                addScore(nearFriend, user, 10);
            }
        }

        // visitors를 처리한다.
        for (String visitor : visitors) {
            // 1점을 더한다.
            addScore(visitor, user, 1);
        }

        // 내림차순으로 정렬한다.
        List<String> keySetList = new ArrayList<>(scores.keySet());
        Collections.sort(keySetList, (o1, o2) -> {
            int cmpVal = scores.get(o2).compareTo(scores.get(o1));
            // 점수가 같다면, 이름 순으로 정렬.
            if (cmpVal == 0)
                return o1.compareTo(o2);
            return cmpVal;
        });

        // 최대 5개까지 빼서 반환한다.
        int len = Math.min(keySetList.size(), 5);
        for (int i = 0; i < len; i++){
            answer.add(keySetList.get(i));
        }

        return answer;
    }
}
