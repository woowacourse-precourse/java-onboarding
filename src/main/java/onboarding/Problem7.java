package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> result = new HashMap<>();
        List<String> userFriends = new ArrayList<>();
        int idx = 0;

        //user의 친구 선별
        for(int i = 0 ; i < friends.size() ; i++){
            //user 포함 원소 탐색
            idx = friends.get(i).indexOf(user);
            if(idx > -1) {
                //user 친구 등록
                userFriends.add(friends.get(i).get(1-idx));
                //friends.remove(i); -> 인자로 받는 List의 데이터 수정 불가
                //i--;
            }
        }

        //user의 친구와 아는 사람 선별
        for(int i = 0 ; i < userFriends.size() ; i++){
            for(int j = 0 ; j < friends.size() ; j++){
                //user 친구 아는 사람 탐색
                idx = friends.get(j).indexOf(userFriends.get(i));
                if(idx > -1){
                    //user와 함께 아는 친구 점수(10점) 계산
                    if(result.containsKey(friends.get(j).get(1-idx))){
                        result.put(friends.get(j).get(1-idx), result.get(friends.get(j).get(1-idx))+10);
                    }
                    else{
                        result.put(friends.get(j).get(1-idx),10);
                    }
                }
            }
        }


        //user 타임 라인 방문 횟수 1점 계산
        for(int i = 0 ; i < visitors.size() ; i++){
            if(result.containsKey(visitors.get(i))){
                result.put(visitors.get(i), result.get(visitors.get(i))+1);
            }
            else{
                result.put(visitors.get(i),1);
            }
        }

        List<String> answer = new ArrayList<>();

        //점수 기준 내림차순 정렬
        List<String> keyList = new ArrayList<>(result.keySet());
        Collections.sort(keyList, (x, y) -> (result.get(y).compareTo(result.get(x))));

        //최대 5명까지 표현
        userFriends.add(user);
        for(String key : keyList){
            if(userFriends.contains(key)) continue; //user와 user의 친구는 추천 목록 제외
            if(answer.size()==5) break;
            answer.add(key);
        }

        return answer;
    }
}
