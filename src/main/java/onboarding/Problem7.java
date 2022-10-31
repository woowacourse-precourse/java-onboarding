package onboarding;

import java.util.*;

/**
 * 구현 기능 목록
 * 1. 이미 friends인 사람을 set에 담는다.
 * 2. friends를 탐색하면서, map의 key에 친구, value에 추천점수 +10을 한다.
 * 3. visitors를 탐색하면서, map의 key에 친구, value에 추천점수 +1을 한다.
 * 4. 결과를 요구사항에 맞게 정렬하고 result에 추가한 뒤 return한다.
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
        List<Map.Entry<String, Integer>> list = SortList(map);
        for(Map.Entry<String, Integer> entry : list){
            result.add(entry.getKey());
        }
        return result;
    }
    private static List<Map.Entry<String, Integer>> SortList (Map<String, Integer> m){
        List<Map.Entry<String, Integer>> list = new LinkedList<>(m.entrySet());
        list.sort((o1, o2) ->{
            int comparison = (o1.getValue() - o2.getValue()) * -1;
            return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
        });

        if(list.size()>5){
            list.subList(0, 5);
        }
        return list;
    }
}
