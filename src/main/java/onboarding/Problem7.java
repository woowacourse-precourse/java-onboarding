package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> my_friends = new HashSet<>();
        Map<String, Integer> score = new HashMap<>();
        List<Map.Entry<String, Integer>> sort_list;

        for(List<String> list : friends){
            if(list.get(0).equals(user))
                my_friends.add(list.get(1));
            else if(list.get(1).equals(user))
                my_friends.add(list.get(0));
        }

        for(List<String> list : friends){
            if(list.get(0).equals(user) || list.get(1).equals(user))
                continue;
            else if(my_friends.contains(list.get(0)))
                score.put(list.get(1), (score.getOrDefault(list.get(1), 0) + 10));
            else if(my_friends.contains(list.get(1)))
                score.put(list.get(0), (score.getOrDefault(list.get(0), 0) + 10));
        }

        for(String name : visitors){
            if(name.equals(user) || my_friends.contains(name))
                continue;

            score.put(name, (score.getOrDefault(name, 0) + 1));
        }

        sort_list = new ArrayList<Map.Entry<String, Integer>>(score.entrySet());
        Collections.sort(sort_list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue())
                    return o1.getKey().compareTo(o2.getKey());
                else
                    return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<String, Integer> entry : sort_list) {
            answer.add(entry.getKey());
            if(answer.size() > 5)
                break;
        }

        return answer;
    }
}
