// 7번 문제

package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    private static final int ANSWER_LENGTH = 5;

    private static void getMyFriendsList(HashMap<String, List<String>> friendsList, List<String> userFriends, String user) {
        userFriends.add(user);
        for (int i = 0; i < friendsList.get(user).size(); i++) {
            userFriends.add(friendsList.get(user).get(i));
        }
    }

    private static void getFriendsList(HashMap<String, List<String>> friendsList, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            String member1 = friends.get(i).get(0);
            String member2 = friends.get(i).get(1);

            connectFrined(friendsList, member1, member2);
            connectFrined(friendsList, member2, member1);
        }
    }

    private static void connectFrined(HashMap<String, List<String>> friendsList, String member, String friend) {
        if (!friendsList.containsKey(member)) {
            List<String> memberFriendsList = new ArrayList<>();
            friendsList.put(member, memberFriendsList);
        }
        friendsList.get(member).add(friend);
    }

    private static void shareFriends(HashMap<String, List<String>> friendsList, HashMap<String, Integer> recommendScore, String user) {
        for (int i = 0; i < friendsList.get(user).size(); i++) {
            String frinedName = friendsList.get(user).get(i);
            addFriendScore(friendsList, recommendScore, frinedName, user);
        }
    }

    private static void addFriendScore(HashMap<String, List<String>> friendsList, HashMap<String, Integer> recommendScore, String member, String user) {
        for (int i = 0; i < friendsList.get(member).size(); i++) {
            String friendName = friendsList.get(member).get(i);
            if (friendName.equals(user)) {
                continue;
            }
            if (!recommendScore.containsKey(friendName)) {
                recommendScore.put(friendName, 0);
            }
            recommendScore.put(friendName, recommendScore.get(friendName) + 10);
        }
    }

    private static void getVisitFriendScore(List<String> visitors, HashMap<String, Integer> recommendScore) {
        for (int i = 0; i < visitors.size(); i++) {
            String visitorName = visitors.get(i);
            if (!recommendScore.containsKey(visitorName)) {
                recommendScore.put(visitorName, 0);
            }
            recommendScore.put(visitorName, recommendScore.get(visitorName) + 1);
        }
    }

    private static List<String> sortByScoreAndName(HashMap<String, Integer> recommendScore, List<String> userFriends) {
        List<String> recommendFriendsList = new ArrayList<>();
        List<Entry<String, Integer>> sortRecommendList = new ArrayList<Entry<String, Integer>>(recommendScore.entrySet());
        Collections.sort(sortRecommendList, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        for (int i = 0; i < recommendScore.size(); i++) {
            if (recommendFriendsList.size() == ANSWER_LENGTH) {
                break;
            }
            if (!isNotRecommend(userFriends, sortRecommendList.get(i).getKey())) {
                recommendFriendsList.add(sortRecommendList.get(i).getKey());
            }
        }
        return recommendFriendsList;
    }

    private static boolean isNotRecommend(List<String> userFriends, String name) {
        return userFriends.contains(name);
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, List<String>> friendsList = new HashMap<>();
        HashMap<String, Integer> recommendScore = new HashMap<>();

        getFriendsList(friendsList, friends);

        shareFriends(friendsList, recommendScore, user);

        getVisitFriendScore(visitors, recommendScore);

        getMyFriendsList(friendsList, userFriends, user);

        answer = sortByScoreAndName(recommendScore, userFriends);

        return answer;
    }
}