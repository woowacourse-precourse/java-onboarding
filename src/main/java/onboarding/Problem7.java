package onboarding;

import java.util.*;

public class Problem7 {

    public static Map<String, List<String>> makeFriendInfoMap(List<List<String>> friends){

        Map<String, List<String>> snsFriendMap = new HashMap<>();

        for(List<String> friendList : friends){
            String friend1 = friendList.get(0);
            String friend2 = friendList.get(1);

            if (snsFriendMap.containsKey(friend1)){
                snsFriendMap.get(friend1).add(friend2);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(friend2);
                snsFriendMap.put(friend1,newList);
            }
            if(snsFriendMap.containsKey(friend2)){
                snsFriendMap.get(friend2).add(friend1);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(friend1);
                snsFriendMap.put(friend2,newList);
            }

        }
        return snsFriendMap;

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> snsFriendMap = makeFriendInfoMap(friends);

        return answer;
    }
}
