package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getUserFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if(friend.get(0).equals(user)){
                userFriends.add(friend.get(0));
                continue;
            }
            userFriends.add(friend.get(1));
        }
        return userFriends;
    }

    public static Map<String,List<String>> makeFriendsMap(String user, List<String> userFriends, List<List<String>> friends){
        Map<String,List<String>> friendsMap = new HashMap<>();

        for (List<String> friend : friends){

            if(userFriends.contains(friend.get(0)) || userFriends.contains(friend.get(1))) continue;

            makeRelation(friend,friendsMap);

            }

        return friendsMap;
    }


    public static void makeRelation(List<String> friend, Map<String, List<String>> friendsMap){

        List<String> friends;

        if(friendsMap.containsKey(friend.get(0))){

            friends = friendsMap.get(friend.get(0));

        }else{

            friends = new ArrayList<>();

        }

        friends.add(friend.get(1));
        friendsMap.put(friend.get(0),friends);

        if(friendsMap.containsKey(friend.get(1))){

            friends = friendsMap.get(friend.get(1));

        }else{

            friends = new ArrayList<>();

        }

        friends.add(friend.get(0));
        friendsMap.put(friend.get(1),friends);

    }

}
