package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        Map<String, List<String>> friendsInformation = initializeFriendsInformation(friends);
        List<String> friendsOfUserFriends = findFriendsOfUserFriends(user, friendsInformation);
        Map<String, Integer> recommendedPeople = new HashMap<>();
        calculateRecommendedPeople(recommendedPeople, friendsOfUserFriends, CalculusType.friend);
        visitors = findVisitorsNotUserFriend(visitors, friendsInformation.get(user));
        calculateRecommendedPeople(recommendedPeople, visitors, CalculusType.visitor);
        answer = findTop5RecommendedPeople(recommendedPeople);
        return answer;
    }

    public static Map<String, List<String>> initializeFriendsInformation(List<List<String>> friends) {
        Map<String, List<String>> friendsInformation = new HashMap<>();
        for(List<String> relationship : friends) {
            String person1 = relationship.get(0);
            String person2 = relationship.get(1);
            if(!friendsInformation.containsKey(person1)){
                friendsInformation.put(person1, new ArrayList<>());
            }
            if(!friendsInformation.containsKey(person2)){
                friendsInformation.put(person2, new ArrayList<>());
            }
            friendsInformation.get(person1).add(person2);
            friendsInformation.get(person2).add(person1);
        }
        return friendsInformation;
    }


    public static List<String> findFriendsOfUserFriends(String user, Map<String, List<String>> friendsInformation){
        List<String> friendsOfUserFriends = new ArrayList<>();
        List<String> userFriends = friendsInformation.get(user);
        if(userFriends == null){
            return new ArrayList<>();
        }
        for(String friend : userFriends) {
            if(!friendsInformation.containsKey(friend)) {
                continue;
            }
            for(String friendOfFriend : friendsInformation.get(friend)) {
                if(friendOfFriend.equals(user)){
                    continue;
                }
                if(checkDirectFriend(friendOfFriend, userFriends)){
                    continue;
                }
                friendsOfUserFriends.add(friendOfFriend);
            }
        }
        return friendsOfUserFriends;
    }

    public static boolean checkDirectFriend(String person, List<String> userFriends){
        return userFriends.contains(person);
    }

    public static void calculateRecommendedPeople(Map<String, Integer> recommendedPeople,
                                               List<String> recommendFriends, CalculusType calculusType) {
        int value = 0;
        if(calculusType == CalculusType.friend){
            value = 10;
        } else if(calculusType == CalculusType.visitor){
            value = 1;
        }
        for(String person : recommendFriends) {
            if(!recommendedPeople.containsKey(person)) {
                recommendedPeople.put(person, 0);
            }
            int score = recommendedPeople.get(person);
            recommendedPeople.put(person, score + value);
        }
    }

    public static List<String> findVisitorsNotUserFriend(List<String> visitors, List<String> userFriend) {
        List<String> visitorsNotUserFriend = new ArrayList<>();
        for(String visitor : visitors) {
            if(!userFriend.contains(visitor)) {
                visitorsNotUserFriend.add(visitor);
            }
        }
        return visitorsNotUserFriend;
    }

    public static List<String> findTop5RecommendedPeople(Map<String, Integer> recommendedPeople) {
        List<String> people = new ArrayList<>(recommendedPeople.keySet());
        List<String> top5 = new ArrayList<>();
        people.sort((o1, o2) -> {
            if (recommendedPeople.get(o1) == recommendedPeople.get(o2)) {
                return o1.compareTo(o2);
            }
            return recommendedPeople.get(o2).compareTo(recommendedPeople.get(o1));
        });
        for(int i = 0; i < 5 && i < people.size(); ++i){
            top5.add(people.get(i));
        }
        return top5;
    }
}

enum CalculusType {
    friend,
    visitor
}