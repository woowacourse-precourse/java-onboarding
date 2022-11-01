package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    // 친구 관계 만들어주는 함수
    public static HashMap<String, ArrayList<String>> friendRelation(List<List<String>> friends){
        HashMap<String, ArrayList<String>> relation = new HashMap<>();
        for(int i = 0 ; i < friends.size(); i++){
            ArrayList<String> list = new ArrayList<>();
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);
            // 친구1의 친구들 갱신
            if (relation.containsKey(friend1)){
                list = relation.get(friend1);
                list.add(friend2);
            }else{
                list.add(friend2);
            }
            relation.put(friend1, list);
            // 친구2의 친구들 갱신
            list = new ArrayList<>();
            if(relation.containsKey(friend2)){
                list = relation.get(friend2);
                list.add(friend1);
            }else{
                list.add(friend1);
            }
            relation.put(friend2, list);
        }
        return relation;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        friendRelation(friends);
        return answer;
    }
}
