package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static Set<String> findUserFriend(String user, List<List<String>> friends) {
        Set<String> friend = new HashSet<>();
        //friend.add(user);
        for(int i=0;i<friends.size();i++){
            String leftPerson = friends.get(i).get(0);
            String rightPerson = friends.get(i).get(1);
            if(leftPerson.equals(user))friend.add(rightPerson);
            if(rightPerson.equals(user))friend.add(leftPerson);
        }
        return friend;
    }
    private static Map<String, Integer> withUserFriend(List<List<String>> friends, Set<String> userFriend) {
        Map<String,Integer> friendRecommend = new HashMap<>();
        for(int i=0;i<friends.size();i++){
            String leftPerson = friends.get(i).get(0);
            String rightPerson = friends.get(i).get(1);
            if(isAlreadyFriend(leftPerson,userFriend))friendRecommend.put(rightPerson,friendRecommend.getOrDefault(rightPerson,0)+10);
            if(isAlreadyFriend(leftPerson,userFriend))friendRecommend.put(leftPerson,friendRecommend.getOrDefault(leftPerson,0)+10);
        }
        return friendRecommend;
    }
    private static boolean isAlreadyFriend(String person, Set<String> userFriend) {
        if(userFriend.contains(person))return true;
        else return false;
    }
}
