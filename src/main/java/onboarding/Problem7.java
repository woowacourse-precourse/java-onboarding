package onboarding;

import java.util.*;

public class Problem7 {
    private static int SCORE_10 = 10;
    private static int SCORE_1 = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Set<String>> friendsMap = createFriendsList(friends);
        HashMap<String,Integer> scoreMap = createScoreMap(friendsMap,user);

        return answer;
    }

    public static HashMap<String, Set<String>> createFriendsList(List<List<String>> friends){
        HashMap<String, Set<String>> map = new HashMap<>();
        for(List<String> friend : friends){
            Set<String> set = map.getOrDefault(friend.get(0),new TreeSet<>());
            set.add(friend.get(1));
            map.put(friend.get(0),set);
            set = map.getOrDefault(friend.get(1),new TreeSet<>());
            set.add(friend.get(0));
            map.put(friend.get(1),set);
        }
        return map;
    }

    public static HashMap<String,Integer> createScoreMap(Map<String, Set<String>> friendsMap,String user){
        HashMap<String,Integer> scoreMap = new HashMap<>();
        for(String key : friendsMap.keySet()){
            Set<String> set = friendsMap.get(key);
            int cnt = 0;
            for(String set_key : set){
                if(friendsMap.get(user).contains(set_key)){
                    cnt+=SCORE_10;
                }
            }
            addscore(scoreMap,key,cnt);
        }
        return scoreMap;
    }

    public static void addscore(Map<String,Integer> fre,String key,int score){
        fre.put(key,fre.getOrDefault(key,0)+score);
    }
}
