package onboarding;


import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendList = new ArrayList<>();
        HashMap<String, Integer> result = new HashMap<>();

        friendList = getFriendList(friends, user);

        for (int i = 0; i < friends.size(); i += 1) {
            checkFriendOfFriend(friendList, friends, result, i);
        }

        for (int i = 0; i < visitors.size(); i += 1) {
            updatePointByVisitor(result, visitors, i);
        }

        if (result.containsKey(user)) {
            result.remove(user);
        }

        for (int i = 0; i < friendList.size(); i += 1) {
            if (result.containsKey(friendList.get(i))) {
                result.remove(friendList.get(i));
            }
        }

        return formatTheAnswer(result);
    }

    public static List<String> getFriendList(List<List<String>> friends, String user) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < friends.size(); i += 1) {
            getFriendName(list, friends, user, i);
        }
        return list;
    }

    public static void getFriendName(List<String> list, List<List<String>> friends, String user, int index) {
        if (friends.get(index).get(1) == user) {
            list.add(friends.get(index).get(0));
        }
        if (friends.get(index).get(0) == user) {
            list.add(friends.get(index).get(1));
        }
    }

    public static List<String> formatTheAnswer(HashMap<String, Integer> result) {

        Map<String, Integer> sortedMap = new TreeMap<>(result);
        List<String> keySet = new ArrayList<>(sortedMap.keySet());
        keySet.sort((o1, o2) -> sortedMap.get(o2).compareTo(sortedMap.get(o1)));

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < keySet.size(); i += 1) {
            answer.add(keySet.get(i));
        }

        if (answer.size() > 5) {
            removeExtraUser(answer, keySet);
        }

        return answer;
    }

    private static void removeExtraUser(List<String> answer, List<String> keySet) {
        for (int i = 5; i < keySet.size(); i += 1) {
            answer.remove(i);
        }
    }

    public static Integer updatePointByIndex0Friend(HashMap<String, Integer> result, List<List<String>> friends, int index) {
        if (result.containsKey(friends.get(index).get(0))) {
            return result.put(friends.get(index).get(0), result.get(friends.get(index).get(0)) + 10);
        }
        return result.put(friends.get(index).get(0), 10);
    }

    public static Integer updatePointByIndex1Friend(HashMap<String, Integer> result, List<List<String>> friends, int index) {
        if (result.containsKey(friends.get(index).get(1))) {
            return result.put(friends.get(index).get(1), result.get(friends.get(index).get(1)) + 10);
        }
        return result.put(friends.get(index).get(1), 10);
    }

    public static Integer updatePointByVisitor(HashMap<String, Integer> result, List<String> visitors, int index) {
        if (result.containsKey(visitors.get(index))) {
            return result.put(visitors.get(index), result.get(visitors.get(index)) + 1);
        }
        return result.put(visitors.get(index), 1);
    }

    public static void checkFriendOfFriend(List<String> friendList, List<List<String>> friends, HashMap<String, Integer> result, int index) {
        for (int j = 0; j < friendList.size(); j += 1) {
            checkFriendByIndex(friendList, friends, result, index, j);
        }
    }

    public static void checkFriendByIndex(List<String> friendList, List<List<String>> friends, HashMap<String, Integer> result, int friendsIndex, int index) {
        if (friends.get(friendsIndex).get(1) == friendList.get(index)) {
            updatePointByIndex0Friend(result, friends, friendsIndex);
        }
        if (friends.get(friendsIndex).get(0) == friendList.get(index)) {
            updatePointByIndex1Friend(result, friends, friendsIndex);
        }
    }
}