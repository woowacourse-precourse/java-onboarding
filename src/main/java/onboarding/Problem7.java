package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

         // [oldFrn] user 와 이미친구 인 리스트 - friends에서 user 이름 들어간 것
        List<String> oldFrn = new ArrayList<>();

        for(int i = 0; i<friends.size(); i++){
            int oldFriend = 0;
            if(friends.get(i).get(0) == user || friends.get(i).get(1) == user) {
                oldFriend = 1 - friends.get(i).indexOf(user);
                oldFrn.add(friends.get(i).get(oldFriend));
            }
        }

        Map<String, Integer> recommendMap = new HashMap<>(); // Name, Score

        // [visitors] user 가 visit 한 친구 -> 방문 당 1점
        for(int i=0; i<visitors.size(); i++) {
            String visit = visitors.get(i);
            if(recommendMap.containsKey(visit)){
                recommendMap.put(visit, recommendMap.get(visit) +1);
            }else  recommendMap.put(visit, 1);
            // 이미 친구인 친구 빼는거
            for(String oldFriend : oldFrn){
                if(recommendMap.containsKey(oldFriend)) recommendMap.remove(oldFriend);
            }
        }


        // [friends] 중 이미 친구 [oldFrn] 와 친구인 애들 [frnFrn] 추천결과 recommendMap 에 (이름, 10) put
        //  -> 중복 검사해서 같은 이름은 점수만 ++
        for(int i=0; i<friends.size(); i++) {
            int frnFrn =0;
            for(String oldFriend : oldFrn){
                if(friends.get(i).get(0) == oldFriend || friends.get(i).get(1) == oldFriend) {
                     frnFrn = 1 -friends.get(i).indexOf(oldFriend);
                     String newFrd = friends.get(i).get(frnFrn);
                     if(recommendMap.containsKey(newFrd)){
                         recommendMap.put(newFrd, recommendMap.get(newFrd) +10);
                     } else recommendMap.put(newFrd, 10);

                }
            }
        }

        // user 제거해주기
        recommendMap.remove(user);

        // 추천에서 정렬
        List<String> answer = new ArrayList<>(recommendMap.keySet());
        Collections.sort(answer, (value1, value2) -> (recommendMap.get(value2).compareTo(recommendMap.get(value1))));


        return answer;
    }
}
