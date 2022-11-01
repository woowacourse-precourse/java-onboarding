package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        for (List<String> friend : friends) {
            String fr = friend.get(0);
            String me = friend.get(1);
            if (fr == user) {
                list.add(me);
            } else if (me == user) {
                list.add(fr);
            }
        }

        return answer;
    }
}
