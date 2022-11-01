package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {


        Map<String, Integer> result = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();

        for (List<String> friend : friends) {
            String friend_one = friend.get(0);
            String friend_two = friend.get(1);

            List<String> List_one = new ArrayList<>();
            if(map.get(friend_one) != null) List_one = map.get(friend_one);
            List_one.add(friend_two);
            map.put(friend_one, List_one);

            List<String> List_two = new ArrayList<>();
            if(map.get(friend_two) != null) List_two = map.get(friend_two);
            List_two.add(friend_one);
            map.put(friend_two, List_two);
        }

        for (String name : map.get(user)) {
            for (String friend : map.get(name)) {
                int score = 0;

                if(friend==user) {
                    continue;
                }
                if(map.get(user).contains(friend)) {
                    continue;
                }

                if(result.get(friend) != null) {
                    score = result.get(friend);
                }
                result.put(friend, score+10);
            }
        }

        for (String visitor : visitors) {
            int score = 0;
            if(visitor==user) {
                continue;
            }
            if(map.get(user).contains(visitor)) {
                continue;
            }

            if(result.get(visitor) != null) {
                score = result.get(visitor);
            }
            result.put(visitor, score+1);
        }

        List<String> answer = new ArrayList<>(result.keySet());
        answer.sort((nameA, nameB) ->  {
            if(result.get(nameA).equals(result.get(nameB))){
                return nameA.compareTo(nameB);
            } else {
                return result.get(nameB) - result.get(nameA);
            }
        });
        if(answer.size()>5) answer = answer.subList(0,5);
        return answer;

    }
}
