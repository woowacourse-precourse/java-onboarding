package onboarding;

import java.util.*;

public class Problem7 {

    static Map<String,List<String>> friendMap = new HashMap<>();
    static Map<String, Integer> friendScoreMap = new TreeMap<>();
    static String target;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        target = user;
        // 친구 목록 뽑기
        for (List<String> friend : friends) {
            addFriend(friend.get(0), friend.get(1));
            addFriend(friend.get(1), friend.get(0));
        }
        // user의 친구목록 탐색
        if(friendMap.containsKey(user)){
            for(String userFriend : friendMap.get(user)){
                for(String friend : friendMap.get(userFriend)){
                    addScore(friend, 10);
                }
            }
        }else{
            friendMap.put(user, new ArrayList<>());
        }
        // visitor 탐색
        for(String visitor : visitors){
            addScore(visitor, 1);
        }

        friendScoreMap.remove(user);
        List<String> keySet = new ArrayList<>(friendScoreMap.keySet());
        keySet.sort((o1, o2) -> friendScoreMap.get(o2) - friendScoreMap.get(o1));

        int cnt = 0;
        for(String key : keySet){
            answer.add(key);
            ++cnt;
            if(cnt == 5){
                break;
            }
        }

        return answer;
    }

    private static void addFriend(String idA, String idB){
        if(friendMap.containsKey(idA)){
            friendMap.get(idA).add(idB);
        }else{
            List<String> strList = new ArrayList<>();
            strList.add(idB);
            friendMap.put(idA,strList);
        }
    }

    private static void addScore(String friend, int score){
        if(friendMap.get(target).contains(friend)){
            return;
        }
        if(friendScoreMap.containsKey(friend)){
            friendScoreMap.put(friend,friendScoreMap.get(friend) + score);
        }else{
            friendScoreMap.put(friend,score);
        }
    }


}
