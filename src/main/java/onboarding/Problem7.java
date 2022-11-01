package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriends = getUserFriends(user, friends);
        Map<String, Integer> map = getCloseFriends(user, friends, userFriends);

        return answer;
    }
    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        Set<String> userFriendSet = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {

            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);

            if (name1.equals(user)) {
                userFriendSet.add(name2);
            } else if (name2.equals(user)) {
                userFriendSet.add(name1);
            }


        }

        List<String> userFriends = new ArrayList<>(userFriendSet);
        return userFriends;
    }

    private static Map<String, Integer> getCloseFriends(String user, List<List<String>> friends, List<String> userFriends) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < userFriends.size(); i++) {

            String userFriend = userFriends.get(i);

            for (int j = 0; j < friends.size(); j++) {

                String name1 = friends.get(j).get(0);
                String name2 = friends.get(j).get(1);


                if (name1.equals(userFriend) && !name2.equals(user)) {
                    //mrko 의 친구의 친구 이면서 이름이 mrko 가 아니면?
                    if (map.containsKey(name2)) {
                        map.put(name2, map.get(name2) + 10);
                    } else {
                        map.put(name2, 10);
                    }

                } else if (name2.equals(userFriend) && !name1.equals(user)) {
                    if (map.containsKey(name1)) {
                        map.put(name1, map.get(name1) + 10);
                    } else {
                        map.put(name1, 10);
                    }
                }

            }


        }
        return map;
    }


}
