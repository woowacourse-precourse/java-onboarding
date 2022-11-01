package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Set<String>> friendMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);

            Set<String> f1Friends = friendMap.getOrDefault(f1, new HashSet<>());
            f1Friends.add(f2);
            friendMap.put(f1, f1Friends);

            Set<String> f2Friends = friendMap.getOrDefault(f2, new HashSet<>());
            f2Friends.add(f1);
            friendMap.put(f2, f2Friends);
        }

        Map<String, Integer> scoremap = new HashMap<>();
        Set<String> userFriends = friendMap.get(user);
        for (String s : friendMap.keySet()) {
            if (s.equals(user) || userFriends.contains(s)) {
                continue;
            }
            Set<String> strings = friendMap.get(s);
            for (String string : userFriends) {
                if (strings.contains(string)) {
                    int score = scoremap.getOrDefault(s, 0) + 10;
                    scoremap.put(s, score);
                }
            }
        }

        for (String visitor : visitors) {
            if (friendMap.get(user).contains(visitor)) {
                continue;
            }
            int score = scoremap.getOrDefault(visitor, 0) + 1;

            scoremap.put(visitor, score);
        }

        Map<Integer, List<String>> friendsMap = new TreeMap<>(Comparator.reverseOrder());
        for (String s : scoremap.keySet()) {
            List<String> list = friendsMap.getOrDefault(scoremap.get(s), new ArrayList<>());
            list.add(s);
            friendsMap.put(scoremap.get(s), new ArrayList<>(list));
        }

        List<String> answer = new ArrayList<>();
        for (int i : friendsMap.keySet()) {
            List<String> list = friendsMap.get(i);
            Collections.sort(list);
            answer.addAll(list);
        }
        return answer;
    }

}
