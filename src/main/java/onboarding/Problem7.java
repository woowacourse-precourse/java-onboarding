package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>();
        Map<String, Integer> score = new HashMap<String, Integer>();
        Map<String, Integer> ch = new HashMap<String, Integer>();

        //해쉬맵에 친구 목록 만들기
        for(int i = 0; i < friends.size(); i++) {
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);

            if(map.containsKey(friend1))
                map.put(friend1, map.get(friend1) + friends.get(i).get(1) + " ");
            else
                map.put(friend1, friends.get(i).get(1) + " ");

            if(map.containsKey(friend2))
                map.put(friend2, map.get(friend2) + friends.get(i).get(0) + " ");
            else
                map.put(friend2, friends.get(i).get(0) + " ");

        }

        //user의 친구를 레퍼런스로 활용하기 위해 저장
        String[] strs = map.get(user).split(" ");
        for(int i = 0; i<strs.length; i++)
            ch.put(strs[i], 1);

        //같이 아는 친구 점수 계산
        for(Map.Entry<String, String> entry : map.entrySet()) {
            String[] friendSet = map.get(entry.getKey()).split(" ");
            int score_num = 0;
            if(entry.getKey().equals(user) || ch.containsKey(entry.getKey()))
                continue;

            for(int i = 0; i<friendSet.length; i++) {
                if(ch.containsKey(friendSet[i]))
                    score_num += 10;
            }
            score.put(entry.getKey(), score_num);
        }

        //방문자에 해당하는 값 계산
        for(int i = 0; i<visitors.size(); i++){
            if(ch.containsKey(visitors.get(i)))
                continue;

            if(score.containsKey(visitors.get(i)))
                score.put(visitors.get(i), score.get(visitors.get(i)) + 1);
            else
                score.put(visitors.get(i), 1);
        }

        //내림차순 정렬, 점수가 같을 경우는 오름차순
        List<Map.Entry<String, Integer>> list = new ArrayList<>(score.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else
                    return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(Map.Entry<String, Integer> entry : list)
            answer.add(entry.getKey());


        return answer;
    }
}
