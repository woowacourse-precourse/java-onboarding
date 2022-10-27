package onboarding;

import java.util.*;

public class Problem7 {
//    class User implements Comparable<User> {
//        private String name;
//        private int score;
//
//        public User(String name, int score) {
//            this.name = name;
//            this.score = score;
//        }
//
//        @Override
//        public int compareTo(User o) {
//            if(score == o.score) {
//                return name.compareTo(o.name);
//            } else {
//                return o.score - score;
//            }
//        }
//    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(); // 정답을 return 할 리스트
        Map<String, ArrayList<String>> map = new HashMap<>(); // key : user / value : friends
        Map<String, Integer> scores = new HashMap<>();  // 추천 점수 계산

        for(List<String> s : friends) {
            String f1 = s.get(0);
            String f2 = s.get(1);

            if(!map.containsKey(f1)) {
                map.put(f1, new ArrayList<>());
                map.get(f1).add(f2);
            }
            else {
                map.get(f1).add(f2);
            }
            if(!map.containsKey(f2)) {
                map.put(f2, new ArrayList<>());
                map.get(f2).add(f1);
            }
            else {
                map.get(f2).add(f1);
            }
            if(f1.equals(user) || f2.equals(user)) continue;
            if(!scores.containsKey(f1)) scores.put(f1, 0);
            if(!scores.containsKey(f2)) scores.put(f2, 0);
        }

        // 아는 친구는 scores 리스트에서 삭제
        for(String friend : map.get(user)) {
            scores.remove(friend);
        }

        // 함께 아는 친구의 수
        for(String new_friend : scores.keySet()) {
            int count = 0;
            for(String friend : map.get(user)) {
                if(map.get(friend).contains(new_friend)) count++;
            }
            scores.put(new_friend, (scores.get(new_friend) + (10 * count)));
        }

        // 방문한 횟수
        for(String visitor : visitors) {
            if(map.get(user).contains(visitor)) continue;
            if(!scores.containsKey(visitor)) scores.put(visitor, 1);
            scores.put(visitor, (scores.get(visitor) + 1));
        }

        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(scores.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        int cnt = 0;
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            if(cnt == 5) break;
            if(aa.getValue() == 0) break;
            answer.add(aa.getKey());
            cnt++;
        }

        return answer;
    }
}
