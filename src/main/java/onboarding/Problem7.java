package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> peopleSet = new HashSet<>();
        HashMap<String, Integer> peopleMap1 = new HashMap<>();
        HashMap<Integer, String> peopleMap2 = new HashMap<>();

        for (int i = 0; i < friends.size(); i++){ // 총 사람들의 집합 생성
            peopleSet.add(friends.get(i).get(0));
            peopleSet.add(friends.get(i).get(1));
        }
        Iterator<String> iter1 = peopleSet.iterator();
        int index1 = 0;
        while (iter1.hasNext()) {
            peopleMap1.put(iter1.next(), Integer.valueOf(index1));
            index1++;
        }
        Iterator<String> iter2 = peopleSet.iterator();
        int index2 = 0;
        while (iter2.hasNext()) {
            peopleMap2.put(Integer.valueOf(index2), iter2.next());
            index2++;
        }
        int[][] graph = new int[peopleSet.size()][peopleSet.size()];
        for (int i = 0; i < friends.size(); i++){
            int person1 = peopleMap1.get(friends.get(i).get(0));
            int person2 = peopleMap1.get(friends.get(i).get(1));
            graph[person1][person2] = 1;
            graph[person2][person1] = 1;
        }
        HashMap<String, Integer> peopleScore = new HashMap<>();
        // 방문한 횟수 scr += 1
        for (int i = 0; i < visitors.size(); i++) {
            peopleScore.putIfAbsent(visitors.get(i), 0);
            peopleScore.computeIfPresent(visitors.get(i), (k, v) -> v +1);
        }

        // 사용자와 함께 아는 친구 += 10
        int userNum = peopleMap1.get(user);
        for (int i = 0; i < peopleMap1.size(); i++) {
            if (graph[userNum][i] == 1) {
                if (peopleScore.containsKey(peopleMap2.get(i))) { // 이미 친구인 사람이 점수가 매겨져 있으면
                    peopleScore.remove(peopleMap2.get(i)); // 이미 친구인 사람 삭제
                }
                for (int j = 0; j < peopleMap1.size(); j++) {
                    if (graph[i][j] == 1 && graph[userNum][j] == 0 && j != userNum) { // 친구의 친구지만 내 친구는 아닌 경우
                        peopleScore.putIfAbsent(peopleMap2.get(j), 0);
                        peopleScore.computeIfPresent(peopleMap2.get(j), (k, v) -> v +10);
                    }
                }
                
            }
        }

        Set<Entry<String, Integer>> entrySet = peopleScore.entrySet();
        List<Entry<String, Integer>> answer = new ArrayList<>(entrySet);
        Collections.<Entry<String, Integer>>sort(answer, (o1, o2) -> {
            if (o1.getValue() - o2.getValue() != 0) {
                return o2.getValue().compareTo(o1.getValue());
            }
            return o1.getKey().compareTo(o2.getKey());
        });

        // 다섯명으로 자르기
        if (answer.size() > 5) {
            return answer.subList(0, 5).stream().map(it -> it.getKey()).toList();
        }
        return answer.stream().map(it -> it.getKey()).toList();
    }
}
