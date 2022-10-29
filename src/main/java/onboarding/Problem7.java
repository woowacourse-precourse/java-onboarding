package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 1. 친구 목록을 돌면서 친구 관계 그래프 딕셔너리 만들기 (양방향 그래프)
        Map<String, List<String>> friendMap = new HashMap<>();
        for (List<String> friend : friends){
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            if (friendMap.containsKey(friend1))
                friendMap.get(friend1).add(friend2);
            else
                friendMap.put(friend1, new ArrayList<>(List.of(friend2)));
            if (friendMap.containsKey(friend2))
                friendMap.get(friend2).add(friend1);
            else
                friendMap.put(friend2, new ArrayList<>(List.of(friend1)));
        }
        //System.out.println(friendMap);

        // 2. 친구 관계 그래프 돌면서 친구 포함 관계에 따라 점수 계산하기
        List<String> usersFriendList = friendMap.getOrDefault(user, Collections.emptyList());
        Map<String, Integer> friendScore = new HashMap<>();
        if (!usersFriendList.isEmpty()){
            for(String keyUser : friendMap.keySet()){
                if (keyUser.equals(user))
                    continue;
                if (usersFriendList.contains(keyUser))
                    continue;
                for (String valFriend : friendMap.get(keyUser)){
                    if (usersFriendList.contains(valFriend))
                        friendScore.put(keyUser, friendScore.containsKey(keyUser) ? friendScore.get(keyUser) + 1 : 1);
                }
            }
        }
        friendScore.replaceAll((u, v) -> friendScore.get(u) * 10);
        //System.out.println(friendScore);

        // 3. 방문자 목록 돌면서 방문 횟수에 따라 점수 계산하기
        Map<String, Integer> visitorScore = new HashMap<>();
        for (String visitor : visitors){
            if (usersFriendList.contains(visitor))
                continue;
            visitorScore.put(visitor, visitorScore.containsKey(visitor) ? visitorScore.get(visitor) + 1 : 1);
        }
        //System.out.println(visitorScore);

        // 4. 합산 후 정렬하고 return
        friendScore.forEach((k, v) -> visitorScore.merge(k, v, Integer::sum));
        Map<String, Integer> sortedMap = visitorScore.entrySet()
                .stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        //System.out.println(sortedMap);

        return new ArrayList<>(sortedMap.keySet());
    }
}
