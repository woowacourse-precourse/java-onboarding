package onboarding;

import java.util.Collections;
import java.util.*;

/*
기능 목록
1. User의 친구를 찾는다.
2. 친구 목록에 존재하는 친구들의 추천 점수를 계산한다.
3. 방문한 횟수 * 1 만큼 방문점수 계산한다.
4. 높은 점수 순서대로 나열한다.
**최종 구현
**제한 사항
**최대 5명 return 하도록
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        Set<String> friendSet = new HashSet<>();
        Map<String, Integer> score = new HashMap<>();
        //1번 기능 구현
        friendSet.add(user);
        for( List<String> friend : friends){
            if(friend.contains(user)){
                friendSet.add(friend.get(0));
                friendSet.add(friend.get(1));
            }
        }
        friendSet.remove(user);
        for(String friendName: friendSet){
            for(List<String> friend : friends){
                String f1= friend.get(0);
                String f2 = friend.get(1);
                String bridge = "";

                if(f1.equals(friendName)){
                    bridge = f2;
                }else if(f2.equals(friendName)){
                    bridge = f1;
                }
                //최종 구현 추가 사항: 이미 친구일 경우.
                if(bridge.equals(user)||bridge.equals("") || friendSet.contains(bridge)){
                    continue;
                }

                if(score.containsKey(bridge)){
                    score.replace(bridge,score.get(bridge) + 10);
                }else{
                    score.put(bridge,10);
                }
            }
        }
        for(String visitor: visitors){
            if(!friendSet.contains(visitor)){
                if(score.containsKey(visitor)){
                    score.replace(visitor,score.get(visitor)+1);
                }else{
                    score.put(visitor,1);
                }
            }
        }
        answer = new ArrayList<>(score.keySet());
        Collections.sort(answer); //최종 구현 추가 사항: 알파벳 순으로 나열
        Collections.sort(answer,(a, b) -> (score.get(b).compareTo(score.get(a))));
        //제한 사항 구현
        if(answer.size()>5)
            answer = answer.subList(0,5);
        return answer;
    }
}
