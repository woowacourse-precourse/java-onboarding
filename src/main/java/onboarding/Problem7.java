package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (violateId(user)) return Collections.emptyList();
        if (violateFriends(friends)) return Collections.emptyList();
        if (violateVisitors(visitors)) return Collections.emptyList();

        Map<String, Integer> score = new HashMap<>();
        Map<String, Set<String>> friendMap = setFriendMap(friends);
        Set<String> myFriends = friendMap.getOrDefault(user, new HashSet<>());
        for (String other : friendMap.keySet()) {
            if (other.equals(user)) continue;
            if (myFriends.contains(other)) continue;
            friendMap.get(other).retainAll(myFriends);
            score.put(other, friendMap.get(other).size() * 10);
        }

        for (String visitor : visitors) {
            if (visitor.equals(user)) continue;
            if (myFriends.contains(visitor)) continue;
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }

        return score.keySet()
                .stream()
                .sorted((o1, o2) -> {
                    int score1 = score.getOrDefault(o1, 0);
                    int score2 = score.getOrDefault(o2, 0);
                    if (score1 != score2) {
                        return score2 - score1;
                    }
                    return o1.compareTo(o2);
                })
                .collect(Collectors.toList())
                .subList(0, Math.min(score.size(), 5));
    }

    static boolean violateId(String id) {
        int length = id.length();
        if (length == 0 || length > 30) return true;
        String regex = "^[a-z]*";
        return !Pattern.matches(regex, id);
    }

    static boolean violateFriends(List<List<String>> friends) {
        int size = friends.size();
        if (size == 0 || size > 10000) return true;
        Set<Friend> friendSet = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.size() != 2) return true;
            String a = friend.get(0);
            String b = friend.get(1);
            if (violateId(a)) return true;
            if (violateId(b)) return true;
            if (a.equals(b)) return true;
            if (!friendSet.add(new Friend(a, b))) return true;
        }
        return false;
    }

    static boolean violateVisitors(List<String> visitors) {
        int size = visitors.size();
        if (size == 0 || size > 10000) return true;
        for (String visitor : visitors) {
            if (violateId(visitor)) return true;
        }
        return false;
    }

    static Map<String, Set<String>> setFriendMap(List<List<String>> friends) {
        Map<String, Set<String>> friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            String a = friend.get(0);
            String b = friend.get(1);
            if (!friendMap.containsKey(a)) {
                friendMap.put(a, new HashSet<>());
            }
            if (!friendMap.containsKey(b)) {
                friendMap.put(b, new HashSet<>());
            }
            friendMap.get(a).add(b);
            friendMap.get(b).add(a);
        }
        return friendMap;
    }

    static class Friend {
        String a;
        String b;

        Friend(String a, String b) {
            if (a.compareTo(b) >= 0) {
                this.a = a;
                this.b = b;
            } else {
                this.b = a;
                this.a = b;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
