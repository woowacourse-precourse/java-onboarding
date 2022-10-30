package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer =
        recommend(user, friends,visitors);
        return answer;

    }
    //mrko - donut, shakevan
    //donut - andole, jun
    // shakevan - jun, andole

    //==
    private static List<String> recommend(String user, List<List<String>> friends, List<String> visitors) {
        List<String> list;
        Map<String, Integer> map = new HashMap<>();

        list = friendOfUser(user, friends);
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
        System.out.println("list = " + list);
        System.out.println("map = " + map);
        for (int i = 0; i < visitors.size(); i++) {
            System.out.println(visitors.get(i) + " visitor");
            System.out.println(list.contains(visitors.get(i)));
            if(list.contains(visitors.get(i)) || visitors.get(i).equals(user)) continue;
            if(map.containsKey(visitors.get(i)) ){
                int score = map.get(visitors.get(i));
                score++;
                map.put(visitors.get(i), score);
            }else{
                map.put(visitors.get(i), 1);
            }
        }
        System.out.println(map);
        List<String> valueList = new ArrayList(map.values());
        valueList.sort(String::compareTo);
        System.out.println("keyList = " + valueList);
        return valueList;
    }

    private static List<String> friendOfUser(String user, List<List<String>> friends) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < friends.size(); i++) {
            String A = friends.get(i).get(0);
//            System.out.println("A = " + A);
            String B = friends.get(i).get(1);
//            System.out.println("B = " + B);
//            System.out.println();
            String friend = A.equals(user) ? B : B.equals(user) ? A : "";
            if (!friend.equals("")) {
                list.add(friend);
            }

        }
        return list;
    }

}
