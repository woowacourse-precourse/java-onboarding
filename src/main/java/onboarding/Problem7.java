package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> friendsMap = new HashMap<>();
        checkOldFriends(friends, user, friendsMap);
        return answer;
    }

    private static void checkOldFriends(List<List<String>> friendsList, String userName, HashMap friendsMap){
        for(int i = 0; i < friendsList.size(); i++){
            int oldFriends = friendsList.get(i).indexOf(userName);
            if(oldFriends > -1){
                String oldFriendName = friendsList.get(i).get(1-oldFriends);
                putNewFriends(friendsList, oldFriendName, friendsMap, userName);
            }
        }
    }

    private static void putNewFriends(List<List<String>> friendsList, String oldFriendName, HashMap friendsMap, String userName){
        for(int i = 0; i < friendsList.size(); i++){
            int newFriends = friendsList.get(i).indexOf(oldFriendName);
            if(newFriends > -1 && !friendsList.get(i).get(1 - newFriends).equals(userName)){
                if(friendsMap.containsKey(friendsList.get(i).get(1 - newFriends))) friendsMap.put(friendsList.get(i).get(1 - newFriends), (int)friendsMap.get(friendsList.get(i).get(1 - newFriends))+10);
                if(!friendsMap.containsKey(friendsList.get(i).get(1 - newFriends))) friendsMap.put(friendsList.get(i).get(1 - newFriends), 10);
            }
        }
    }
}
