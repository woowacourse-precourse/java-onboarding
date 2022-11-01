package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, Set<String>> makeFriendRelation(List<List<String>> friends) {
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
        Map<String, Integer> score = new TreeMap<>(); //점수 계산용

        //1. 사용자와 함께 아는 친구
        Map<String, Set<String>> relation = makeFriendRelation(friends);
        //user와 교집합
        for (String key : relation.keySet()) {
            Set<String> userfriends = relation.get(user);
            Set<String> target = relation.get(key);
            userfriends.retainAll(target);
            score.put(key, userfriends.size() * 10);
        }
        //2. 사용자의 타임 라인에 방문한 횟수
        for(String visitor : visitors){
            if(!score.containsKey(visitor)){
                score.put(visitor,0);
            }
            score.put(visitor,score.get(visitor)+1);
        }

        //3. 점수가 가장 높은 순으로 정렬하여 최대 5명 return, 0점은 추천x
        List<String> keySet = new ArrayList<>(score.keySet());
        //예외처리
        // - user와 이미 친구인 경우 제외
        // - user 제외
        keySet.remove(user);
        for(String key:relation.keySet()){
            if(relation.get(key).contains(user)){
                keySet.remove(key);
            }
        }
        // Value 값으로 내림차순 정렬
        keySet.sort((k1, k2) -> score.get(k2).compareTo(score.get(k1)));

        //최대 5명만 추출, 0점인 경우 제외
        int answerLength = Math.min(keySet.size(), 5);
        for(int i = 0; answer.size() < answerLength; i++){
            String key = keySet.get(i);
            if( score.get(key)!=0){
                answer.add(key);
            }
        }
        return answer;


    }

}
