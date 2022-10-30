package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. 관계를 설정한다
 * 2. 친구의 친구는 10점씩
 * 3. 방문자는 1점씩 준다
 * 4. 점수순으로 정렬한다 점수가 같으면 이름을 사전순으로 정렬한다.!
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();


        Map<String,List<String>> adj = new HashMap<>();// 친구 관계
        adj.put(user,new ArrayList<>()); // user의 친구관계는 미리 초기화
        /**관계 설정*/
        for(var friend : friends){
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            add(adj,friendA,friendB);
            add(adj,friendB,friendA);
        }
        /**이름 , 스코어*/
        Map<String,Integer> recommendScore = new HashMap<>();

        List<String> userFriends = adj.get(user); // 유저의 친구들
        List<List<String>> all = userFriends // 유저의 친구의 친구들
                .stream()
                .filter(friendUsr->adj.containsKey(friendUsr))
                .map(friendUsr->adj.get(friendUsr))
                .collect(Collectors.toList());

        /**유저의 친구의 친구들에게 10점씩*/
        for(var UsrList: all){
            for(var usr :UsrList){
                calculationScore(recommendScore,usr,10);
            }
        }
        /** 방문자들에게 10점씩*/
        for(var visitor:visitors){
            calculationScore(recommendScore,visitor,1);
        }
        /**정렬 하기위해  (name , score) 쌍으로 정리 */
        List<Pair> resultList =  new ArrayList<>();
        for (var recommendUsr:recommendScore.keySet()){
            if(userFriends.contains(recommendUsr))continue; // 친구인 사람은 아니고
            if(user.equals(recommendUsr)) continue; // 유저도 아니고
            resultList.add(new Pair(recommendUsr,recommendScore.get(recommendUsr)));
        }

        /**정렬*/
        resultList.sort(new PairCmp());
        /** 이름만 List 로 뽑는다 .*/
        answer = resultList.stream().map(ele->ele.name).collect(Collectors.toList());
        return answer;

    }

    static class Pair{
        String name;
        Integer score;
        public Pair(String name,Integer value) {
            this.name = name;
            score = value;
        }
    }
    static class PairCmp implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.score > o2.score) return -1;
            else if(o1.score < o2.score) return 1;
            else {
                return o1.name.compareTo(o2.name);
            }
        }
    }

    // 스코어 계산
    public static void calculationScore(Map<String,Integer> recommendScore ,String currentUser , Integer value){
        if(recommendScore.containsKey(currentUser))recommendScore.replace(currentUser,recommendScore.get(currentUser) + value);
        else recommendScore.put(currentUser,value);

    }
    // friendA 의 친구 friendB 추가
    public static void add(Map<String,List<String>> adj,String friendA , String friendB){
        if(adj.containsKey(friendA))adj.get(friendA).add(friendB);
        else adj.put(friendA,new ArrayList<>(List.of(friendB)));
    }
}
