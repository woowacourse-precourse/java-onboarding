package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendship = Friendship(friends);
        HashMap<String, Integer> scoreTable = ScoreTable(user,friendship);

        ScoreFriendOfUser(scoreTable, friendship, user,10);
        ScoreVisitOfUser(scoreTable,visitors, 1);

        return FinalResult(scoreTable,friendship, user, 5);
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
            scoreTable.put(friend, scoreTable.getOrDefault(friend, 1) + score);
    }

    public static List<String> FinalResult(HashMap<String, Integer> scoreTable,
                                  Map<String, List<String>> friendship, String user, int maxSize) {
        List<String> result = new ArrayList<>();

        //user와 uesr의 친구 삭제
        for(String friend: scoreTable.keySet()){
            if(!friend.equals(user) && !friendship.get(user).contains(friend)){
                result.add(friend);
            }
        }

        //점수 순, 동점은 ueserId 순
        result.sort((user1, user2) -> {
            if(scoreTable.get(user1) == scoreTable.get(user2)) {
                return user1.compareTo(user2);
            }
            return scoreTable.get(user2) - scoreTable.get(user1);
        });

        System.out.println("result = " + result);

        if (result.size() < maxSize) {
            maxSize = result.size();
        }
        return result.subList(0, maxSize);
    }

}
