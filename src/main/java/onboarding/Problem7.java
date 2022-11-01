package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // 1. 사용자가 아는 친구 구하기
        HashMap<String, Integer> userFriends = new HashMap<>();
        int N = friends.size();
        for(int i = 0; i < N; i++){
            List<String> list = friends.get(i);
            if (list.get(0).equals(user)){
                userFriends.put(list.get(1), 0);
            }
            else if(list.get(1).equals(user)){
                userFriends.put(list.get(0), 0);
            }
        }
        // 2. 사용자와 함께 아는 친구의 수에 따라 점수 부여하기 +10
        HashMap<String, Integer> score = new HashMap<>();
        // friends 돌면서 freind에 사용자가 아는 친구가 있다면 점수 부여 user가 아닐 경우에만
        for (int i = 0; i < N; i++){
            List<String> list = friends.get(i);
            // 사용자와 아는 친구일 때
            if (userFriends.containsKey(list.get(0))){
                String key = list.get(1);
                int value = 10;
                // user(사용자)&원래 사용자와 친구인 경우는 무시
                if(!(key.equals(user) || userFriends.containsKey(key))){
                    if (score.containsKey(key)){
                        value = score.get(key) + 10;
                    }
                    score.put(key, value);
                }
            }
            else if (userFriends.containsKey(list.get(1))){
                String key = list.get(0);
                int value = 10;
                // user(사용자)&원래 사용자와 친구인 경우는 무시
                if(!(key.equals(user) || userFriends.containsKey(key))){
                    if (score.containsKey(key)){
                        value += score.get(key);
                    }
                    score.put(key, value);
                }
            }
        }
        // 3. 사용자의 타임 라인에 방문한 횟수에 따라 점수 부여하기 +1
        int M = visitors.size();
        for (int i = 0; i < M; i++){
            String key = visitors.get(i);
            int value = 1;
            // 사용자와 친구가 아닐 때
            if (!userFriends.containsKey(key)){
                if (score.containsKey(key)){
                    value += score.get(key);
                }
                score.put(key, value);
            }
        }

        return answer;
    }
}
