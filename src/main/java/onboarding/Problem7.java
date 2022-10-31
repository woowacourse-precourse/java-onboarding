package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    // 매개변수를 참고해 각 사람이 어떤 친구가 있는지 파악하는 Map을 만드는 함수
    public static Map<String, List<String>> make_friend_map(List<List<String>> friends) {
        Map<String, List<String>> friend_map = new HashMap<String, List<String>>();

        for (int i = 0; i < friends.size(); i++) {
            if (friend_map.containsKey(friends.get(i).get(0))) {
                List<String> temp = friend_map.get(friends.get(i).get(0));
                temp.add(friends.get(i).get(1));
                friend_map.put(friends.get(i).get(0), temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(friends.get(i).get(1));
                friend_map.put(friends.get(i).get(0), temp);
            }

            if (friend_map.containsKey(friends.get(i).get(1))) {
                List<String> temp = friend_map.get(friends.get(i).get(1));
                temp.add(friends.get(i).get(0));
                friend_map.put(friends.get(i).get(1), temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(friends.get(i).get(0));
                friend_map.put(friends.get(i).get(1), temp);
            }
        }

        return friend_map;
    }

    // 친구 Map으로 사용자와 사용자 친구를 제외한 다른 친구들의 점수 Map을 만드는 함수
    public static Map<String, Integer> make_score_map(String user, Map<String, List<String>> friend_map) {
        Map<String, Integer> result = new HashMap<String, Integer>();

        List<String> user_friends = new ArrayList<>();

        if (friend_map.containsKey(user)) {
            user_friends = friend_map.get(user);
        }

        List<String> user_or_user_friends = user_friends;
        user_or_user_friends.add(user);

        Iterator<String> keys = friend_map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();

            Boolean check_user_or_friend = false;

            for (String user_or_user_friend : user_or_user_friends) {
                if (key.equals(user_or_user_friend)) {
                    check_user_or_friend = true;
                }
            }

            if (!check_user_or_friend) {
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

    // 점수 Map에 사용자와 사용자 친구를 제외한 방문자 점수를 추가하는 함수
    public static Map<String, Integer> check_visitor(String user, Map<String, List<String>> friend_map, Map<String, Integer> score_map, List<String> visitors) {
        Map<String, Integer> result = score_map;

        List<String> user_friends = new ArrayList<>();

        if (friend_map.containsKey(user)) {
            user_friends = friend_map.get(user);
        }

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

    // 추천 친구를 가져와 정렬하는 함수
    public static List<String> sort_recommand_friends(Map<String, Integer> check_visitor_map) {
        List<String> sorted_recommand_friends = new ArrayList<String>();

        List<Entry<String, Integer>> check_visitor_entry = new ArrayList<Entry<String, Integer>>(check_visitor_map.entrySet());

        for (int i = 0; i < check_visitor_entry.size(); i++) {
            if (check_visitor_entry.get(i).getValue() == 0) {
                check_visitor_entry.remove(i);
                i = i - 1;
            }
        }

        Collections.sort(check_visitor_entry, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> value1, Entry<String, Integer> value2) {
                if (value1.getValue().compareTo(value2.getValue()) == 0) {
                    return value1.getKey().compareTo(value2.getKey());
                }
                return value2.getValue().compareTo(value1.getValue());
            }
        });

        for (Entry<String, Integer> entry : check_visitor_entry) {
            sorted_recommand_friends.add(entry.getKey());
            if (sorted_recommand_friends.size() == 5) {
                break;
            }
        }

        return sorted_recommand_friends;
    }

    // 실행 함수
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friend_map = make_friend_map(friends);

        Map<String, Integer> score_map = make_score_map(user, friend_map);

        Map<String, Integer> check_visitor_map = check_visitor(user, friend_map, score_map, visitors);

        List<String> sorted_recommand_friends = sort_recommand_friends(check_visitor_map);

        answer = sorted_recommand_friends;

        return answer;
    }
}
