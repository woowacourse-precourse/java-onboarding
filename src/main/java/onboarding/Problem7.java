package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < friends.size(); i++) {
            set.add(friends.get(i).get(0));
        }
        for (int i = 0; i < friends.size(); i++) {
            if (!friends.get(i).get(1).equals(user) && !set.contains(friends.get(i).get(1))) {
                if (map.containsKey(friends.get(i).get(1))) {
                    int num = map.get(friends.get(i).get(1)) + 10;
                    map.put(friends.get(i).get(1), num);
                } else {
                    map.put(friends.get(i).get(1), 10);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (!set.contains(visitors.get(i))) {
                if (map.containsKey(visitors.get(i))) {
                    int num = map.get(visitors.get(i)) + 1;
                    map.put(visitors.get(i), num);
                } else {
                    map.put(visitors.get(i), 1);
                }
            }
        }

        // map 완성 (이름 + 점수)

        // map의 정보를 리스트에 복사.
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        // top5 점수순대로 오름차순 정렬
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 오름차순 정렬 된 리스트에서 5명 출력

        List<String> list_score = new ArrayList<>();


        int score = list.get(0).getValue();
        for (int i = 0; i < 5; i++) {
            if (list.size() - 1 < i || list.get(i).getValue() == 0) {
                break;
            } else if (list.get(i).getValue() != score) {
                Collections.sort(list_score);
                for (int j = 0; j < list_score.size(); j++) {
                    answer.add(list_score.get(j));
                }
                list_score.clear();

                answer.add(list.get(i).getKey());
                score = list.get(i).getValue();
            } else {
                list_score.add(list.get(i).getKey());
            }
        }
        if (!list_score.isEmpty()) {
            for (int i = 0; i < list_score.size(); i++) {
                answer.add(list_score.get(i));
            }
        }

        return answer;
    }
}
