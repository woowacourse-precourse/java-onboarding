package onboarding;

import java.util.*;

public class Problem7 {
    private static Set<String> friendList = new HashSet<>();
    private static HashMap<String, Integer> acquaintance = new HashMap<>();

    public static Boolean checkFriend(String name) {
        if (friendList.contains(name)) {
            return true;
        }
        return false;
    }
    public static Boolean checkAcquaintance(String name) {
        if (acquaintance.containsKey(name)) {
            return true;
        }
        return false;
    }
    public static Boolean deleteAcquaintance(String name) {
        if (checkFriend(name)) {
            acquaintance.remove(name);
            return true;
        }
        return false;
    }
    public static Boolean addFriend(String user, String firstName, String secondName) {
        if (user.equals(firstName)) {
            friendList.add(secondName);
            if (checkAcquaintance(secondName)) deleteAcquaintance(secondName);
            return true;
        }
        if (user.equals(secondName)) {
            friendList.add(firstName);
            if (checkAcquaintance(firstName)) deleteAcquaintance(firstName);
            return true;
        }
        return false;
    }
    public static Boolean addAcquaintance(String name) {
        acquaintance.put(name, 0);
        return true;
    }

    public static Boolean makeFriendAndAcquaintance(String user, List<List<String>> friends) {
        for (List<String> lists: friends) {
            String firstName = lists.get(0);
            String secondName = lists.get(1);

            if (addFriend(user, firstName, secondName)) continue;
            addAcquaintance(firstName);
            addAcquaintance(secondName);
        }
        return true;
    }
    public static Boolean friendPoint(String name) {
        acquaintance.put(name, acquaintance.get(name) + 10);
        return true;
    }
    public static Boolean acquaintancePoint(String name) {
        acquaintance.put(name, 1);
        return true;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();
        makeFriendAndAcquaintance(user, friends);

        // 친구의 친구
        for (int i = 0; i < friends.size(); i++) {
            String firstName = friends.get(i).get(0);
            String secondName = friends.get(i).get(1);

            if (firstName.equals(user) || secondName.equals(user)) continue;
            if (checkFriend(firstName)) friendPoint(secondName);
            if (checkFriend(secondName)) friendPoint(firstName);
        }

        // visitor
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);

            if (!checkAcquaintance(visitors.get(i))) {
                if(checkFriend(visitor)) continue;
                addAcquaintance(visitor);
            }
            acquaintancePoint(visitor);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(acquaintance.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < entryList.size() && i < 5; i++) {
            answer.add(entryList.get(i).getKey());
        }
        return answer;
    }
}
