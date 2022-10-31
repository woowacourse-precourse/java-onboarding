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
            }else if(alreadyfriends.contains(s2) && !s1.contains(user)){
                map.put(s1, map.getOrDefault(s1, 0)+10);
            }
        }

        for(int i=0; i<visitors.size(); i++){
            if(!alreadyfriends.contains(visitors.get(i))){
                map.put(visitors.get(i), map.getOrDefault(visitors.get(i), 0)+1);
            }
        }

        result = new ArrayList<>(map.keySet());
        Collections.sort(result,(a,b) -> (map.get(b).compareTo(map.get(a))));
        return result;
    }
}
