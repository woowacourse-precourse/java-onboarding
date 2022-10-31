package onboarding;

import java.util.*;

public class Problem7 {
    static Set<String> friendSet = new HashSet<>();
    static Map<String, Integer> recommendMap = new HashMap<>();

    public static Set<String> userFriends (String user, List<List<String>> friends) { // 유저의 친구 추가 메서드
        Set<String> userFriendSet = new HashSet<>();

        for(List<String> f : friends) {
            String f1 = f.get(0);
            String f2 = f.get(1);

            if(f1.equals(user)) {
                userFriendSet.add(f2);
            }else if(f2.equals(user)) {
                userFriendSet.add(f1);
            }
        }
        return userFriendSet;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        friendSet = userFriends(user, friends);

        for(List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);

            if(f1.equals(user) || f2.equals(user)) { // 친구 목록중 유저가 있으면 건너뜀
                continue;
            }
            if(friendSet.contains(f1) && !friendSet.contains(f2)) { // 친구의 친구에 10점 추가
                recommendMap.put(f2, recommendMap.getOrDefault(f2, 0) + 10);
            }else if(!friendSet.contains(f1) && friendSet.contains(f2)) {
                recommendMap.put(f1, recommendMap.getOrDefault(f1, 0) + 10);
            }
        }

        for(String v : visitors) { // 방문 목록중 유저나 유저의 친구가 아니면 점수 1 증가
            if(!v.equals(user) && !friendSet.contains(v)) {
                recommendMap.put(v, recommendMap.getOrDefault(v, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(recommendMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() { // 내림차순 정렬
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<String,Integer> entry : entries) {
            answer.add(entry.getKey());
        }

        return answer;
    }
}
