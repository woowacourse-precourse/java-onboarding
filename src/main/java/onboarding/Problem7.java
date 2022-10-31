package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Integer> map = new HashMap<>();
        List<String> alreadyFriend = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                alreadyFriend.add(friends.get(i).get(1));
            }
            if (friends.get(i).get(1).equals(user)) {
                alreadyFriend.add(friends.get(i).get(0));
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);

            for (String value : alreadyFriend) {
                if (friend1.equals(value)) {
                    if (map.containsKey(friend2)) {
                        map.put(friend2, map.get(friend2) + 10);
                    } else {
                        map.put(friend2, 10);
                    }
                }
                if (friend2.equals(value)) {
                    if (map.containsKey(friend1)) {
                        map.put(friend1, map.get(friend1) + 10);
                    } else {
                        map.put(friend1, 10);
                    }
                }
            }
        }
        map.remove(user);

        for (String value : visitors) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        map.keySet().removeAll(alreadyFriend);

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            answer.add(entry.getKey());
        }

        List<String> result = new ArrayList<>();
        if (answer.size() >= 5) {
            result = answer.subList(0, 5);
        } else {
            result = answer;
        }
        return result;
    }
}