package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> CurrentFriends = CurrentFriends(user, friends);
        HashMap<String, Integer> PossibleFriends = PossibleFreind(user, friends, CurrentFriends);



        return answer;
    }

    HashMap<String, Integer> PossibleFriend(String usr, List<List<String>> friends, List<String> CurrentFriends){
        HashMap<String, Integer> PossibleFriends = new HashMap<>();
        for (int i = 0; i < friends.size(); i++){
            for (int j = 0; j < 2; j++){
                if (!CurrentFriends.contains(friends.get(i).get(j)) && friends.get(i).get(j) != usr){
                    PossibleFriends.put(friends.get(i).get(j), 0);
                }
            }
        }
        return PossibleFriends;
    }

    private static List<String> CurrentFriends(String usr, List<List<String>> friends){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).contains(usr)){
                list.add(friends.get(i).get(0));
                list.add(friends.get(i).get(1));
            }
        }
        list.remove(usr);
        return list;
    }
}
