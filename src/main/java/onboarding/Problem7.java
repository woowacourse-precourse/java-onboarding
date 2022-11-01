package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Problem7 {

    static TreeMap<String, Integer> treemap = new TreeMap<>();
    static ArrayList<String> friend_lis = new ArrayList<>();

    static ArrayList<String> common_friend_lis = new ArrayList<>();
    public static void Friend_find(String user, String friend, List<List<String>> friends){
        for (List i : friends) {
            if (i.get(0) == friend && i.get(1) != user) {
                String common_friend = i.get(1).toString();
                common_friend_lis.add(common_friend);
            } else if (i.get(1) == friend && i.get(0) != user) {
                String common_friend = i.get(0).toString();
                common_friend_lis.add(common_friend);
            }
        }


    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
