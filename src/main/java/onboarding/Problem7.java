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
                friendsMap.put(oldFriendName, 0);
            }
        }
    }
}
