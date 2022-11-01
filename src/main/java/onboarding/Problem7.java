package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    public static HashMap<String,Boolean> user_friend;
    public static HashMap<String,Integer> friend_friend;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        user_friend = new HashMap<String,Boolean>();
        friend_friend = new HashMap<String,Integer>();
        List<String> answer = Collections.emptyList();

        return answer;
    }

    public static void userFriendCheck(String user,List<List<String>> friends){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(0)==user){
                user_friend.put(friends.get(i).get(1),true);
            }
            else if(friends.get(i).get(1)==user){
                user_friend.put(friends.get(i).get(0),true);
            }
            else continue;
        }
    }

    public static void friendOfFriend(String user,List<List<String>> friends){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(0)==user||friends.get(i).get(1)==user)continue;
            else{
                if(user_friend.containsKey(friends.get(i).get(0))==true){
                    friendException(friends.get(i).get(1));
                }
                else if(user_friend.containsKey(friends.get(i).get(1))==true){
                    friendException(friends.get(i).get(0));
                }
                else continue;
            }
        }

    }
    
    public static void friendException(String name){
        if(user_friend.containsKey(name)==true) return;
        else{
            if(friend_friend.containsKey(name)==false){
                friend_friend.put(name,10);
            }
            else{
                friend_friend.put(name,friend_friend.get(name)+10);
            }
        }
    }
}
