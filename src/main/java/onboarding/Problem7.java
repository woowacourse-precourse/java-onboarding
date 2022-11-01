package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List<String>> friendList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getRecommendFriendList(user, friends, visitors);
        return answer;
    }

    public static List<String> getRecommendFriendList(String user,
                                                      List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> score = new HashMap<>();
        List<String> resList = new ArrayList<>();

        initFriendList(friends);

        // 사용자의 친구들 목록
        for (String userFriend : friendList.get(user)) {
            List<String> userFriendFriend = friendList.get(userFriend);
            for (int i = 0; i < userFriendFriend.size(); i++) {
                if (isFriend(user, userFriendFriend.get(i))) {
                    score.put(userFriendFriend.get(i), 0);
                    continue;
                }

                if (!userFriendFriend.get(i).equals(user)) {
                    score.put(userFriendFriend.get(i), !score.containsKey(userFriendFriend.get(i))
                            ? 10 : score.get(userFriendFriend.get(i)) + 10);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            //  사용자의 친구 중에서 방문자가 있을 경우 스킵
            if (friendList.get(user).contains(visitors.get(i))) {
                continue;
            }

            score.put(visitors.get(i), !score.containsKey(visitors.get(i))
                    ? 1 : score.get(visitors.get(i)) + 1);
        }

//        return sortResult(score);

        return new ArrayList<>(score.keySet());
    }

    public static void initFriendList(List<List<String>> friends) {
        Set<String> userSet = new HashSet<>();
        List<String> userList;
        List<List<String>> userFriendList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            userSet.addAll(friends.get(i));
        }

        userList = new ArrayList<>(userSet);

        for (int i = 0; i < userList.size(); i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).contains(userList.get(i))) {
                    set.addAll(friends.get(j));
                }
            }
            set.remove(userList.get(i));
            userFriendList.add(new ArrayList<>(set));
        }

        for (int i = 0; i < userList.size(); i++) {
            friendList.put(userList.get(i), userFriendList.get(i));
        }
    }

//    public static int visitScore(String user, List<String> visitors) {
//
//    }
//
//    public static int knownFriendScore(String user, List<List<String>> friends) {
//
//    }

    public static boolean isFriend(String user, String target) {
        if (friendList.get(user).contains(target)) {
            return true;
        }

        return false;
    }

    public static List<String> sortResult(Map<String, Integer> score) {
        List<String> res = new ArrayList<>(score.keySet());

//        res.sort();

        return null;
    }
}
