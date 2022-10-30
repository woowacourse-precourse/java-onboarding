package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
