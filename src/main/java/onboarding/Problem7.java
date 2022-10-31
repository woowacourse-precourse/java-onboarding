package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Comparator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();

        List<String> userFriend = new ArrayList<>(); // user 친구 저장 리스트
        HashMap<String, Integer> friendScore = new HashMap<>();

        // user와 친구인 username 탐색
        for(List<String> friend : friends){
            if(friend.get(0).equals(user)){
                userFriend.add(friend.get(1));
            } else if(friend.get(1).equals(user)){
                userFriend.add(friend.get(0));
            }
        }

        // 사용자와 함께 아는 친구의 수 탐색
        for(List<String> friend : friends){
            if(userFriend.contains(friend.get(0)) && !friend.get(1).equals(user)){
                friendScore.put(friend.get(1), friendScore.getOrDefault(friend.get(1), 10) + 10);
            } else if(userFriend.contains(friend.get(1)) && !friend.get(0).equals(user)){
                friendScore.put(friend.get(0), friendScore.getOrDefault(friend.get(0), 10) + 10);
            }
        }

        // 방문한 user 점수 +1
        for(String visitor : visitors){
            friendScore.put(visitor, friendScore.getOrDefault(visitor, 0) + 1);
        }

        // Map.Entry 리스트 작성
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(friendScore.entrySet());

        // 비교함수 Comparator를 사용하여 정렬
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                // 점수로 내림차순, 이름으로 오름차순 정렬
                if(obj1.getValue()==obj2.getValue()){
                    return obj1.getKey().compareTo(obj2.getKey());
                }
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        // 0이 아닌 최대 5개 + 친구가 아닌 경우
        for(Entry<String, Integer> entry : list_entries) {
            if(entry.getValue()>0 && !userFriend.contains(entry.getKey())) answer.add(entry.getKey());
            if(answer.size()==5) break;
        }
        return answer;
    }
}
