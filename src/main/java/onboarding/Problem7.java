package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> memberFriendList = getMembersFriendList(friends);
        Map<String, Integer> recommendScore = getRecommendScore(user, visitors, memberFriendList);

        List<String> answer = new ArrayList<>(recommendScore.keySet());
        answer.sort(((o1, o2) -> {
            if(recommendScore.get(o1).equals(recommendScore.get(o2))) return o1.compareTo(o2);
            return recommendScore.get(o2) - recommendScore.get(o1);
        }));

        if(answer.size() > 5) {
            answer = answer.subList(0, 5);
        }
        return answer;
    }
    private static Map<String, List<String>> getMembersFriendList(List<List<String>> friends) {
        Map<String, List<String>> memberFriendList = new HashMap<>();

        for(int i = 0; i < friends.size(); i++) {
            String member = friends.get(i).get(0);
            String member2 = friends.get(i).get(1);

            List<String> friendsList = new ArrayList<>();
            List<String> friendsList2 = new ArrayList<>();

            if (memberFriendList.get(member) != null) {
                friendsList = memberFriendList.get(member);
            }
            friendsList.add(member2);
            memberFriendList.put(member, friendsList);


            if (memberFriendList.get(member2) != null) {
                friendsList2 = memberFriendList.get(member2);
            }
            friendsList2.add(member);
            memberFriendList.put(member2, friendsList2);
        }
        return memberFriendList;
    }
    private static void userFriendRecommend(String user, List<String> visitors, Map<String, List<String>> memberFriendList, Map<String, Integer> recommendScore, int i) {
        for (int j = 0; j < memberFriendList.get(user).size(); j++) {
            if (Objects.equals(visitors.get(i), memberFriendList.get(user).get(j))) {
                for (int k = 0; k < memberFriendList.get(visitors.get(i)).size(); k++) {
                    String recommendFriends = memberFriendList.get(visitors.get(i)).get(k);
                    if (!Objects.equals(recommendFriends, user)) {
                        int score = 0;
                        if (recommendScore.get(recommendFriends) != null) {
                            score = recommendScore.get(recommendFriends);
                        }
                        recommendScore.put(recommendFriends, score + 10);
                    }
                }
            }
        }
    }
    private static void notUserFriendRecommend(List<String> visitors, Map<String, Integer> recommendScore, int i) {
        String recommendFriends = visitors.get(i);
        int score = 0;
        if (recommendScore.get(recommendFriends) != null) {
            score = recommendScore.get(recommendFriends);
        }
        recommendScore.put(recommendFriends, score + 1);
    }
    private static Map<String, Integer> getRecommendScore(String user, List<String> visitors, Map<String, List<String>> memberFriendList) {
        Map<String, Integer> recommendScore = new HashMap<>();
        for(int i = 0; i < visitors.size(); i++) {
            boolean checkUserFriend = memberFriendList.get(user).contains(visitors.get(i));
            if(checkUserFriend) {
                userFriendRecommend(user, visitors, memberFriendList, recommendScore, i);
            }
            else {
                notUserFriendRecommend(visitors, recommendScore, i);
            }
        }
        return recommendScore;
    }
}
