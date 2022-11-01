package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        static HashMap<String,ArrayList<String>> friendRelationMap = new HashMap<>();
        static HashMap<String,Integer> score  =new HashMap<>();


        // 자신과 직접 연관이 있는 친구들 돌아가면서 찾기
        for(List<String> friend : friends)
        {

            // 만약 친구 관계 map에 아직 등록하지 않았다면?
            if(!friendRelationMap.containsKey(friend.get(0)))
            {
                ArrayList<String> list = new ArrayList<>();
                list.add(friend.get(1));
                friendRelationMap.put(friend.get(0),list);
                score.put(friend.get(0),0);
            }
            else{
                ArrayList<String> temp = friendRelationMap.get(friend.get(0));
                temp.add(friend.get(1));
                friendRelationMap.replace(friend.get(0),temp);
            }

            // 깊이 우선 탐색을 위해서 양방향 관계로 설정
            if(!friendRelationMap.containsKey(friend.get(1)))
            {
                ArrayList<String> list = new ArrayList<>();
                list.add(friend.get(0));
                friendRelationMap.put(friend.get(1),list);
                score.put(friend.get(1),0);
            }
            else{
                ArrayList<String> temp = friendRelationMap.get(friend.get(1));
                temp.add(friend.get(0));
                friendRelationMap.replace(friend.get(1),temp);
            }
        }

        List<String> answer = new ArrayList<>();
        return answer;
    }
}
