package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, Integer> score = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, ArrayList<String>> friendship = checkFriendship(friends);

        findMutualFriend(user, friendship);

        plusVisitPoint(visitors);

        answer = sortScore();

        return answer;
    }

    public static List<String> sortScore() {
        return score.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(s -> s.getKey())
                .collect(Collectors.toList());
    }

    public static Map checkFriendship(List<List<String>> friends) {
        Map<String, ArrayList<String>> friendship = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String A = friends.get(i).get(0);
            String B = friends.get(i).get(1);

            ArrayList<String> temp1 = friendship.getOrDefault(A, new ArrayList<>());
            temp1.add(B);
            friendship.put(A, temp1);

            ArrayList<String> temp2 = friendship.getOrDefault(B, new ArrayList<>());
            temp2.add(A);
            friendship.put(B, temp2);

            validateFreshman(A);
            validateFreshman(B);
        }

        return friendship;
    }

    public static void findMutualFriend(String user, Map<String, ArrayList<String>> friendship) {
        ArrayList<String> userFriends = friendship.get(user);

        for (Map.Entry<String, ArrayList<String>> entry : friendship.entrySet()) {
            String curUser = entry.getKey();
            if (!curUser.equals(user)) {
                int count = 0;
                for (String otherFriend: entry.getValue()) {
                    if(userFriends.stream().anyMatch(s -> s.equals(otherFriend))) {
//                    if (Arrays.asList(userFriends).contains(otherFriend)) { # 왜 이 방법은 안되는 걸까?
                        count += 1;
                    }
                }
                if (count > 0) {
                    plusMutualFriendPoint(curUser, count);
                }
            }
        }
    }

    public static void plusVisitPoint(List<String> visitors) {
        int point = 1;

        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            score.put(name, score.getOrDefault(name, 0) + point);
        }
    }

    public static void plusMutualFriendPoint(String name, int count) {
        int point = 10 * count;
        score.put(name, score.getOrDefault(name, 0) + point);
    }

    public static void validateFreshman(String name) {
        if (!score.containsKey(name)) {
            score.put(name, 0);
        }
    }
}
