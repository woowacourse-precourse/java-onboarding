package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();


        // 함꼐 아는 친구 점수 추가
        // 내 친구 set에 저장
        for(int i=0; i<friends.size(); i++) {
            set.add(friends.get(i).get(0));
            String key = friends.get(i).get(1);
            map.put(key, map.getOrDefault(key, 0) +10);
        }

        // 타임라인 점수 추가
        // 친구가 아닌 경우만 점수 추가
        for(int i=0; i<visitors.size(); i++) {
            String key = visitors.get(i);
            if(!set.contains(key))
                map.put(key, map.getOrDefault(key, 0) +1);
        }

        // 자기 자신 제거
        map.remove(user);

        List<String> answer = new ArrayList<>();

        // 리스트에 추가
        map.forEach((key, value) -> {
            if(answer.size()<5)
                answer.add(key);
        });

        return answer;
    }


}
