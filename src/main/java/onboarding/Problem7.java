package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, ArrayList<String>> friendList = new HashMap<>();
        Map<String, Integer> users = new HashMap<>();

        convertFriendList(friends, friendList);
        getUserScore(user, visitors, friendList, users);
        choiceRecommendFriend(user, answer, friendList, users);

        return answer;
    }

    private static void convertFriendList(List<List<String>> friends, Map<String, ArrayList<String>> friendList) {
        for (List<String> friend : friends) {
            friendList.put(friend.get(0), new ArrayList<>());
            friendList.put(friend.get(1), new ArrayList<>());
        }
        for (List<String> friend : friends) {
            friendList.get(friend.get(0)).add(friend.get(1));
            friendList.get(friend.get(1)).add(friend.get(0));
        }
    }

    private static void getUserScore(String user, List<String> visitors, Map<String, ArrayList<String>> friendList, Map<String, Integer> users) {
        for (String key : friendList.keySet()) {
            users.put(key, 0);
        }
        for (String s : friendList.get(user)) {
            for (String s1 : friendList.get(s)) {
                if (s1.equals(user)) continue;
                users.put(s1, users.get(s1) + 10);
            }
        }

        for (String visitor : visitors) {
            if (!users.containsKey(visitor)){
                users.put(visitor, 1);
            }else {
                users.put(visitor, users.get(visitor) + 1);
            }
        }
    }


    private static void choiceRecommendFriend(String user, List<String> answer, Map<String, ArrayList<String>> friendList, Map<String, Integer> users) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(users.entrySet());
        entryList.sort(((o1, o2) -> {
            if (Objects.equals(users.get(o2.getKey()), users.get(o1.getKey())))
                return o1.getKey().compareTo(o2.getKey());
            else
                return users.get(o2.getKey()) - users.get(o1.getKey());
        }));

        for (Map.Entry<String, Integer> entry : entryList) {
            if (answer.size() == 5) break;
            if (friendList.get(user).contains(entry.getKey()) || entry.getValue() == 0 || entry.getKey().equals(user)) continue;
            answer.add(entry.getKey());
        }
    }
}
