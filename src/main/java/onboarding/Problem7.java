package onboarding;

import java.util.*;

public class Problem7 {

    public static boolean isFriend(String me, String you, HashMap<String, List<String>> friends) {
        List<String> me_friends = friends.get(me);
        List<String> you_friends = friends.get(you);

        if (me_friends == null || you_friends == null)
            return false;
        return me_friends.contains(you) || you_friends.contains(me);
    }
    public static HashMap<String, List<String>> initMap(List<List<String>> friends) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for(List<String> friend: friends) {
            String me = friend.get(0);
            String you = friend.get(1);

            if (!graph.containsKey(me))
                graph.put(me, new LinkedList<>());
            if (!graph.containsKey(you))
                graph.put(you, new LinkedList<>());

            if (graph.containsKey(me)) {
                LinkedList<String> update_friends = (LinkedList<String>) graph.get(me);
                update_friends.add(you);
                graph.put(me, update_friends);
            }

            if (graph.containsKey(you)) {
                LinkedList<String> update_friends = (LinkedList<String>) graph.get(you);
                update_friends.add(me);
                graph.put(you, update_friends);
            }
        }

        return graph;
    }

    public static int get_union_friend(String me, String you, HashMap<String, List<String>> friends) {
        List<String> me_friends = friends.get(me);
        List<String> you_friends = friends.get(you);

        if (me_friends == null || you_friends == null)
            return 0;

        int cnt = 0;
        for(String you_friend : you_friends) {
            for(String me_friend : me_friends) {
                if (you_friend.equals(me_friend))
                    cnt++;
            }
        }
        return cnt;
    }

    public static List<String[]> toList(HashMap<String, Integer> recommend_data) {
        List<String> users = new LinkedList<>(recommend_data.keySet());
        List<Integer> scores = new LinkedList<>(recommend_data.values());

        List<String[]> result = new LinkedList<String[]>();
        for (int i = 0; i < scores.size(); i++) {
            Integer score = scores.get(i);
            String name = users.get(i);
            result.add(new String[]{name, String.valueOf(score)});
        }

        return result;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> hash_friends = initMap(friends);
        HashMap<String, Integer> recommend_data = new HashMap<String, Integer>();

        // 방문에 따른 점수
        for(String visitor : visitors) {
            if (!recommend_data.containsKey(visitor))
                recommend_data.put(visitor, 0);
            if (isFriend(user, visitor, hash_friends))
                continue;

            int score = recommend_data.get(visitor) + 1;

            recommend_data.put(visitor, score);
        }

        // 친구에 따른 점수
        List<String> user_friends = hash_friends.get(user);
        for(String friend : user_friends) {
            List<String> friend_friends = hash_friends.get(friend);
            if (friend_friends == null) continue;

            for(String friend_friend : friend_friends) {
                if (friend_friend.equals(user)) continue;
                if (!recommend_data.containsKey(friend_friend))
                    recommend_data.put(friend_friend, 10);
                else
                    recommend_data.put(friend_friend, recommend_data.get(friend_friend) + 10);
            }
        }

        List<String[]> recommend_users = toList(recommend_data);
        recommend_users.sort((o1, o2) -> {
            if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1]))
                return (o1[0].compareTo(o2[0]));
            return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
        });

        List<String> result = new LinkedList<>();
        for (int i = 0; i < recommend_users.size() && i < 5; i++) {
            String name = recommend_users.get(i)[0];
            int score = Integer.parseInt(recommend_users.get(i)[1]);
            if (score == 0)
                break;

            result.add(name);
        }
        return result;
    }
}
