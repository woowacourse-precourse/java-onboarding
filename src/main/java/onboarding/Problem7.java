package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 친구 관계 Map에 넣기
        Map<String, List<String>> friendsGraph = new HashMap<>();

        // 친구 관계를 하나씩 꺼내기
        for (List<String> friendsList : friends) {
            String friend1 = friendsList.get(0);
            String friend2 = friendsList.get(1);

            // 그래프 안에 없다면 새로운 리스트 생성
            if(!friendsGraph.containsKey(friend1)){
                List<String> friendList = new ArrayList<>();
                friendsGraph.put(friend1, friendList);
            }
            if(!friendsGraph.containsKey(friend2)){
                List<String> friendList = new ArrayList<>();
                friendsGraph.put(friend2, friendList);
            }

            // 친구 1의 친구 리스트에 친구 2 추가
            List<String> friendList1 = friendsGraph.get(friend1);
            friendList1.add(friend2);

            // 친구 2의 친구 리스트에 친구 1 추가
            List<String> friendList2 = friendsGraph.get(friend2);
            friendList2.add(friend1);
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
