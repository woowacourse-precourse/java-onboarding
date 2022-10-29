package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, Integer> scores = new HashMap<String, Integer>();
        Set<String> FriendWithUser = new HashSet<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                FriendWithUser.add(friend.get(friend.indexOf(user) ^ 1));
            }
        }

        System.out.println(FriendWithUser);

        for (List<String> friend : friends) {
            for (String DirectFriend : FriendWithUser) {
                String acquaintance;
                if (friend.contains(DirectFriend) && (acquaintance = friend.get(friend.indexOf(DirectFriend) ^ 1)) != user && ! FriendWithUser.contains(acquaintance)) {
                    scores.computeIfPresent(acquaintance, (k, v) -> v + 10);
                    scores.computeIfAbsent(acquaintance, v -> 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (!(FriendWithUser.contains(visitor))) {
                scores.computeIfPresent(visitor, (k, v) -> v + 1);
                scores.computeIfAbsent(visitor, v -> 1);
            }
        }

        System.out.println(scores);

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(scores.entrySet());
        Collections.sort(list, new ValueThenKeyComparator<String, Integer>());

        for (Map.Entry<String, Integer> i : list) {
            answer.add(i.getKey());
        }

        return answer.subList(0,5);
   }
    private static class ValueThenKeyComparator<K extends Comparable<? super K>, V extends Comparable<? super V>>
            implements Comparator<Map.Entry<K, V>> {

        public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
            int cmp1 = b.getValue().compareTo(a.getValue());
            if (cmp1 != 0) {
                return cmp1;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        }
    }
}