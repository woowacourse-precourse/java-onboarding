package onboarding;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class User {
    private String name;
    private Set<String> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getFriends() {
        return friends;
    }

    public void setFriends(Set<String> friends) {
        this.friends = friends;
    }

    public void addFriend(String friend){
        this.getFriends().add(friend);
    }

    public User(String name) {
        this.name = name;
        this.friends = new HashSet<>();
    }
}

public class Problem7 {

    private static Map<String, Integer> recommendedFriend = new HashMap<>();
    private static User member;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        member = new User(user);
        List<List<String>> userFriends = friends.stream()
                .filter( s -> s.contains(user))
                .collect(Collectors.toList());
        setFriends(userFriends);

        List<List<String>> notUserFriends = friends.stream()
                .filter( s -> !s.contains(user))
                .collect(Collectors.toList());
        scoredFriendOfFriends(notUserFriends);
        scoredVisitors(visitors);

        List<String> answer = recommendedFriend.entrySet().stream()
                .sorted(Comparator.comparing(Entry::getValue , Comparator.reverseOrder()))
                .map(s -> s.getKey())
                .collect(Collectors.toList());

        return answer;
    }

    private static void setFriends(List<List<String>> userFriends){
        for(List<String> friends : userFriends){
            if(friends.get(0) != member.getName()){
                member.addFriend(friends.get(0));
            }
            if(friends.get(1) != member.getName()){
                member.addFriend(friends.get(1));
            }

        }

    }

    private static void scoredFriendOfFriends(List<List<String>> friends){
        for(List<String> friend : friends){
            List<String> friendOfFriend =
                    friend.stream()
                            .filter( s -> !member.getFriends().contains(s))
                            .collect(Collectors.toList());
            calculateScore(friendOfFriend.get(0), 10);
        }
    }

    private static void calculateScore(String user, int point){
        if(isExist(user)){
            int value = recommendedFriend.get(user);
            recommendedFriend.replace(user, value + point);
        }
        else{
            recommendedFriend.put(user, 10);
        }
    }

    private static boolean isExist(String user){
        return recommendedFriend.containsKey(user);
    }

    private static void scoredVisitors(List<String> visitors){
        List<String> filterFriend = visitors.stream()
                .filter( s -> !member.getFriends().contains(s))
                .collect(Collectors.toList());
        for(String visitor : filterFriend){
            calculateScore(visitor, 1);
        }
    }
}
