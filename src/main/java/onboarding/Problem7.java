package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();
        for(List<String> list : friends) {
            String name1 = list.get(0);
            String name2 = list.get(1);
            if(!friendsMap.containsKey(name1))
                friendsMap.put(name1, new ArrayList<>());

            if(!friendsMap.containsKey(name2))
                friendsMap.put(name2, new ArrayList<>());

            friendsMap.get(name1).add(name2);
            friendsMap.get(name2).add(name1);
        }

        ArrayList<String> userFriendsList = friendsMap.get(user);
        Map<String, Integer> recommendMap = new HashMap<>();
        for(String name : userFriendsList) {
            ArrayList<String> list = friendsMap.get(name);
            for(String s : list) {
                if(!s.equals(user) && !userFriendsList.contains(s)) {
                    if(!recommendMap.containsKey(s))
                        recommendMap.put(s, 10);
                    else {
                        int n = recommendMap.get(s);
                        n += 10;
                        recommendMap.put(s, n);
                    }
                }
            }
        }

        for(String name : visitors) {
            if(!userFriendsList.contains(name)) {
                if(!recommendMap.containsKey(name))
                    recommendMap.put(name, 1);
                else {
                    int n = recommendMap.get(name);
                    n++;
                    recommendMap.put(name, n);
                }
            }
        }

        ArrayList<Integer> tmp = new ArrayList<>(recommendMap.values());
        ArrayList<Integer> values = new ArrayList<>();

        for(Integer n : tmp) {
            if(!values.contains(n) && n != 0)
                values.add(n);
        }

        values.sort(Collections.reverseOrder());

        ArrayList<String> order = new ArrayList<>();
        List<String> answer = new ArrayList<>(5);
        for(int n : values) {
            for (Map.Entry<String, Integer> entry : recommendMap.entrySet()) {
                if (entry.getValue().equals(n))
                    order.add(entry.getKey());
            }
            Collections.sort(order);
            for(String name : order) {
                if(answer.size() != 5)
                    answer.add(name);
                else
                    return answer;
            }
            order.clear();
        }

        return answer;
    }
}
