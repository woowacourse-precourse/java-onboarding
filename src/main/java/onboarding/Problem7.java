package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> result = new HashMap();
        List<String> friendTofriend = new ArrayList<>();

        for (String visitor : visitors) {
            addPersonOnePoint(visitor, result);
        }

        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                if (result.containsKey(friend.get(1))) {
                    result.remove(friend.get(1));
                    friendTofriend.add(friend.get(1));
                }
            } else if (friend.get(1).equals(user)) {
                if (result.containsKey(friend.get(0))) {
                    result.remove(friend.get(0));
                    friendTofriend.add(friend.get(0));
                }
            }
        }
        for (List<String> friend : friends) {
            if (friendTofriend.contains(friend.get(1)) && !(friend.get(0).equals(user))) {
                addPersonTenPoint(friend.get(0), result);

            } else if (friendTofriend.contains(friend.get(0)) && !(friend.get(1).equals(user))) {
                addPersonTenPoint(friend.get(1), result);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(result.entrySet());
        List<String> answer = new ArrayList<>();
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        result.entrySet().stream().sorted(Map.Entry.comparingByValue());

        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey());
        }

        return answer;
    }

    public static void addPersonOnePoint(String visitor, HashMap<String, Integer> result) {
        if (result.containsKey(visitor))
            result.put(visitor, result.get(visitor) + 1);
        else {
            result.put(visitor, 1);
        }
    }

    public static void addPersonTenPoint(String visitor, HashMap<String, Integer> result) {
        if (result.containsKey(visitor))
            result.put(visitor, result.get(visitor) + 10);
        else {
            result.put(visitor, 10);
        }
    }
}
