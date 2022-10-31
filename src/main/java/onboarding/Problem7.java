package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = recommend(user, friends,visitors);
        return answer;

    }

    private static List<String> recommend(String user, List<List<String>> friends, List<String> visitors) {
        List<String> list;
        Map<String, Integer> map = new HashMap<>();
        list = friendOfUser(user, friends);
        map = friendScore(user, friends, list);
        map = visitorScore(map, visitors, list, user);
        List<Map.Entry<String, Integer>> entryList = new ArrayList(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        List<String> ans;
        ans = result(entryList);
        return ans;
    }
    private static List<String> result(List<Map.Entry<String, Integer>> entryList) {
        List<String> ans = new ArrayList<>();

        for(int i=0; i<entryList.size(); i++){
            if(i >=5 ) break;
            ans.add(entryList.get(i).getKey());
        }
        return ans;
    }
    private static Map<String, Integer> visitorScore(Map<String, Integer> map, List<String> visitors,List<String> list, String user) {
        for (int i = 0; i < visitors.size(); i++) {
            if(list.contains(visitors.get(i)) || visitors.get(i).equals(user)) continue;
            if(map.containsKey(visitors.get(i)) ){
                int score = map.get(visitors.get(i));
                score++;
                map.put(visitors.get(i), score);
            }else{
                map.put(visitors.get(i), 1);
            }
        }
        return map;
    }
    private static Map<String, Integer> friendScore(String user ,List<List<String>> friends, List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            String A = friends.get(i).get(0);
            String B = friends.get(i).get(1);
            if(A.equals(user) || B.equals(user)) continue;
            int aScore = 0;
            int bScore = 0;
            if (list.contains(A)) {
                if(map.containsKey(B)){
                    bScore = map.get(B);
                }
                bScore += 10;
                map.put(B, bScore);
            }
            if (list.contains(B)) {
                if(map.containsKey(A)){
                    aScore = map.get(A);
                }
                aScore += 10;
                map.put(A, aScore);
            }
        }
        return map;
    }

    private static List<String> friendOfUser(String user, List<List<String>> friends) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < friends.size(); i++) {
            String A = friends.get(i).get(0);
            String B = friends.get(i).get(1);
            String friend = A.equals(user) ? B : B.equals(user) ? A : "";
            if (!friend.equals("")) {
                list.add(friend);
            }
        }
        return list;
    }

}
