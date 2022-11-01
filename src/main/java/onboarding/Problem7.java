package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> friendsMap = new HashMap<>();

        for(List<String> friend : friends) {
            friendsMap.putIfAbsent(friend.get(0), new ArrayList<>());
            friendsMap.putIfAbsent(friend.get(1), new ArrayList<>());
            friendsMap.get(friend.get(0)).add(friend.get(1));
            friendsMap.get(friend.get(1)).add(friend.get(0));
        }

        Set<String> userFriends = new HashSet<>(); // 이미 친구등록 + 본인
        userFriends.add(user); // 본인도 제외
        if(friendsMap.containsKey(user)) {
            for(String friend : friendsMap.get(user)) {
                userFriends.add(friend);
            }
        }

        Map<String, Integer> recommends = new HashMap<>(); // 추천할 친구 : 점수
        for(String userFriend : userFriends) {
            for(String newFriend : friendsMap.get(userFriend)) {
                if(!userFriends.contains(newFriend)) {
                    recommends.put(newFriend, recommends.getOrDefault(newFriend, 0) + 10);
                }
            }
        }

        for(String visitor : visitors) {
            if(!userFriends.contains(visitor)) {
                recommends.put(visitor, recommends.getOrDefault(visitor, 0) + 1);
            }
        }

        Queue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if(recommends.get(o1) == recommends.get(o2)) {
                return o1.compareTo(o2);
            }
            return recommends.get(o2) - recommends.get(o1);
        });

        for(String key : recommends.keySet()) {
            pq.add(key);
        }

        while(!pq.isEmpty() && answer.size() < 5) {
            answer.add(pq.poll());
        }
        return answer;
    }
}
