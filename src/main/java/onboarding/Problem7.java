package onboarding;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(List.of("donut", "andole"), List.of("donut", "jun"), List.of("donut", "mrko"),
                List.of("shakevan", "andole"), List.of("shakevan", "jun"), List.of("shakevan", "mrko"));
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        System.out.println(solution(user, friends, visitors));
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<String>> relations = new HashMap<>();
        Set<String> myFriends = new HashSet<>();
        myFriends.add(user);

        for (String visitor : visitors) {
            if (!map.containsKey(visitor)) {
                map.put(visitor, 0);
            }
            map.put(visitor, map.get(visitor) + 1);
        }

        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            if (name1.equals(user)) {
                myFriends.add(name2);
            }
            if (name2.equals(user)) {
                myFriends.add(name1);
            }

            if (!relations.containsKey(name1)) {
                relations.put(name1, new ArrayList<>());
            }
            List<String> friendList1 = relations.get(name1);
            friendList1.add(name2);
            relations.put(name1, friendList1);

            if (!relations.containsKey(name2)) {
                relations.put(name2, new ArrayList<>());
            }
            List<String> friendList2 = relations.get(name2);
            friendList2.add(name1);
            relations.put(name2, friendList2);
        }

        for (String myFriend : myFriends) {
            List<String> subFriends = relations.get(myFriend);

            for (String subFriend : subFriends) {
                if (!map.containsKey(subFriend)) {
                    map.put(subFriend, 0);
                }
                map.put(subFriend, map.get(subFriend) + 10);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : entryList) {
            if (!myFriends.contains(entry.getKey())) {
                result.add(entry.getKey());

                if (result.size() >= 5) {
                    break;
                }
            }
        }

        return result;
    }
}
