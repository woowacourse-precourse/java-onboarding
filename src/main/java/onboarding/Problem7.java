package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static int SCORE_10 = 10;
    private static int SCORE_1 = 1;
    public static HashMap<String, Set<String>> friendsMap;
    public static HashMap<String,Integer> scoreMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsMap = createFriendsList(friends);
        createScoreMap(user);
        addVisitorsScore(visitors);
        scoreMap.put(user,0);
        Map<String,Integer> filterFriendsMap = filteringFriends(getOrDefaultSet(friendsMap,user));

        List<String> answer = new ArrayList<>(filterFriendsMap.keySet());
        answer.sort((f1, f2) ->{
            if(filterFriendsMap.get(f1).equals(filterFriendsMap.get(f2))) return f1.compareTo(f2);
            return filterFriendsMap.get(f2) - filterFriendsMap.get(f1);
        });
        if ( answer.size() > 5){
            answer = answer.stream().limit(5).collect(Collectors.toList());
        }
        return answer;
    }

    public static HashMap<String, Set<String>> createFriendsList(List<List<String>> friends){
        HashMap<String, Set<String>> map = new HashMap<>();
        for(List<String> friend : friends){
            Set<String> set = getOrDefaultSet(map,friend.get(0));
            set.add(friend.get(1));
            map.put(friend.get(0),set);
            set = map.getOrDefault(friend.get(1),new TreeSet<>());
            set.add(friend.get(0));
            map.put(friend.get(1),set);
        }
        return map;
    }

    public static Set<String> getOrDefaultSet(HashMap<String,Set<String>> map,String key){
        return map.getOrDefault(key,new TreeSet<>());
    }

    public static void createScoreMap(String user){
        scoreMap = new HashMap<>();
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
    }

    public static void addVisitorsScore(List<String> visitors){
        visitors.forEach((visitor)->{
            addscore(scoreMap,visitor,SCORE_1);
        });

    }

    public static Map<String,Integer> filteringFriends(Set<String> user){
        Map<String,Integer> res = new HashMap<>();
        for(String friend : scoreMap.keySet()){
            if( !isFriend(user,friend) && scoreMap.get(friend) !=0 ){
                res.put(friend,scoreMap.get(friend));
            }
        }
        return res;
    }

    public static void addscore(Map<String,Integer> fre,String key,int score){
        fre.put(key,fre.getOrDefault(key,0)+score);
    }
    public static boolean isFriend(Set<String> friend,String name){
        if (friend.contains(name)){
            return true;
        }
        return false;
    }
}
