package onboarding;

import java.util.*;

/**
 * 구현 기능 목록
 * 1. 이미 friends인 사람을 set에 담는다.
 * 2. friends를 탐색하면서, map의 key에 친구, value에 추천점수 +10을 한다.
 * 3. visitors를 탐색하면서, map의 key에 친구, value에 추천점수 +1을 한다.
 * 4. 친구들과 점수가 담긴 map에서 이미 친구인 목록을 제거한다.
 * 5. 결과인 result에 추천친구를 담는다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<>();

        // 이미 친구인 목록을 만든다. [shakevan, donut]
        HashSet<String> alreadyfriends = new HashSet<>();
        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).get(0)==user){
                alreadyfriends.add(friends.get(i).get(1));

            }else if(friends.get(i).get(1)==user){
                alreadyfriends.add(friends.get(i).get(0));
            }
        }
        for(List<String> list :friends){
            String s1 = list.get(0);
            String s2 = list.get(1);
            if(alreadyfriends.contains(s1) && !s2.contains(user)){
                map.put(s2, map.getOrDefault(s2, 0)+10);
            }else if(!s1.contains(user) && alreadyfriends.contains(s1)){
                map.put(s1, map.getOrDefault(s1, 0)+10);
            }
        }
        // {andole=20, jun=20, shakevan=11, bedi=3, donut=11}
        for(int i=0; i<visitors.size(); i++){
            map.put(visitors.get(i), map.getOrDefault(visitors.get(i), 0)+1);
        }

        for(int i=0; i< map.size(); i++){
            for(String key : alreadyfriends){
                if(map.containsKey(key)){
                    map.remove(key);
                }
            }
        }
        for(int i=0; i<map.size(); i++){
            result.add(String.valueOf(map.get(i)));
        }
        return result;
    }
}
