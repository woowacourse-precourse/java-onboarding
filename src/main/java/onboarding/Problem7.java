package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Comparator;

public class Problem7 {

    static final int SCORE_OF_COMMON_FRIEND = 10;
    static final int SCORE_OF_TIMELINE_VISIT = 1;
    static final int MAX_LIST_SIZE = 5;

    static Map<String, ArrayList<String>> friend_map;
    static Map<String, Integer> score_map;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static void get_friend_map(List<List<String>> friends){

        friend_map = new HashMap<>();

        for(List<String> pair : friends) {
            String user1 = pair.get(0);
            String user2 = pair.get(1);

            add_relationship(user1, user2);
            add_relationship(user2, user1);
        }

    }

    static void get_score_map(String user, List<String> visitors){

        score_map = new TreeMap<>();

        consider_friend_of_friend(user);
        consider_visitor(user, visitors);

    }

    static List<String> get_recommended_friend_list(){

        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(score_map.entrySet());

        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        List<String> recommended_friend_list = new ArrayList<String>();

        for(Entry<String, Integer> entry : list_entries) {
            if(recommended_friend_list.size() > MAX_LIST_SIZE) break;
            recommended_friend_list.add(entry.getKey());
        }

        return recommended_friend_list;
    }

    static void add_relationship(String user1, String user2){

        if(friend_map.containsKey(user1)) {
            friend_map.get(user1).add(user2);
        }
        else {
            friend_map.put(user1, new ArrayList<String>());
            friend_map.get(user1).add(user2);
        }

    }

    static void consider_friend_of_friend(String user){

        ArrayList<String> friend_list = friend_map.get(user);

        for(String friend : friend_list) {
            ArrayList<String> friend_of_friend_list = friend_map.get(friend);

            for(String friend_of_friend : friend_of_friend_list) {

                if(friend_map.get(user).contains(friend_of_friend) || user.equals(friend_of_friend)) continue;

                if(score_map.containsKey(friend_of_friend)) {
                    score_map.put(friend_of_friend, score_map.get(friend_of_friend)+SCORE_OF_COMMON_FRIEND);
                }
                else {
                    score_map.put(friend_of_friend, SCORE_OF_COMMON_FRIEND);
                }
            }
        }
    }

    static void consider_visitor(String user, List<String> visitors) {
        for(String visited : visitors) {

            if(friend_map.get(user).contains(visited) || user.equals(visited)) continue;

            if(score_map.containsKey(visited)) {
                score_map.put(visited, score_map.get(visited)+SCORE_OF_TIMELINE_VISIT);
            }
            else {
                score_map.put(visited, SCORE_OF_TIMELINE_VISIT);
            }
        }
    }

}
