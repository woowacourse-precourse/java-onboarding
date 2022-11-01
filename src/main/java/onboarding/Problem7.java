package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> map = new HashMap<>();

        // 함꼐 아는 친구 점수 추가
        for(int i=0; i<friends.size(); i++) {
            String key = friends.get(i).get(1);
            map.put(key, map.getOrDefault(key, 0) +10);
        }



//        map.forEach((key, value) -> {
//            System.out.println(key + " : " +value);
//        });

        List<String> answer = new ArrayList<>();
        return answer;
    }


}
