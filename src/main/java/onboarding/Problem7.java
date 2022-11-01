package onboarding;

import java.util.*;

public class Problem7 {
    public static void makeNonFriendList(String user,List<List<String>> friends,List<String> myFriend,List<String> nonFriend,List<String> visitors){
        Map<String,Integer> scoreMap = new HashMap<>();
        int score = 0;
        for(int i=0;i<friends.size();i++){
            List<String> friend = friends.get(i);
            
        }
    }
    public static void makeFriendList(String user,List<List<String>> friends,List<String> myFriend){

        for(int i=0;i<friends.size();i++){
            List<String> friend = friends.get(i);
            if(friend.contains(user)){
                String myF = friend.indexOf(user) == 0 ? friend.get(1) : friend.get(0);
                myFriend.add(myF);

            }
        }

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> myFriend = new ArrayList<>();
        List<String> nonFriend = new ArrayList<>();

        makeFriendList(user,friends,myFriend);
        makeNonFriendList(user,friends,myFriend,nonFriend,visitors);
        return answer;
    }
}
