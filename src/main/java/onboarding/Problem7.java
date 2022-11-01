package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    private static Map<String, Integer> countMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriendList = userFriends(user, friends);
        List<String> friendAndFriends = friendAndFriends(userFriendList, friends, user);
        score(userFriendList, friendAndFriends, visitors);

        answer.addAll(countMap.keySet());
        return answer;
    }

    private static void score(List<String> userFriendList, List<String> friendAndFriends, List<String> visitors) {
        Set<String> set = new HashSet<>(friendAndFriends);
        for (String str : set) {
            countMap.put(str, Collections.frequency(friendAndFriends, str) * 10);
        }


        for (String str : visitors) {
            if (userFriendList.contains(str)) {
                continue;
            }
            Integer count = countMap.get(str);
            if (count == null) {
                countMap.put(str, 1);
            } else {
                countMap.put(str, count + 1);
            }
        }
    }


    private static List<String> friendAndFriends(List<String> userFriendList, List<List<String>> friends, String user) {
        List<String> friendsAndFriends = new ArrayList<>();
        for (int i = 0; i < userFriendList.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).contains(userFriendList.get(i))) {
                    if (friends.get(j).get(1).equals(user)) {
                        continue;
                    }
                    friendsAndFriends.add(friends.get(j).get(1));
                }
            }
        }

        return friendsAndFriends;
    }

    private static List<String> userFriends(String user, List<List<String>> friends) {
        List<String> userFriendList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                userFriendList.add(friends.get(i).get(0));
            }
        }


        return userFriendList;
    }


}
