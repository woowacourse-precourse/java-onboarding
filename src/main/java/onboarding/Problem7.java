package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Set<String> set = new HashSet<String>();
        for (List<String> friend : friends) {
            set.add(friend.get(0));
            set.add(friend.get(1));
        }

        // init people list, point map
        List<String> people = new ArrayList<>(set);
        HashMap<String, Integer> point = new HashMap<>();

        for (String person : people) {
            point.put(person, 0);
        }

        int user_idx = people.indexOf(user);
        List<List<String>> relation = new ArrayList<>();

        for (String person : people) {
            List<String> related = new ArrayList<>();
            for (List<String> friend : friends) {
                if (person.equals(friend.get(0))) related.add(friend.get(1));
                else if (person.equals(friend.get(1))) related.add(friend.get(0));
            }
            relation.add(related);
        }

        List<String> userFriends = relation.get(user_idx);

        for (int i = 0; i < relation.size(); i++){
            if (i == user_idx || userFriends.contains(people.get(i))) continue;

            List<String> compare_list = relation.get(i);
            String compare_friend = people.get(i);

            for (String userFriend : userFriends) {
                if (compare_list.contains(userFriend)) {
                    point.put(compare_friend, point.get(compare_friend) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) continue;
            if (point.containsKey(visitor)){
                point.put(visitor, point.get(visitor) + 1);
            }
            else{
                point.put(visitor, 1);
            }
        }

        for (String s : point.keySet()) {
            if (answer.size() == 5) break;
            if (point.get(s) != 0){
                answer.add(s);
            }
        }
        Collections.sort(answer);
        answer.sort((a,b) ->{
           return point.get(b).compareTo(point.get(a));
        });

        return answer;
    }
}
