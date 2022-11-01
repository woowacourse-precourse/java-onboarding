package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        final List<String> ERROR = Collections.emptyList();
        if (violateId(user)) return ERROR;
        if (violateFriends(friends)) return ERROR;
        if (violateVisitors(visitors)) return ERROR;

        return recommendList(scores(user, friends, visitors));
    }

    static Map<String, Integer> scores(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = new HashMap<>();
        Map<String, Set<String>> friendMap = setFriendMap(friends);
        Set<String> myFriends = friendMap.getOrDefault(user, new HashSet<>());
        for (String other : friendMap.keySet()) {
            if (other.equals(user)) continue;
            if (myFriends.contains(other)) continue;
            friendMap.get(other).retainAll(myFriends);
            scores.put(other, friendMap.get(other).size() * 10);
        }

        for (String visitor : visitors) {
            if (visitor.equals(user)) continue;
            if (myFriends.contains(visitor)) continue;
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
        return scores;
    }

    // 친구추천점수가 주어졌을 때 가장 높은 점수 5명(0점 아닌 인원이 5명 아래면 전부) 출력
    static List<String> recommendList(Map<String, Integer> scores) {
        List<String> recommendList = scores.keySet()
                .stream()
                .filter(o -> scores.get(o) > 0)
                .sorted((o1, o2) -> {
                    int score1 = scores.get(o1);
                    int score2 = scores.get(o2);
                    if (score1 != score2) {
                        return score2 - score1;
                    }
                    return o1.compareTo(o2);
                })
                .collect(Collectors.toList());
        return recommendList.subList(0, Math.min(recommendList.size(), 5));
    }

    // 주어진 아이디가 잘못되었는지 체크
    static boolean violateId(String id) {
        int length = id.length();
        if (length == 0 || length > 30) return true;
        String regex = "^[a-z]*";
        return !Pattern.matches(regex, id);
    }

    // 주어진 친구관계가 잘못된 입력인지 체크
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

    // 주어진 방문자 리스트가 잘못된 입력인지 체크
    static boolean violateVisitors(List<String> visitors) {
        int size = visitors.size();
        if (size == 0 || size > 10000) return true;
        for (String visitor : visitors) {
            if (violateId(visitor)) return true;
        }
        return false;
    }

    // 친구관계도 : friendMap의 key A에 해당하는 value는 A의 친구들의 집합 
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

    // 친구관계 클래스
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Friend friend = (Friend) o;
            return a.equals(friend.a) && b.equals(friend.b);
        }
    }
}
