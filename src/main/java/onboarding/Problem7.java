package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        return answer;
    }

    public static Map<String, ArrayList<String>> overOneBridge(List<List<String>> friends) {

        Map<String, ArrayList<String>> friendOfFriend = new HashMap<>();

        for(List<String> edge : friends) {

            String name = edge.get(0);
            String friendWith = edge.get(1);

            if(!friendOfFriend.containsKey(name)) {

                friendOfFriend.put(name, new ArrayList<>());
                friendOfFriend.get(name).add(friendWith);
            }
            else {

                friendOfFriend.get(name).add(friendWith);
            }
        }

        return friendOfFriend;
    }

    public static Map<String, Integer> recommendFriend(Map<String, ArrayList<String>> friendOfFriend, List<String> visitors, String user) {

        Map<String, Integer> recommendScore = new HashMap<>();

        for(String alreadyFriend : friendOfFriend.keySet()) {

            for(String potentialFriend : friendOfFriend.get(alreadyFriend)) {

                if(potentialFriend.equals(user)) {
                    continue;
                }
                else if(!recommendScore.containsKey(potentialFriend)) {

                    recommendScore.put(potentialFriend, 10);
                }
                else {

                    recommendScore.put(potentialFriend, recommendScore.get(potentialFriend) + 10);
                }
            }
        }

        for(String visitor : visitors) {

            if(friendOfFriend.containsKey(visitor)) {
                continue;
            }
            else if (!recommendScore.containsKey(visitor)) {

                recommendScore.put(visitor, 1);
            }
            else {

                recommendScore.put(visitor, recommendScore.get(visitor) + 1);
            }
        }

        return recommendScore;
    }

    public static Map<String, Integer> sortMap(Map<String, Integer> recommendScore) {

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(recommendScore.entrySet());
        Map<String, Integer> sorted = new LinkedHashMap<>();

        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Map.Entry<String, Integer> entry : entryList) {

            sorted.put(entry.getKey(), entry.getValue());
        }

        return sorted;
    }

}
