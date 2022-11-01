package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 이미 user 와 친구인 사람을 저장할 리스트
        List<String> user_friend_list = new ArrayList<>();

        // 이름과 점수를 함께 저장
        Map<String, Integer> map = new TreeMap<>();

        // user 와 친구인 사람들 확인
        for(int i = 0; i < friends.size(); i++){

            List<String> temp = friends.get(i);

            String A = temp.get(0);
            String B = temp.get(1);

            if(A.equals(user)){
                user_friend_list.add(B);
            }
            else if(B.equals(user)){
                user_friend_list.add(A);
            }
        }

        return answer;
    }
}
