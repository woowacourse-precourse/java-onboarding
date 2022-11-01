package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendArr = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                String str = friend.get(0);
                if (!str.equals(user)) {
                    friendArr.add(str);
                } else {
                    friendArr.add(friend.get(1));
                }
            }
        }

        for (List<String> friend : friends) {
            for (String userFriend : friendArr) {
                if (!friend.contains(userFriend) || friend.contains(user)) continue;
                String name = Objects.equals(friend.get(0), userFriend) ? friend.get(1) : friend.get(0);
                map.put(name, map.containsKey(name) ? map.get(name) + 10 : 10);
            }
        }

        for (String visitor : visitors) {
            if (!friendArr.contains(visitor))
                map.put(visitor, map.getOrDefault(visitor, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entList = new LinkedList<>(map.entrySet());
        entList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String,Integer> entry : entList){
            answer.add(entry.getKey());
        }
        return answer;
    }
}
