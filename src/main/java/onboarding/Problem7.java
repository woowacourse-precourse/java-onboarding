package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> relationMap = new HashMap<>();
        HashMap<String, Integer> scores = new HashMap<>();
        for (List<String> friend: friends) {

            String a = friend.get(0);
            String b = friend.get(1);

            scores.put(a, 0);
            scores.put(b, 0);

            for (int i=0; i < 2; i++) {
                String temp;
                temp = a;
                a = b;
                b = temp;
                List<String> emptyArr = new ArrayList<>();
                List<String> tempArr = relationMap.getOrDefault(a, emptyArr);
                tempArr.add(b);
                relationMap.put(a, tempArr);
            }
        }
        List<String> userFriends = relationMap.get(user);

        for (String key: relationMap.keySet()) {
            if (user.equals(key) || userFriends.contains(key)) {
                continue;
            }
            List<String> value = relationMap.get(key);
            value.retainAll(userFriends);

            int score = scores.get(key) + (value.size()) * 10;
            scores.put(key, score);
        }

        HashSet<String> visitorsSet = new HashSet<>(visitors);

        for (String visitor: visitorsSet) {
            int score = scores.getOrDefault(visitor, 0) + Collections.frequency(visitors, visitor);
            scores.put(visitor, score);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scores.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return -(o1.getValue() - o2.getValue());
            }
        });
        int cnt = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            String k = entry.getKey();
            int v = entry.getValue();
            if (userFriends.contains(k)) {
                continue;
            }

            if (cnt >= 5 || v == 0) {
                break;
            }
            else {
                answer.add(k);
            }
            cnt++;
        }
        return answer;
    }
//    public static void main(String[] args) {
//        String user = "mrko";
//        List<List<String>> friends = List.of(
//                List.of("donut", "andole"),
//                List.of("donut", "jun"),
//                List.of("donut", "mrko"),
//                List.of("shakevan", "andole"),
//                List.of("shakevan", "jun"),
//                List.of("shakevan", "mrko")
//        );
//        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
//        List<String> result = List.of("andole", "jun", "bedi");
//
//        Problem7 prob = new Problem7();
//        List<String> answer = prob.solution(user, friends, visitors);
//        System.out.println(Arrays.toString(answer.toArray()));
//    }
}
