package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    public static Map<String, List<String>> make_friend_map(List<List<String>> friends) {
        Map<String, List<String>> result = new HashMap<String, List<String>>();

        for (int i = 0; i < friends.size(); i++) {
            if (result.containsKey(friends.get(i).get(0))) {
                List<String> temp_result = result.get(friends.get(i).get(0));
                temp_result.add(friends.get(i).get(1));
                result.put(friends.get(i).get(0), temp_result);
            } else {
                List<String> temp_result = new ArrayList<String>();
                temp_result.add(friends.get(i).get(1));
                result.put(friends.get(i).get(0), temp_result);
            }

            if (result.containsKey(friends.get(i).get(1))) {
                List<String> temp_result = result.get(friends.get(i).get(1));
                temp_result.add(friends.get(i).get(0));
                result.put(friends.get(i).get(1), temp_result);
            } else {
                List<String> temp_result = new ArrayList<String>();
                temp_result.add(friends.get(i).get(0));
                result.put(friends.get(i).get(1), temp_result);
            }
        }

        return result;
    }

    public static Map<String, Integer> make_score_map(String user, Map<String, List<String>> friend_map) {
        Map<String, Integer> result = new HashMap<String, Integer>();

        List<String> user_friends = friend_map.get(user);

        Iterator<String> keys = friend_map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();

            if (!key.equals(user)) {
                int score = 0;

                for (String friend : friend_map.get(key)) {
                    for (String user_friend : user_friends) {
                        if (friend.equals(user_friend)) {
                            score += 10;
                        }
                    }
                }

                result.put(key, score);
            }
        }

        return result;
    }

    public static Map<String, Integer> check_visitor(String user, Map<String, List<String>> friend_map, Map<String, Integer> score_map, List<String> visitors) {
        Map<String, Integer> result = score_map;

        List<String> user_friends = friend_map.get(user);

        for (String visitor : visitors) {
            Boolean check_friend = false;
            for (String user_friend : user_friends) {
                if (visitor.equals(user_friend)) {
                    check_friend = true;
                }
            }

            if (!check_friend) {
                if (result.containsKey(visitor)) {
                    result.put(visitor, result.get(visitor) + 1);
                } else {
                    result.put(visitor, 1);
                }
            }
        }

        return result;
    }

    public static List<String> make_answer(Map<String, Integer> update_map) {
        List<String> result = new ArrayList<String>();

        List<Entry<String, Integer>> update_entry = new ArrayList<Entry<String, Integer>>(update_map.entrySet());

        for (int i = 0; i < update_entry.size(); i++) {
            if (update_entry.get(i).getValue() == 0) {
                update_entry.remove(i);
                i = i - 1;
            }
        }

        Collections.sort(update_entry, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> value1, Entry<String, Integer> value2) {
                if (value1.getValue().compareTo(value2.getValue()) == 0) {
                    return value1.getKey().compareTo(value2.getKey());
                }
                return value2.getValue().compareTo(value1.getValue());
            }
        });

        for (Entry<String, Integer> entry : update_entry) {
            result.add(entry.getKey());
        }

        return result;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friend_map = make_friend_map(friends);

        Map<String, Integer> score_map = make_score_map(user, friend_map);

        Map<String, Integer> update_map = check_visitor(user, friend_map, score_map, visitors);

        List<String> temp_answer = make_answer(update_map);

        answer = temp_answer;

        return answer;
    }
}
