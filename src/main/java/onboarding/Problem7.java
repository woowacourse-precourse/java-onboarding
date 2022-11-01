package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> usersFriends = getUsersFriends(user, friends);
        HashMap<String, Integer> recommendMap = getFriendssFriends(user, friends, usersFriends);
        List<String> visitorExceptFriend = getVisitorExceptFriend(visitors, usersFriends);
        setVisitorScore(recommendMap, visitorExceptFriend);
        List<Map.Entry<String, Integer>> sortedList = sortByScore(recommendMap);
        List<String> answer = getKeyList(sortedList);
        return answer;
    }

    private static List<String> getKeyList(List<Map.Entry<String, Integer>> sortedList) {
        List<String> answer = new ArrayList<>();

        for (Map.Entry<String, Integer> list : sortedList) {
            answer.add(list.getKey());
        }
        return answer;
    }

    private static List<Map.Entry<String, Integer>> sortByScore(HashMap<String, Integer> recommendMap) {
        List<Map.Entry<String, Integer>> recommandList = new LinkedList<>(recommendMap.entrySet());

        recommandList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return recommandList;
    }

    private static void setVisitorScore(HashMap<String, Integer> recommendMap, List<String> visitorExceptFriend) {
        for (String name : visitorExceptFriend) {
            if (recommendMap.containsKey(name)) {
                recommendMap.put(name, recommendMap.get(name) + 1);
            } else
                recommendMap.put(name, 1);
        }
    }

    private static List<String> getVisitorExceptFriend(List<String> visitors, List<String> usersFriends) {
        List<String> newVisitorsList = new ArrayList<>();

        for (String visitor : visitors) {
            if (!usersFriends.contains(visitor)) {
                newVisitorsList.add(visitor);
            }
        }
        return newVisitorsList;
    }

    private static HashMap<String, Integer> getFriendssFriends(String user, List<List<String>> friends, List<String> usersFriends) {
        HashMap<String, Integer> recommandList = new HashMap<>();

        for (String friendName : usersFriends) {
            for (List<String> friend : friends) {
                if (friend.contains(friendName) && !friend.contains(user)) {
                    if (friend.get(0).equals(friendName)) {
                        setHashMap(recommandList, friend.get(1));
                    } else {
                        setHashMap(recommandList, friend.get(0));
                    }
                }
            }
        }
        return recommandList;
    }

    private static void setHashMap(HashMap<String, Integer> recommandList, String recommandName) {
        if (!recommandList.containsKey(recommandName)) {
            recommandList.put(recommandName, 10);
        } else {
            recommandList.put(recommandName, recommandList.get(recommandName) + 10);
        }
    }

    private static List<String> getUsersFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> name : friends) {
            if (name.get(0).equals(user)) {
                friendList.add(name.get(1));
            }
            if (name.get(1).equals(user)) {
                friendList.add(name.get(0));
            }
        }
        return friendList;
    }
}
