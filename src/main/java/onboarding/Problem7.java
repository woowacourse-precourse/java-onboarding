package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

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

        // initialize all users' score to zero
        HashMap<String, Integer> usernameAndScoreMap = new HashMap<>();
        for (String username: usernameSet){
            usernameAndScoreMap.put(username, 0);
        }


        // find user's direct friend
        HashSet<String> directFriends = new HashSet<String>();
        // find friends
        for(List<String> friendList : friends){
            if(friendList.contains(user)){
                for(String friendName: friendList){
                    if(friendName != user){
                        directFriends.add(friendName);
                    }
                }
            }
        }

        // find user's mutual friend (direct friends' friends)
        HashSet<String> mutualFriends = new HashSet<>();
        for(String directFriend: directFriends) {
            // find friends
            for (List<String> friendList : friends) {
                if (friendList.contains(directFriend)) {
                    for (String friendName : friendList) {
                        if (friendName != directFriend) {
                            mutualFriends.add(friendName);
                        }
                    }
                }
            }
        }
        mutualFriends.remove(user);
        System.out.println(mutualFriends);

        // add score to mutual friends
        for(String mutualFriend: mutualFriends){ // andole
            for(List<String> friendList: friends){ // ["donut", "andole"]
                if(friendList.contains(mutualFriend)){ // true
                    // find in scoreList and add score
                    findUserAndUpdateScore(usernameAndScoreMap, mutualFriend, 10);
                }
            }
        }

        // add score to visitors
        for(String visitor: visitors){
            // find in scoreList and add score
            findUserAndUpdateScore(usernameAndScoreMap, visitor, 1);
        }

        HashMap<String,Integer> finalScore = new HashMap<>();
        // remove user and direct friends from scoreList
        for(String key: usernameAndScoreMap.keySet()){ // andole
            if(key!=user && !directFriends.contains(key) &&  usernameAndScoreMap.get(key) > 0){
                // add to final score map
                finalScore.put(key, usernameAndScoreMap.get(key));
                if(finalScore.size()>=5){
                    break;
                }
            }
        }

        List<String> answer =   new ArrayList<>();

        // sort final score by value
        HashMap<String, Integer> sortedScore = new HashMap<>();
        finalScore.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedScore.put(x.getKey(), x.getValue()));

        System.out.println(sortedScore);

        for(Map.Entry<String,Integer> entry: sortedScore.entrySet()){
            answer.add(entry.getKey());
        }

        return answer;
    }

    private static void findUserAndUpdateScore(HashMap<String, Integer> searchedMap, String user, int points) {
        for(String key: searchedMap.keySet()){
            if(key== user){
                searchedMap.put(key, searchedMap.get(key)+ points);
            }
        }
    }

}