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
        String myfriend = "";

        if(friends.contains(myname)){
            if(friends.get(0).equals(myname)) {
                myfriend= friends.get(1);
            }
            else if(friends.get(1).equals(myname)){
                myfriend = friends.get(0);
            }
        }
        return myfriend;
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

    public static List<String> findFriendsOfUserFriends(String user, List<String> userfriends, List<List<String>> friends){
        List<String> freindoffriend = new ArrayList<>();
        for (int i = 0; i < userfriends.size(); i++) {
            for(int j=0; j<friends.size(); j++) {
                if(!friends.get(j).contains(user)) {
                    String myfreind = findMyFriend(userfriends.get(i), friends.get(j));
                    if (!myfreind.isEmpty()) {
                        freindoffriend.add(myfreind);
                    }
                }
            }
        }
        return freindoffriend;
    }

    public static Map<String,Integer> countScoreByFriendsOfUserFriends(Map<String,Integer> nameandscore, List<String>freindsofuserfriend){
        Map<String,Integer> result = nameandscore;
        for(int i=0; i<freindsofuserfriend.size(); i++){
            if(!nameandscore.containsKey(freindsofuserfriend.get(i))){
                nameandscore.put(freindsofuserfriend.get(i), 10);
            }
            else if(nameandscore.containsKey(freindsofuserfriend.get(i))){
                int score = nameandscore.get(freindsofuserfriend.get(i));
                nameandscore.put(freindsofuserfriend.get(i), score +10);
            }
        }
        return result;
    }

}

