package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> friendship = Friendship(friends);
        HashMap<String, Integer> scoreTable = ScoreTable(user,friendship);

        ScoreFriendOfUser(scoreTable, friendship, user,10);
        ScoreVisitOfUser(scoreTable,visitors, 1);
        System.out.println("friendship.keySet() = " + scoreTable.keySet());
        System.out.println("friendship.values() = " + scoreTable.values());
        return answer;
    }

    public static HashMap<String, List<String>> Friendship(List<List<String>> friends) {
        HashMap<String, List<String>> friendship= new HashMap<>();

        for(List<String> friend : friends){
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            addHashMap(friendship,user1,user2);
            addHashMap(friendship,user2,user1);
        }

        return friendship;
    }

    public static void addHashMap(HashMap<String, List<String>> hashMap, String key, String value) {
        if(hashMap.containsKey(key))
            hashMap.get(key).add(value);
        else
            hashMap.put(key,new ArrayList<>(List.of(value)));
    }

    public static HashMap<String, Integer> ScoreTable(String user, Map<String, List<String>> friendship){
        HashMap<String, Integer> scoreTable= new HashMap<>();
        for(String friend: friendship.keySet()){
            if(!friend.equals(user) && !friendship.get(user).contains(friend)){
                scoreTable.put(friend,0);
            }
        }
        return scoreTable;
    }

    public static void ScoreFriendOfUser(HashMap<String, Integer> scoreTable,
                                         Map<String, List<String>> friendship, String user, int score) {
        for(String userFriend : friendship.get(user)){
            for(String friend : friendship.get(userFriend)){
                if(scoreTable.containsKey(friend))
                    scoreTable.put(friend,scoreTable.get(friend) + score);
            }
        }
    }

    public static void ScoreVisitOfUser(HashMap<String, Integer> scoreTable,
                                        List<String> visitors, int score) {
        for(String friend : visitors)
            scoreTable.put(friend, scoreTable.getOrDefault(friend, 0) + score);
    }

}
