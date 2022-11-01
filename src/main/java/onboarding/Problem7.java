package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    private final static int LEFT_FRIEND = 0;
    private final static int RIGHT_FRIEND = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = List.of("");
        List<String> everyFriendList = makeEveryFriendsList(user,friends);
        List<String> alreadyFriends = findAlreadyFriends(user,friends);
        List<String> notFriends = findNotFriends(everyFriendList,alreadyFriends);
        return answer = notFriends;
    }

    private static List<String> makeEveryFriendsList(String user, List<List<String>> friends){
        List<String> FriendList = new ArrayList<>();
        for(List<String> friend : friends){
            for(String name:friend){
                if(name!=user && !FriendList.contains(name))
                    FriendList.add(name);
            }
        }
        return  FriendList;
    }

    private  static List<String> findAlreadyFriends(String user,List<List<String>> friends){
        List<String> alreadyFriend = new ArrayList<>();
        for(List<String> friend : friends){
            if(friend.get(LEFT_FRIEND) == user) {
                alreadyFriend.add(friend.get(RIGHT_FRIEND));
            }
            if(friend.get(RIGHT_FRIEND) == user) {
                alreadyFriend.add(friend.get(LEFT_FRIEND));
            }
        }
        return alreadyFriend;
    }

    private static List<String> findNotFriends(List<String> everyFriendList,List<String> alreadyFriends){
        List<String> notFriends = new ArrayList<>();
        for(String name : alreadyFriends){
            everyFriendList.remove(name);
        }
        notFriends = everyFriendList;
        return notFriends;
    }
}
