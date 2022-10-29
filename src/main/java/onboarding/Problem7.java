package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Set<String>> friendMap;
    private static Map<String, Integer> scores;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        friendMap = new HashMap<>();
        scores = new HashMap<>();

        makeFriendMap(friends);
        calcSameFriendScore(user);
        calcVisitScore(user, visitors);

        answer = new ArrayList<>(scores.keySet());

        Collections.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(scores.get(o1) < scores.get(o2))
                    return 1;
                else if(scores.get(o1) > scores.get(o2))
                    return -1;
                return 0;
            }
        });

        return answer;
    }

    private static void makeFriendMap(List<List<String>> friends) {
        for(List<String> relation : friends) {
            String n1 = relation.get(0);
            String n2 = relation.get(1);

            friendMap.putIfAbsent(n1, new HashSet<>());
            friendMap.get(n1).add(n2);

            friendMap.putIfAbsent(n2, new HashSet<>());
            friendMap.get(n2).add(n1);
        }
    }

    private static void calcSameFriendScore(String user) {
        for(String name : friendMap.keySet()) {
            // skip if me or already friend
            if(name.equals(user) || friendMap.get(user).contains(name))
                continue;

            scores.put(name, countSameFriends(user, name) * 10);
        }
    }

    private static int countSameFriends(String user, String friend) {
        int friendNum = 0;

        for(String name : friendMap.get(friend))
            if(friendMap.get(user).contains(name))
                friendNum++;

        return friendNum;
    }

    private static void calcVisitScore(String user, List<String> visitors) {
        for(String name : visitors) {
            // skip if me or already friend
            if(name.equals(user) || friendMap.get(user).contains(name))
                continue;

            scores.put(name, scores.getOrDefault(name, 0) + 1);
        }
    }
}
