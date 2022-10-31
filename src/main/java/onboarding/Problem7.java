package onboarding;

import java.util.*;

public class Problem7 {
    public static class Info {
        public int point;
        public String name;

        public Info(int x, String name) {
            point = x;
            this.name = name;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Set<String>> links = new HashMap<>();

        for (List<String> friend: friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            if (!links.containsKey(userA)) {
                links.put(userA, new HashSet<>());
            }
            links.get(userA).add(userB);
            if (!links.containsKey(userB)) {
                links.put(userB, new HashSet<>());
            }
            links.get(userB).add(userA);
        }

        HashMap<String, Integer> visitCount = new HashMap<>();
        for (String visitor : visitors) {
            if (!visitCount.containsKey(visitor)) {
                visitCount.put(visitor, 1);
            } else {
                Integer count = visitCount.get(visitor);
                visitCount.put(visitor, count + 1);
            }
        }

        Set<String> users = new HashSet<>();
        for (List<String> friend : friends) {
            users.add(friend.get(0));
            users.add(friend.get(1));
        }
        users.addAll(visitors);
        users.remove(user);
        users.removeIf(anotherUser -> links.get(user).contains(anotherUser));

        List<Info> result = new ArrayList<>();
        for (String anotherUser : users) {
            int point = 0;
            for (String userFriend : links.get(user)) {
                if (links.containsKey(anotherUser) && links.get(anotherUser).contains(userFriend)) {
                    point += 10;
                }
            }
            if (visitCount.containsKey(anotherUser)) {
                point += visitCount.get(anotherUser);
            }
            if (point > 0) {
                result.add(new Info(point, anotherUser));
            }
        }

        return null;
    }
}
