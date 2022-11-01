package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // 1. 사용자가 아는 친구 구하기
        ArrayList<String> userFriends = new ArrayList<>();
        int N = friends.size();
        for(int i = 0; i < N; i++){
            List<String> list = friends.get(i);
            if (list.get(0).equals(user)){
                userFriends.add(list.get(1));
            }
            else if(list.get(1).equals(user)){
                userFriends.add(list.get(0));
            }
        }
        return answer;
    }
}
