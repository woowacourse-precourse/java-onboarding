package onboarding;

import java.util.*;

public class Problem7 {
    static List<String> otherFriend = new ArrayList<>();
     static Map<String, Integer> friendMap = new HashMap();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        addFriend(friends);

        for(List<String> friend : friends) {
            findOtherFriends(user, friend);
        }

        check(user, otherFriend, friends);
        visitorCheck(visitors);

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });



        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void addFriend(List<List<String>> friends) {
        for(List<String> friend : friends) {
            friendMap.put(friend.get(0), 0);
            friendMap.put(friend.get(1), 0);
        }
    }

    public static void findOtherFriends(String user, List<String> friend) {
        String f1 = friend.get(0);
        String f2 = friend.get(1);

        if(f1.equals(user)) {
            otherFriend.add(f1);
        }
        if(f2.equals(user)) {
            otherFriend.add(f2);
        }
    }

    public static void check(String user, List<String> otherFriends, List<List<String>> friends) {
        for(List<String> friend : friends) {
            for(String otherFriend : otherFriends) {
                if(friend.get(0).equals(otherFriend) && !friend.get(1).equals(user)) {
                    friendMap.put(friend.get(1), friendMap.get(friend.get(1) + 10));
                }

                if(friend.get(1).equals(otherFriend) && !friend.get(0).equals(user)) {
                    friendMap.put(friend.get(0), friendMap.get(friend.get(0) + 10));
                }
            }
        }
    }

    public static void visitorCheck(List<String> visitors) {
        for(String visitor : visitors) {
            friendMap.put(visitor, friendMap.get(visitor + 1));
        }
    }

}
