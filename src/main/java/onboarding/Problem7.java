package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //Hash Map   Priority Queue ArrayList
        //friends를 한바퀴돌면서 user와 친구인 set 만들고 다시돌면서
        //set과 친구인 사람들 map에 넣으면서 점수부여

        HashSet<String> set = new HashSet<>();
        for (List<String> pair : friends) {
            if (pair.get(0).equals("mrko")) {
                set.add(pair.get(1));
            } else if (pair.get(1).equals("mrko")) {
                set.add(pair.get(0));
            }
        }

        HashMap<String, Integer> scores = new HashMap<>();
        for (List<String> pair : friends) {
            if (!pair.get(0).equals("mrko") && set.contains(pair.get(1))) {
                scores.put(pair.get(0), scores.getOrDefault(pair.get(0), 0) + 10);
            } else if (!pair.get(1).equals("mrko") && set.contains(pair.get(0))) {
                scores.put(pair.get(1), scores.getOrDefault(pair.get(1), 0) + 10);
            }
        }

        for (String visitor : visitors) {
            if (set.contains(visitor)) { //이미 친구였던사람은 맵에 들어가면안됨
                continue;
            }
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }

        //이제 scores를 value값 기준으로 내림차순정렬해야한다

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scores.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue() ?
                        o1.getKey().compareTo(o2.getKey())  :  o2.getValue() - o1.getValue();
            }
        });


        List<String> answer = new ArrayList<>();

        int min = Math.min(5, entryList.size()); //점수가 0점보다 큰 사람수가 5명 미만일경우에 대비
        for (int i = 0; i < min; i++) {
            answer.add(entryList.get(i).getKey());
        }

        return answer;
    }
}