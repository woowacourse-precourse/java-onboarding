package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(
            String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        // user의 친구
        List<String> user_friend = new ArrayList<>();
        // user의 함께 아는 친구
        List<String> too_friend = new ArrayList<>();
        // 추천 알고리즘 점수
        Map<String, Integer> score = new HashMap<>();
        // user의 친구 추가
        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).get(1) == user){
                user_friend.add(friends.get(i).get(0));
            }
        }
        // user의 함께 아는 친구 추가
        for(int i=0; i<friends.size(); i++){
            for(int j=0; j<user_friend.size(); j++){
                if(friends.get(i).get(0) == user_friend.get(j)
                        && user != friends.get(i).get(1)){
                    too_friend.add(friends.get(i).get(1));
                }
            }
        }
        // 추천 알고리즘 점수 계산
        // 함께 아는 친구 점수 계산
        for(String too : too_friend){
            if(score.containsKey(too)){
                score.put(too,score.get(too) + 10);
            }else{
                score.put(too,10);
            }
        }
        // 방문한적 있는 함께 아는 친구 점수 계산
        for(String v : visitors){
            if(score.containsKey(v) && user_friend.contains(v) == false){
                score.put(v,score.get(v) + 1);
            }else if(user_friend.contains(v) == false){
                score.put(v,1);
            }
        }
        // 점수 크기 순으로 정렬(내림차순)
        List<Map.Entry<String, Integer>> list = new ArrayList<>(score.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                return t2.getValue() - t1.getValue();
            }
        });

        // 5개까지 answer 추가
        for(Map.Entry<String, Integer> t: list){
            if(answer.size() < 5){
                answer.add(t.getKey());
            }else{
                break;
            }
        }
        return answer;
    }
}
