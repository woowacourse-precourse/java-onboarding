package onboarding;

import java.util.*;


/*
* 자료 구조
* 1. scoreMap : <이름, 점수> 저장하는 map
* 2. directFriends : user와 직접 친구인 사람 저장하는 List
* 3.
*
* */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        List<String> directFriends = new ArrayList<>();

        for (List<String> relationship : friends){
            if (relationship.get(0).equals(user)) directFriends.add(relationship.get(1));
            else if (relationship.get(1).equals(user)) directFriends.add(relationship.get(0));
        }

        for (String friend : directFriends) {
            for (List<String> relationship : friends){
                if (relationship.get(0).equals(friend))
                    scoreMap.put(relationship.get(1), scoreMap.getOrDefault(relationship.get(1), 0) + 5);
                else if (relationship.get(1).equals(friend))
                    scoreMap.put(relationship.get(0), scoreMap.getOrDefault(relationship.get(0), 0) + 5);
            }
        }

        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }
//        System.out.println(scoreMap);
        List<String> names = new ArrayList<>(scoreMap.keySet());
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return scoreMap.get(o2) - scoreMap.get(o1);
            }
        });

//        System.out.println(names);

        for (int i = 0; i < names.size(); i++) {
            if (answer.size() >= 5) break;

            if (directFriends.contains(names.get(i)) || names.get(i).equals(user)) continue;

            answer.add(names.get(i));
        }

        System.out.println("directFriends = " + directFriends);
        return answer;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        System.out.println(solution(user, friends, visitors));;
    }
}
