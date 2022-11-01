package onboarding;

import com.sun.source.tree.NewArrayTree;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getUserFriends(String user, List<List<String>> friends){

        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if(friend.get(0).equals(user)){
                userFriends.add(friend.get(0));
                continue;
            }
            userFriends.add(friend.get(1));
        }
        return userFriends;
    }

    public static Map<String,List<String>> makeFriendsMap(String user, List<String> userFriends, List<List<String>> friends){

        Map<String,List<String>> friendsMap = new HashMap<>();

        for (List<String> friend : friends){

            if(userFriends.contains(friend.get(0)) || userFriends.contains(friend.get(1))) continue;

            makeRelation(friend,friendsMap);

            }

        return friendsMap;
    }

    public static Map<String,Integer> makeScoreMap(Map<String,List<String>> friendsMap,List<String> visitors){

        Map<String,Integer> scoreMap = new HashMap<>();
        Set<String> keySet = friendsMap.keySet();

        for(String user : keySet){
            scoreMap.put(user,0);
        }

        for(String user: visitors){
            scoreMap.put(user,0);
        }

        return scoreMap;
    }


    public static void makeRelation(List<String> friend, Map<String, List<String>> friendsMap){

        List<String> friends;

        if(friendsMap.containsKey(friend.get(0))){

            friends = friendsMap.get(friend.get(0));

        }else{

            friends = new ArrayList<>();

        }

        friends.add(friend.get(1));
        friendsMap.put(friend.get(0),friends);

        if(friendsMap.containsKey(friend.get(1))){

            friends = friendsMap.get(friend.get(1));

        }else{

            friends = new ArrayList<>();

        }

        friends.add(friend.get(0));
        friendsMap.put(friend.get(1),friends);

    }

    public static void scoring(Map<String,Integer> scoreMap,Map<String,List<String>> friendsMap ,List<String> userFriends,List<String> visitors){

        visitScoring(scoreMap,visitors);
        friendScoring(scoreMap,userFriends,friendsMap);

    }

    public static void visitScoring(Map<String,Integer> scoreMap,List<String> visitors){

        for (String visitor : visitors){
            Integer score = scoreMap.get(visitor);
            scoreMap.put(visitor,score+1);
        }

    }

    public static void friendScoring(Map<String,Integer> scoreMap, List<String> userFriends, Map<String,List<String>> friendsMap){

        List<String> scoreList = new ArrayList<>();
        for(String userFriend : userFriends){
            scoreList.addAll(friendsMap.get(userFriend));
        }

        for(String user : scoreList){
            Integer score = scoreMap.get(user);
            scoreMap.put(user,score+10);
        }

    }

    public static List<Entry<String,Integer>> getSortedEntries(Map<String,Integer> scoreMap){
        List<Entry<String,Integer>> entries = new ArrayList<>(scoreMap.entrySet());
        entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));
        return entries;
    }

    public static List<String> getRecommendList(List<Entry<String,Integer>> entries){
        return entries.stream()
                .filter(i-> i.getValue() != 0)
                .map(Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

}
