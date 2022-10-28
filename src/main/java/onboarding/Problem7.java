package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // 친구 리스트
        ArrayList<String> friendsList = new ArrayList<String>();

        // 친구 관계를 표시할 HashMap
        HashMap<String, ArrayList<String>> friendsMap = new HashMap<String, ArrayList<String>>();

        //
        for(List<String> friendsRelation : friends) {
            makeFriendsMap(friendsRelation, friendsMap);
        }
        return answer;
    }

    public static void makeFriendsMap(List<String> friendsRelation, HashMap<String, ArrayList<String>> friendsMap) {
        String friend1 = friendsRelation.get(0);
        String friend2 = friendsRelation.get(1);

        if(friendsMap.containsKey(friend1)) {
            friendsMap.get(friend1).add(friend2);
        } else {
            friendsMap.put(friend1, new ArrayList<>(Arrays.asList(friend2)));
        }

        if(friendsMap.containsKey(friend2)) {
            friendsMap.get(friend2).add(friend1);
        } else {
            friendsMap.put(friend2, new ArrayList<>(Arrays.asList(friend1)));
        }
    }
}
