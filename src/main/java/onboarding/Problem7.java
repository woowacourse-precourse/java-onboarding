package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, Integer> check_friend(String user, ArrayList<List<String>> friend_list) {
        Map<String, Integer> friend_score_map = new HashMap<String, Integer>();

        for (int i = 0; i < friend_list.size(); i++) {
            if (friend_list.get(i).get(0).equals(user)) {
                friend_score_map.put(friend_list.get(i).get(1), 10);
            }

            else if (friend_list.get(i).get(1).equals(user)) {
                friend_score_map.put(friend_list.get(i).get(0), 10);
            }
        }

        return friend_score_map;
    }

    public static Map<String, Integer> check_visitor(String user, ArrayList<String> friend_list, Map<String, Integer> score_map) {
        Map<String, Integer> visitor_score_map = score_map;

        for (int i = 0; i < friend_list.size(); i++) {
            if (visitor_score_map.containsKey(friend_list.get(i))) {
                int change_value = visitor_score_map.get(friend_list.get(i)) + 1;
                visitor_score_map.put(friend_list.get(i), change_value);
            }
            else {
                visitor_score_map.put(friend_list.get(i), 1);
            }
        }

        return visitor_score_map;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        ArrayList<List<String>> friend_list = new ArrayList<List<String>> ();
        for (int i = 0; i < friends.size(); i++) {
            friend_list.add(friends.get(i));
        }

        Map<String, Integer> score_map = new HashMap<String, Integer>();

        score_map = check_friend(user, friend_list);

        ArrayList<String> visitor_list = new ArrayList<String>();
        for (int i = 0; i < visitors.size(); i++) {
            visitor_list.add(visitors.get(i));
        }

        score_map = check_visitor(user, visitor_list, score_map);

        System.out.print(score_map);

        return answer;
    }
}
