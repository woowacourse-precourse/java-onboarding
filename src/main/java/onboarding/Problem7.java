package onboarding;

import java.util.*;

/*
    기능 명세
    1. getFriendMap(List<List<String>> friends) : 친구 관계를 나타내는 map을 반환하는 함수
    2. getScore(Map<String, Set<String>> friendMap, String user, List<String> visitors) : 친구의 친구들과 방문자들 사이의 점수를 계산하는 함수
    3. getResult(Map<String, Integer> score) : 결과를 반환하는 함수
 */
public class Problem7 {

    public static Map<String, Set<String>> getFriendMap(List<List<String>> friends) {
        Map<String, Set<String>> friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);
            Set<String> p1Friends = friendMap.getOrDefault(f1, new HashSet<>());
            p1Friends.add(f2);
            friendMap.put(f1, p1Friends);
            Set<String> p2Friends = friendMap.getOrDefault(f2, new HashSet<>());
            p2Friends.add(f1);
            friendMap.put(f2, p2Friends);
        }
        return friendMap;
    }

    public static Map<String, Integer> getScore(Map<String, Set<String>> friendMap, String user, List<String> visitors) {
        Map<String, Integer> score = new HashMap<>();
        Set<String> friendsOfUser = friendMap.get(user); //유저의 친구들
        for (String s1 : friendMap.keySet()) { // 친구의 친구들 점수 계산 (10점)
            if (s1.equals(user) || friendsOfUser.contains(s1)) continue;// 유저 본인이거나 유저의 친구면 continue

            for (String s2 : friendsOfUser) {
                if (friendMap.get(s1).contains(s2)) score.put(s1, score.getOrDefault(s1, 0) + 10);
            }
        }

        for (String visitor : visitors) { // 방문자들 점수 계산 (1점)
            if (friendMap.get(user).contains(visitor)) continue;
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }
        return score;
    }

    public static List<String> getResult(Map<String, Integer> score) {
        Map<Integer, List<String>> result = new TreeMap<>(Comparator.reverseOrder());
        for (String s : score.keySet()) {
            List<String> list = result.getOrDefault(score.get(s), new ArrayList<>());
            list.add(s);
            result.put(score.get(s), new ArrayList<>(list));
        }

        List<String> answer = new ArrayList<>();
        for (int i : result.keySet()) {
            List<String> list = result.get(i);
            Collections.sort(list);
            answer.addAll(list);
        }
        return answer;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendMap = getFriendMap(friends);
        Map<String, Integer> score = getScore(friendMap, user, visitors);
        return getResult(score);
    }
}
