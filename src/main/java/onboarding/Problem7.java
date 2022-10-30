package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /*
    사용자 제외 모든 유저별로 점수 초기화 하기
     */
    private static Map<String,Integer> initScore(List<List<String>> friends, String user, List<String> visitors){
        Map<String,Integer> map=new HashMap<>();
        for(List<String> friend:friends){
            if(!map.containsKey(friend.get(0))&&!user.equals(friend.get(0))){
                map.put(friend.get(0),0);
            }
            if(!map.containsKey(friend.get(1))&&!user.equals(friend.get(1))){
                map.put(friend.get(1),0);
            }
        }
        for(String visitor:visitors){
            if(!map.containsKey(visitor)){
                map.put(visitor,0);
            }
        }
        return map;
    }

    /*
    사용자의 직접적인 친구 구하기
     */
    private static List<String> getUserFriends(List<List<String>> friends,String user){
        List<String> userFriends=new ArrayList<>();
        for(List<String> friend:friends){
            if(friend.get(0).equals(user)&&!userFriends.contains(friend.get(1))){
                userFriends.add(friend.get(1));
            }
            if(friend.get(1).equals(user)&&!userFriends.contains(friend.get(0))){
                userFriends.add(friend.get(0));
            }
        }
        return userFriends;
    }

}
