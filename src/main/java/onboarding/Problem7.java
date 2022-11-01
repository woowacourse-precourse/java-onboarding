package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, Set<String>> getFriendRelation(List<List<String>> friends) {
        Map<String, Set<String>> relation = new HashMap<>();
        for (List<String> elem : friends) {
            String id1 = elem.get(0);
            String id2 = elem.get(1);
            if (!relation.containsKey(id1)) {
                relation.put(id1, new HashSet<>());
            }
            if (!relation.containsKey(id2)) {
                relation.put(id2, new HashSet<>());
            }
            relation.get(id1).add(id2);
            relation.get(id2).add(id1);
        }
        return relation;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> result = new TreeMap<>(); //점수 계산용

        //1. 사용자와 함께 아는 친구
        Map<String, Set<String>> relation = getFriendRelation(friends);
        //user와 교집합
        for (String key : relation.keySet()) {
            Set<String> userfriends = relation.get(user);
            Set<String> target = relation.get(key);
            userfriends.retainAll(target);
            result.put(key, userfriends.size() * 10);
        }
        //2. 사용자의 타임 라인에 방문한 횟수
        for(String visitor : visitors){
            if(!result.containsKey(visitor)){
                result.put(visitor,0);
            }
            result.put(visitor,result.get(visitor)+1);
        }


    }

}
