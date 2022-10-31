package onboarding;

import java.util.*;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new LinkedList<>();
        if(!isVaildUser(user) || !isValidFriendsList(friends)){
            return answer;
        }
        List<String> userFriends = getUserFriends(friends, user);
        List<String> friendsFriends = getFriendsFriends(friends, userFriends);
        removeUserFriendsInList(userFriends, friendsFriends, user);
        Map<String, Integer> recommendScore = getFriendsScore(friendsFriends);
        getVisitScore(recommendScore, visitors);
        removeFriendsInMap(recommendScore, userFriends);
        List<Map.Entry<String, Integer>> result = sortMapToList(recommendScore);
        getAnswer(result, answer);
        return answer;
    }

    private static boolean isVaildUser(String user){
        if(user == null)
            return false;

        return user.length() >= 1 && user.length() <= 30;
    }

    private static boolean isValidFriendsList(List<List<String>> friends){
        for(List<String> friendRelation : friends){
            if(friendRelation.size() != 2){
                return false;
            }
        }

        return friends.size() >= 1 && friends.size() <= 10000;
    }

    private static boolean isValidID(String input){
        if(!input.toLowerCase().equals(input)){
            return false;
        }
        return input.length() >= 1 && input.length() <= 30;
    }
    private static List<String> getUserFriends(List<List<String>> friends, String user){
        Set<String> userFriends = new LinkedHashSet<>();
        for(List<String> relation: friends){
            if(relation.contains(user)){
                userFriends.add(relation.get(0));
                userFriends.add(relation.get(1));
            }
        }
        userFriends.remove(user);

        return new LinkedList<>(userFriends);
    }
    private static List<String> getFriendsFriends(List<List<String>> friends, List<String> userFriends){
        List<String> result = new ArrayList<>();
        for(String friend: userFriends){
            result.addAll(getUserFriends(friends, friend));
        }
        return result;
    }

    private static void removeUserFriendsInList(List<String> userFriends, List<String> friendsFriends, String user){

        for(String friend: userFriends){
            while(friendsFriends.remove(friend));
        }
        while(friendsFriends.remove(user));
    }

    private static Map<String, Integer> getFriendsScore(List<String> friendsFriends){
        Map<String, Integer> result = new LinkedHashMap<>();
        for(String friend : friendsFriends){
            if(result.containsKey(friend)){
                result.put(friend, result.get(friend) + 10);
            }else{
               result.put(friend, 10);
            }
        }

        return result;
    }

    private static void getVisitScore(Map<String, Integer> recommendScore, List<String> visitors){
        for(String visitor: visitors){
            if(recommendScore.containsKey(visitor)){
                recommendScore.put(visitor, recommendScore.get(visitor) + 1);
            }else{
                recommendScore.put(visitor, 1);
            }
        }
    }

    private static void removeFriendsInMap(Map<String, Integer> recommendScore, List<String> friends){
        for(String friend: friends){
            recommendScore.remove(friend);
        }
    }

    private static List<Map.Entry<String, Integer>> sortMapToList(Map<String, Integer> recommendScore){
        List<Map.Entry<String, Integer>> result = new LinkedList<>(recommendScore.entrySet());
        result.sort((Map.Entry.comparingByKey()));
        result.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        return result;
    }

    private static void getAnswer(List<Map.Entry<String, Integer>> result, List<String> answer){
        for(int i = 0; i<result.size() && i<5; i++){
            answer.add(result.get(i).getKey());
        }
    }

}
