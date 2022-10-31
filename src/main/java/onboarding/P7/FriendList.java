package onboarding.P7;

import java.util.ArrayList;
import java.util.List;

public class FriendList {
    public List<String> friendsList(String user, List<List<String>> friends){
        List<String> userfriend = new ArrayList<>();
        for(int i=0; i< friends.size(); i++){
            if(user == friends.get(i).get(1)){
                userfriend.add(friends.get(i).get(0));
            }
        }
        return userfriend;
    }

    public List<String> FriendOfFriend(String user, List<List<String>> friends, List<String> usersfriend){
        List<String> userfriendfriend = new ArrayList<>();
        for(int i=0; i< friends.size(); i++){
            for(String s : usersfriend){
                if(friends.get(i).get(0) == s && friends.get(i).get(1) != user){
                    userfriendfriend.add(friends.get(i).get(1));
                }
            }
        }
        return userfriendfriend;
    }
}
