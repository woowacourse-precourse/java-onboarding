package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
//        Person user = new Person(username);
//        Map<String, Person> people = new HashMap<>();
//        initializeFriendShip(people, friends);
//        List<String> friendsOfUserFriends = findFriendsOfUserFriends(user, people);
//        Map<String, Person> recommendedPeople = new HashMap<>();

        Map<String, List<String>> friendsInformation = initializeFriendsInformation(friends);
        List<String> friendsOfFriendsOfUser = findFriendsOfFriendsOfUser(user, friendsInformation);
        Map<String, Integer> recommendScore = new HashMap<>();
        calculateRecommendScore(recommendScore, friendsOfFriendsOfUser, CalculusType.friend);
        calculateRecommendScore(recommendScore, visitors, CalculusType.visitor);
        return answer;
    }

    public static void initializeFriendShip(Map<String, Person> people, List<List<String>> friends){
        for(List<String> friendShip : friends) {
            String person1 = friendShip.get(0);
            String person2 = friendShip.get(1);
            if(people.containsKey(person1)){
                people.put(person1, new Person(person1));
            }
            if(people.containsKey(person2)) {
                people.put(person2, new Person(person2));
            }
            people.get(person1).getFriends().add(person2);
            people.get(person2).getFriends().add(person2);
        }
    }

    public static List<String> findFriendsOfUserFriends(Person user, Map<String, Person> people) {
        List<String> friendsOfUserFriends = new ArrayList<>();
        List<String> userFriends = user.getFriends();
        for(String friend : userFriends){
            Person userFriend = people.get(friend);
            for(String friendOfUserFriend : userFriend.getFriends()) {
                if(friendOfUserFriend.equals(user.getName())){
                    continue;
                }
                if(userFriends.contains(friendOfUserFriend)){
                    continue;
                }
                friendsOfUserFriends.add(friendOfUserFriend);
            }
        }
        return friendsOfUserFriends;
    }

    public static Map<String, List<String>> initializeFriendsInformation(List<List<String>> friends) {
        Map<String, List<String>> friendsInformation = new HashMap<>();
        for(List<String> relationship : friends) {
            String person1 = relationship.get(0);
            String person2 = relationship.get(1);
            if(!friendsInformation.containsKey(person1)){
                friendsInformation.put(person1, new ArrayList<>());
            }
            friendsInformation.get(person1).add(person2);
            if(!friendsInformation.containsKey(person2)){
                friendsInformation.put(person2, new ArrayList<>());
            }
            friendsInformation.get(person2).add(person1);
        }
        return friendsInformation;
    }


    public static List<String> findFriendsOfFriendsOfUser(String user, Map<String, List<String>> friendsInformation){
        List<String> friendsOfFriendsOfUser = new ArrayList<>();
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
                friendsOfFriendsOfUser.add(friendOfFriend);
            }
        }
        return friendsOfFriendsOfUser;
    }

    public static boolean checkDirectFriend(String person, List<String> userFriends){
        return userFriends.contains(person);
    }

    public static void calculateRecommendScore(Map<String, Integer> recommendScore,
                                               List<String> recommendFriends, CalculusType calculusType) {
        int value = 0;
        if(calculusType == CalculusType.friend){
            value = 10;
        } else if(calculusType == CalculusType.visitor){
            value = 1;
        }
        for(String person : recommendFriends) {
            if(!recommendScore.containsKey(person)) {
                recommendScore.put(person, 0);
            }
            int score = recommendScore.get(person);
            recommendScore.put(person, score + value);
        }
    }


}

enum CalculusType {
    friend,
    visitor
}

class Person {
    private String name;
    private int recommendScore;
    private List<String> friends;
    public Person(String name) {
        this.name = name;
        this.recommendScore = 0;
        this.friends = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getRecommendScore() {
        return recommendScore;
    }

    public void setRecommendScore(int recommendScore) {
        this.recommendScore = recommendScore;
    }

    public List<String> getFriends() {
        return friends;
    }
}