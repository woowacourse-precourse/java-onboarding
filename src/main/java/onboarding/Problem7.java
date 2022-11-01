package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends = findUserFriend(user, friends);
        HashMap<String, Integer> notUserFriends = new HashMap<>();
        notUserFriends = findNotFriendInFriends(user, friends, userFriends, notUserFriends);
        return answer;
    }
    public static List<String> findUserFriend(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)){
                userFriends.add(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1).equals(user)){
                userFriends.add(friends.get(i).get(0));
            }
        }
        return userFriends;
    }
    public static HashMap<String, Integer> findNotFriendInFriends(String user, List<List<String>> friends, List<String> userFriends, HashMap<String, Integer> notUserFriends){
        List<List<String>> friendsExceptUser = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if(!friends.get(i).contains(user)){
                friendsExceptUser.add(friends.get(i));
            }
        }
        for (int i = 0; i < friendsExceptUser.size(); i++) {
            if(userFriends.contains(friendsExceptUser.get(i).get(0)) && !userFriends.contains(friendsExceptUser.get(i).get(1))){
                if(!notUserFriends.containsKey(friendsExceptUser.get(i).get(1))){
                    notUserFriends.put(friendsExceptUser.get(i).get(1), 10);
                }
                else{
                    notUserFriends.put(friendsExceptUser.get(i).get(1), notUserFriends.get(friendsExceptUser.get(i).get(1))+10);
                }
            }
            else if(userFriends.contains(friendsExceptUser.get(i).get(1)) && !userFriends.contains(friendsExceptUser.get(i).get(0))){
                if(!notUserFriends.containsKey(friendsExceptUser.get(i).get(0))){
                    notUserFriends.put(friendsExceptUser.get(i).get(0), 10);
                }
                else{
                    notUserFriends.put(friendsExceptUser.get(i).get(0), notUserFriends.get(friendsExceptUser.get(i).get(0))+10);
                }
            }
        }
        return notUserFriends;
    }
}
