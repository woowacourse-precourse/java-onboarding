package onboarding;


import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendList = new ArrayList<>();
        HashMap<String, Integer> result = new HashMap<>();

        friendList = getUserFriends(friends, user);

        for (int i = 0; i < friends.size(); i += 1) {
            for (int j = 0; j < friendList.size(); j += 1) {
                if (friends.get(i).get(1) == friendList.get(j)) {
                    if (result.containsKey(friends.get(i).get(0))) {
                        result.put(friends.get(i).get(0), result.get(friends.get(i).get(0)) + 10);
                    } else {
                        result.put(friends.get(i).get(0), 10);
                    }
                } else if (friends.get(i).get(0) == friendList.get(j)) {
                    if (result.containsKey(friends.get(i).get(1))) {
                        result.put(friends.get(i).get(1), result.get(friends.get(i).get(1)) + 10);
                    } else {
                        result.put(friends.get(i).get(1), 10);
                    }
                }
            }
        }

        for (int i = 0; i < visitors.size(); i += 1) {
            if (result.containsKey(visitors.get(i))) {
                result.put(visitors.get(i), result.get(visitors.get(i)) + 1);
            } else {
                result.put(visitors.get(i), 1);
            }
        }

        if (result.containsKey(user)) {
            result.remove(user);
        }

        for (int i = 0; i < friendList.size(); i += 1) {
            if (result.containsKey(friendList.get(i))) {
                result.remove(friendList.get(i));
            }
        }

        Map<String, Integer> sortedMap = new TreeMap<>(result);
        List<String> keySet = new ArrayList<>(sortedMap.keySet());
        keySet.sort((o1, o2) -> sortedMap.get(o2).compareTo(sortedMap.get(o1)));

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < keySet.size(); i += 1) {
            answer.add(keySet.get(i));
        }

        if (answer.size() > 5) {
            for (int i = 5; i < keySet.size(); i += 1) {
                answer.remove(i);
            }
        }

        return answer;
    }

    public static List<String> getUserFriends(List<List<String>> friends, String user){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < friends.size(); i += 1) {
            if (friends.get(i).get(1) == user) {
                list.add(friends.get(i).get(0));
            } else if (friends.get(i).get(0) == user) {
                list.add(friends.get(i).get(1));
            }
        }
        return list;
    }
}
