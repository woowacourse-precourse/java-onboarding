package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        return answer;
    }

    public static String findMyFriend( String myname, List<String> friends){
        String userfriends = "";

        if(friends.contains(myname)){
            if(friends.get(0).equals(myname)) {
                userfriends= friends.get(1);
            }
            else if(friends.get(1).equals(myname)){
                userfriends = (friends.get(0));
            }
        }
        return userfriends;
    }

    public static List<String> findUserFreinds(String user, List<List<String>> friends){
        List<String> userfriends= new ArrayList<>();
        for (int i=0; i< friends.size(); i++) {
            String uesrfriend = findMyFriend(user, friends.get(i));
            if (!uesrfriend.isEmpty()) {
                userfriends.add(findMyFriend(user, friends.get(i)));
            }
        }
        return userfriends;
    }

}

