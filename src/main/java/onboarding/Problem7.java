package onboarding;

import javax.swing.*;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> friendsMap = new HashMap<>();
        List<String> oldFriendNames = checkOldFriends(friends, user, friendsMap, visitors);
        putNewFriends(friends, oldFriendNames, friendsMap, user);
        return answer;
    }

    private static List<String> checkOldFriends(List<List<String>> friendsList, String userName, HashMap friendsMap, List<String> visitor){
        List<String> oldFriendNames = new ArrayList<>();

        for(int i = 0; i < friendsList.size(); i++){
            int oldFriends = friendsList.get(i).indexOf(userName);
            if(oldFriends > -1) oldFriendNames.add(friendsList.get(i).get(1-oldFriends));
        }

        return oldFriendNames;
    }

    private static void putNewFriends(List<List<String>> friendsList, List<String> oldFriendName, HashMap friendsMap, String userName){
        for(int i = 0; i < friendsList.size(); i++){
            for(int j = 0; j < oldFriendName.size(); j++){
                int newFriends = friendsList.get(i).indexOf(oldFriendName.get(j));
                if(newFriends > -1 && !friendsList.get(i).get(1 - newFriends).equals(userName)){
                    String newFriendName = friendsList.get(i).get(1 - newFriends);
                    if(friendsMap.containsKey(newFriendName)) friendsMap.put(newFriendName, (int)friendsMap.get(newFriendName)+10);
                    if(!friendsMap.containsKey(newFriendName)) friendsMap.put(newFriendName, 10);
                }
            }
        }
    }
}
