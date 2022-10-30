package onboarding;

import java.util.*;

/**
 * 1.친구목록을 통해 사용자와 함께아는친구 찾기
 * 2.함께 아는 친구의 아이디와 점수를 TreeMap에 저장하는 함수
 * 3.타임라인의 방문자들을 TreeMap에 저장하는 함수
 */
public class Problem7 {

    static Map<String, Integer> map = new TreeMap<>();
    
    /**
     * 1.친구목록을 통해 사용자와 함께아는친구 찾기
     */
    public static List<String> friendList(String user, List<List<String>> n) {
        List<String> friendList = new ArrayList<>();
        for(int i = 0; i<n.size();i++){
            if(n.get(i).get(1).equals(user)){
                friendList.add(n.get(i).get(0));
            }

            if(n.get(i).get(0).equals(user)){
                friendList.add(n.get(i).get(1));
            }
        }

        return friendList;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}