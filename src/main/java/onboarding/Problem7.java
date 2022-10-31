package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> fri = new ArrayList<>();
        Map<String,Integer> score = new HashMap<>(); // 이름 별 점수 HashMap
        for (int i=0; i<friends.size(); i++)
        {
            String A = friends.get(i).get(0);
            String B = friends.get(i).get(1);
            if (A == user) fri.add(B); // A가 user일 경우, 친구 List에 B 추가
            else if (B == user) fri.add(A); // B가 user일 경우, 친구 List에 A 추가
            else // user가 없을 경우, 친구의 친구 점수 더하기
            {
                // 해당 값이 없을 경우 default 0에 + 10
                score.put(A, score.getOrDefault(A, 0)+10);
                score.put(B, score.getOrDefault(B, 0)+10);
            }
        }
        for (int j=0; j<visitors.size(); j++) // 방문 점수 더하기
        {
            String visitor = visitors.get(j);
            // 해당 값이 없을 경우 default 0에 + 1
            score.put(visitor, score.getOrDefault(visitor, 0)+1);
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        // HashMap value 값에 따른 정렬 내림차순
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        // TreeMap에 의해 key 값에 따른 정렬 오름차순
        Map<String,Integer> tmp = new TreeMap<>(); // 동점 담을 TreeMap
        int beforeValue = 0; // 전에 비교한 점수
        for (Map.Entry<String, Integer> entrySet : entryList) {
            if (!fri.contains(entrySet.getKey())) { // user의 친구가 아닌 경우

                if (tmp.size() == 0) {
                    tmp.put(entrySet.getKey(), entrySet.getValue());
                } else if (entrySet.getValue() == beforeValue) { // 전에 비교한 점수와 같을 경우
                    tmp.put(entrySet.getKey(), entrySet.getValue()); // tmp에 추가
                } else { // 같지 않을 경우
                    for(Map.Entry<String,Integer> tmpEntry : tmp.entrySet()) // tmp 값 answer에 추가
                    {
                        answer.add(tmpEntry.getKey());
                    }
                    tmp.clear();
                    tmp.put(entrySet.getKey(), entrySet.getValue()); // tmp에 현재 값 추가
                }
            }
            beforeValue = entrySet.getValue();
        }
        if (tmp.size() > 0) // tmp 안에 값이 있을 경우, answer에 추가
        {
            for(Map.Entry<String,Integer> tmpEntry : tmp.entrySet())
            {
                answer.add(tmpEntry.getKey());
            }
        }
        if(answer.size()>5) return answer.subList(0,6); // answer안에 값이 5개보다 많을 경우, 5개까지 슬라이싱
        else return answer;
    }
}
