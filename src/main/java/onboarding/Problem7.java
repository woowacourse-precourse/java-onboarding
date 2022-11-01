package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Set<String>> friendsMap;
    private static Map<String, Integer> userMap;
    private static Set<String> userFriendSet;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        friendsMap = new HashMap<>();
        userMap = new HashMap<>();
        userFriendSet = new HashSet<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            String left = friend.get(0);
            String right = friend.get(1);

            addFriend(left, right);
            addFriend(right, left);
        }

        userFriendSet = friendsMap.get(user);
        calAcquaintance(user);
        calVisit(user, visitors);

        // 정렬
        List<User> recommendList = new ArrayList<>();

        for (String name : userMap.keySet()) {
            recommendList.add(new User(name, userMap.get(name)));
        }

        Collections.sort(recommendList);
        int index = 0;
        while(index < 5 && index < recommendList.size()) {
            answer.add(recommendList.get(index).name);
            index++;
        }

        return answer;
    }

    private static void addFriend(String A, String B) {
        if (friendsMap.containsKey(A)) {
            friendsMap.get(A).add(B);
            return;
        }

        Set<String> set = new HashSet<>();
        set.add(B);
        friendsMap.put(A, set);
    }

    //  함께 아는 친구 구하기
    static void calAcquaintance(String user) {
        if (userFriendSet == null) {
            return;
        }

        for (String name : friendsMap.keySet()) {
            if (!validCheck(name, user)) {
                continue;
            }

            Set<String> each = friendsMap.get(name);
            each.retainAll(userFriendSet);

            int acquaintances = each.size();
            userMap.put(name, acquaintances * 10);
        }
    }

    private static boolean validCheck(String name, String user) {
        if (userFriendSet != null && userFriendSet.contains(name)) {
            return false;
        }

        if (name.equals(user)) {
            return false;
        }

        return true;
    }

    // 방문 계산
    static void calVisit(String user, List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);

            if (!validCheck(visitor, user)) {
                continue;
            }

            if (!userMap.containsKey(visitor)) {
                userMap.put(visitor, 1);
                continue;
            }

            int score = userMap.get(visitor);
            userMap.put(visitor, score + 1);
        }
    }
}

class User implements Comparable<User> {
    String name;
    int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(User o) {
        if (Integer.compare(o.score, this.score) == 0) {
            return this.name.compareTo(o.name);
        }

        return Integer.compare(o.score, this.score);
    }
}