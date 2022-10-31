package onboarding;

import java.util.*;

public class Problem7 {
    private static boolean check_user_length(String user){
        if (user.length() < 1 || user.length() > 30){
            return false;
        }
        return true;
    }
    private static boolean check_visitors_size(List<String> visitors){
        if (visitors.size() < 0 || visitors.size() > 10000){
            return false;
        }
        return true;
    }
    private static boolean check_friends_size(List<List<String>> friends){
        if (friends.size() < 1 || friends.size() > 10000){
            return false;
        }
        return true;
    }
    private static boolean is_in_friend_size(String friend_id) {
        if (friend_id.length() < 1 || friend_id.length() > 30)
            return false;
        return true;
    }
    private static boolean check_friends_element(List<List<String>> friends){
        for (List<String> relation : friends) {
            if (relation.size() != 2){
                return false;
            }
            if (!is_in_friend_size(relation.get(0)) || !is_in_friend_size(relation.get(1)))
                return false;
        }
        return true;
    }
    private static boolean check_friends_repetition(List<List<String>> friends){
        HashSet<List<String>> friendsSet = new HashSet<>(friends);
        if (friendsSet.size() != friends.size())
            return false;
        return true;
    }
    private static boolean check_user_alphabet(String user_id){
        if (!user_id.matches("^[a-z]*$"))
            return false;
        return true;
    }
    private static boolean check_exceptions(String user, List<List<String>> friends, List<String> visitors) {
        if (!check_user_length(user))
            return false;
        if (!check_visitors_size(visitors))
            return false;
        if (!check_friends_size(friends))
            return false;
        if (!check_friends_element(friends))
            return false;
        if (!check_user_alphabet(user))
            return false;
        if (!check_friends_repetition(friends))
            return false;
        return true;
    }
    private static List<String> find_user_friend(String user, List<List<String>> friends) {
        List<String> user_friend = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).get(0) == user){
                user_friend.add(friends.get(i).get(1));
            }
            if (friends.get(i).get(1) == user) {
                user_friend.add(friends.get(i).get(0));
            }
        }
        return (user_friend);
    }
    private static void update_values(HashMap<String, Integer> friend_score, String friends, int point) {
        int value;
        if (friend_score.containsKey(friends)) {
            value = friend_score.get(friends);
            friend_score.put(friends, value + point);
        }
        else
            friend_score.put(friends, point);
    }


    private static List<String> add_name_to_answer(List<String> friend_score) {
        List<String> answer = new ArrayList<>();
        for (String item : friend_score)
        {
            answer.add(item);
            if (answer.size() >= 5)
                return (answer);
        }
        return (answer);
    }

    private static List<String> sort_by_score(HashMap<String, Integer> friend_score) {
        List<Map.Entry<String, Integer>> key_val_List = new LinkedList<>(friend_score.entrySet()); //linked list에 저장
        Collections.sort(key_val_List, new Comparator<Map.Entry<String, Integer>>(){
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else if (o1.getValue() < o2.getValue()) {
                return 1;
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        }
        });
        List<String> sortedMap = new ArrayList<>();
        for (Iterator<Map.Entry<String, Integer>> iter = key_val_List.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.add(entry.getKey());
            }
        return sortedMap;
    }

    private static void update_relation_score(String user, List<List<String>> friends, List<String> user_friends, HashMap<String, Integer> friend_score) {
        for (List<String> relation : friends){
            for (String user_friend : user_friends){
                if (relation.get(0) == user_friend && relation.get(1) != user){
                    update_values(friend_score, relation.get(1), 10);
                }
                if (relation.get(1) == user_friend && relation.get(0) != user){
                    update_values(friend_score, relation.get(0), 10);
                }
            }
        }
    }
    private static void update_visitor_score(List<String> visitors, List<String> user_friends, HashMap<String, Integer> friend_score) {
        for (String visitor : visitors){
            if (!user_friends.contains(visitor)) {
                update_values(friend_score, visitor, 1);
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> user_friends = new ArrayList<>();
        HashMap<String, Integer> friend_score = new HashMap<>();
        answer = List.of("");
        if (!check_exceptions(user, friends, visitors))
            return List.of("");
        user_friends = find_user_friend(user, friends);
        update_relation_score(user, friends, user_friends, friend_score);
        update_visitor_score(visitors, user_friends, friend_score);
        answer = sort_by_score(friend_score);
        answer = add_name_to_answer(answer);
        return answer;
    }


}
