package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {


        HashSet<String> usernameSet = getAllUsers(friends, visitors);

        // initialize all users' score to zero
        HashMap<String, Integer> score = new HashMap<>();
        for (String username: usernameSet){
            score.put(username, 0);
        }


        // find user's direct friend
        HashSet<String> directFriends = searchFriends(user, friends);

        // find user's mutual friend (direct friends' friends)
        HashSet<String> mutualFriends = new HashSet<>();
        for(String directFriend: directFriends) {
            HashSet<String> mutualFriend = searchFriends(directFriend, friends);
            mutualFriends.addAll(mutualFriend);
        }
        mutualFriends.remove(user);

        // add score to mutual friends
        for(String mutualFriend: mutualFriends){ // andole
            for(List<String> friendList: friends){ // ["donut", "andole"]
                if(friendList.contains(mutualFriend)){ // true
                    // find in scoreList and add score
                    findUserAndUpdateScore(score, mutualFriend, 10);
                }
            }
        }

        // add score to visitors
        for(String visitor: visitors){
            // find in scoreList and add score
            findUserAndUpdateScore(score, visitor, 1);
        }

        // sort score by value
        score = sortMapByValue(score);

        List<String> answer = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: score.entrySet()){
            String key = entry.getKey();
            if(key != user && !directFriends.contains(key) &&  score.get(key) > 0) {
                answer.add(entry.getKey());
                if(answer.size() >= 5){
                    break;
                }
            }
        }
        return answer;
    }

    private static HashMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {

        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(map.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> res = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            res.put(aa.getKey(), aa.getValue());
        }

        return res;
    }

    private static HashSet<String> getAllUsers(List<List<String>> friends, List<String> visitors) {
        // create a set to get all users in friends and visitors
        HashSet<String> usernameSet = new HashSet<>();

        // add users from friends
        for(List<String> friendList: friends){ // ["donut", "andole"]
            for(String name: friendList){ // "donut"
                usernameSet.add(name);
            }
        }
        //add users from visitors
        for(String visitor: visitors){
            usernameSet.add(visitor);
        }
        return usernameSet;
    }

    private static HashSet<String> searchFriends(String user, List<List<String>> friends) {
        HashSet<String> friendsSet = new HashSet<String>();
        // find friends
        for(List<String> friendList : friends){
            if(friendList.contains(user)){
                for(String friendName: friendList){
                    if(friendName != user){
                        friendsSet.add(friendName);
                    }
                }
            }
        }
        return friendsSet;
    }

    private static void findUserAndUpdateScore(HashMap<String, Integer> searchedMap, String user, int points) {
        for(String key: searchedMap.keySet()){
            if(key== user){
                searchedMap.put(key, searchedMap.get(key)+ points);
            }
        }
    }

}