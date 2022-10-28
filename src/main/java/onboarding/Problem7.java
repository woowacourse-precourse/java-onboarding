package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> friendsInformation = initializeFriendsInformation(friends);
        List<String> friendsOfFriendsOfUser = findFriendsOfFriendsOfUser(user, friendsInformation);
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
        if(!friendsInformation.containsKey(user)){
            return null;
        }
        for(String friend : friendsInformation.get(user)) {
            if(!friendsInformation.containsKey(friend)) {
                continue;
            }
            for(String friendOfFriend : friendsInformation.get(friend)) {
                if(friendOfFriend.equals(user)){
                    continue;
                }
                if(checkDirectFriend(friendOfFriend, friendsInformation.get(user)));
                friendsOfFriendsOfUser.add(friendOfFriend);
            }
        }
        return friendsOfFriendsOfUser;
    }

    public static boolean checkDirectFriend(String person, List<String> userFriends){
        return userFriends.contains(person);
    }
}
