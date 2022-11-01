package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendsOfUser = findFriendsOfUser(user, friends);
        List<String> commonFriends = findCommonFriends(friends, friendsOfUser, user);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findFriendsOfUser(String user, List<List<String>> friends){

        List<String> friendsOfUser = new ArrayList<>();

        for(int i=0; i < friends.size() ; i++){
            if(friends.get(i).contains(user)){
                int userIndex = friends.get(i).indexOf(user);
                friendsOfUser.add(friends.get(i).get(1-userIndex));
            }
        }
        return friendsOfUser;
    }

    public static List<String> findCommonFriends(List<List<String>> friends, List<String> friendsOfUser, String user){
        ArrayList<String> commonFriends = new ArrayList<>();

        for(int i=0; i<friends.size(); i++){
            if(friendsOfUser.contains(friends.get(i).get(0))) commonFriends.add(friends.get(i).get(1));
            if(friendsOfUser.contains(friends.get(i).get(1))) commonFriends.add(friends.get(i).get(0));
        }

        while(commonFriends.contains(user)){
            commonFriends.remove(user);
        }

        while(commonFriends.contains(friendsOfUser)){
            commonFriends.removeAll(friendsOfUser);
        }

        return commonFriends;
    }


}
