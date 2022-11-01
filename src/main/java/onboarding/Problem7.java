package onboarding;

import java.util.*;


public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriendList = getFriendList(user, friends);

        List<String> coFriends = new ArrayList<>();


        for (String userFriend : userFriendList) {

            List<String> friendList = getFriendList(userFriend, friends);// user 친구 한명의 친구들 찾기

            coFriends.addAll(friendList);
            coFriends.remove(user);
        } // 친구의 친구들.


        Map<String, Integer> recommendMap = getRecommendMap(coFriends);

        List<String> visitorList = new ArrayList<>(visitors);

        visitorList.removeAll(userFriendList);


        for (String visitor : visitorList) {

            if (recommendMap.containsKey(visitor)) {
                recommendMap.replace(visitor, recommendMap.get(visitor) + 1);
            } else recommendMap.put(visitor, 1);
        } //


        List<String> answerList = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(recommendMap.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<String, Integer> entry : entryList) {
            answerList.add(entry.getKey());
        }

        List<String> list;
        if (answerList.size() > 5) {
            list = answerList.subList(0, 4);
        } else list = answerList;

        return list;
    }



    public static List<String> getFriendList(String user, List<List<String>> friends) {
        List<List<String>> friendList = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                friendList.add(friend);
            }
        }

        for (List<String> pureFriend : friendList) {
            for (String s : pureFriend) {
                userFriends.add(s);
                userFriends.remove(user);
            }
        } // getFriendList

        return userFriends;
    }

    public static Map<String, Integer> getRecommendMap(List<String> coFriends) {

        Map<String, Integer> friendMap = new HashMap<>();

        //친구의 친구에게 점수 10점 부여
        for (String coFriend : coFriends) {
            if (friendMap.containsKey(coFriend)) {
                friendMap.replace(coFriend, friendMap.get(coFriend) + 10);
            } else friendMap.put(coFriend, 10);
        }
        return friendMap;
    }

}
