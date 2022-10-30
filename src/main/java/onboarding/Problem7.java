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

        System.out.println("Before Sorting: " + score);
        // sort score by value
        score = getSortedScore(score);
        System.out.println("After Sorting: " + score);

        List<String> answer =   new ArrayList<>();
        for(Map.Entry<String,Integer> entry: score.entrySet()){
            String key = entry.getKey();
            if(key != user && !directFriends.contains(key) &&  score.get(key) > 0) {
                answer.add(entry.getKey());
                if(answer.size() >= 5){
                    break;
                }
            }
        }
        System.out.println(answer);

        return answer;
    }

    private static HashMap<String, Integer> getSortedScore(HashMap<String, Integer> unsortedScore) {
        HashMap<String, Integer> sortedScore = new HashMap<>();
        unsortedScore.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedScore.put(x.getKey(), x.getValue()));
        return sortedScore;
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