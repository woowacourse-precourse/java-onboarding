package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> _friends = friends.stream().collect(Collectors.toList());
        // 추천친구와 점수를 담는 목록
        Map<String, Integer> recommend = new HashMap<String, Integer>();
        // user의 친구 목록
        List<String> user_friends = new ArrayList<>();
        // user와 친구 관계인 사용자들을 탐색해 user 친구 목록에 저장, 해당되는 관계는 다음 step에서 중복 우려 있어 삭제
        for (int idx = 0; idx < _friends.size(); idx++){
            if (_friends.get(idx).get(0) == user){
                user_friends.add(_friends.get(idx).get(1));
                // 삭제 후 friends 배열의 길이가 줄어들고 for문 조건을 고려해 idx 또한 -1 해야 함
                _friends.remove(idx);
                idx--;
                continue;
            }
            if (_friends.get(idx).get(1) == user){
                user_friends.add(_friends.get(idx).get(0));
                // 삭제 후 friends 배열의 길이가 줄어들고 for문 조건을 고려해 idx 또한 -1 해야 함
                _friends.remove(idx);
                idx--;
            }
        }

        // user 친구들의 친구 관계인 사용자들을 탐색해 해당 친구에 10점 부여
        for (int i = 0; i < user_friends.size(); i++){
            String friend = user_friends.get(i);
            for (int j = 0; j < _friends.size(); j++){
                if (_friends.get(j).get(0) == friend){
                    if (recommend.containsKey(_friends.get(j).get(1)))
                        recommend.put(_friends.get(j).get(1), recommend.get(_friends.get(j).get(1)) + 10);
                    else
                        recommend.put(_friends.get(j).get(1), 10);
                }
            }
        }

        // visitor의 사용자들을 탐색해 1점씩 부여, 단 user와 이미 친구 관계인 경우 점수 부여를 하지 않음
        for (int k = 0; k < visitors.size(); k++){
            if (user_friends.contains(visitors.get(k)))
                continue;

            if (recommend.containsKey(visitors.get(k)))
                recommend.put(visitors.get(k), recommend.get(visitors.get(k)) + 1);
            else
                recommend.put(visitors.get(k), 1);
        }

        // 다 채워진 recommend에 대해 추천 점수를 기준으로 내림차순 정렬하되 같은 점수일 경우 이름 순으로 정렬
        List<Map.Entry<String, Integer>> answer = new LinkedList<>(recommend.entrySet());
        Collections.sort(answer, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                int compare1 = o2.getValue() - o1.getValue();
                return compare1 == 0 ? o1.getKey().compareTo(o2.getKey()) : compare1;
            }
        });
        
        // 마지막으로 추천 친구 목록이 5명을 초과할 경우 삭제
        List<String> result = answer.stream().map(Entry::getKey).collect(Collectors.toList());
        if (result.size() > 5)
            result.subList(5, result.size()).clear();
        return result;
    }
}
