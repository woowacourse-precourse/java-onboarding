package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> candidates = new HashMap<>();
        List<String> userFriends = getFriends(user, friends);
        // 친구의 친구에게 10점을 부여하고 추가하는 부분
        for(List<String> list : friends) {
            if(userFriends.contains(list.get(0)) && !list.get(1).equals(user)) candidates.put(list.get(1), 10);
            else if (userFriends.contains(list.get(1)) && !list.get(0).equals(user)) candidates.put(list.get(0), 10);
        }
        for(String visitor : visitors)  {
            if(!userFriends.contains(visitor)) {
                candidates.merge(visitor, 1, Integer::sum);
            }
        }
        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(candidates.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> aa : list) answer.add(aa.getKey());
        if(answer.size() < 6) return answer;
        else return answer.subList(0, 5);
    }
    public static List<String> getFriends(String user, List<List<String>> friendsRelationship) {
        List<String> answer = new ArrayList<>();
        for(List<String> list : friendsRelationship) {
            if(list.get(0).equals(user)) answer.add(list.get(1));
            else if (list.get(1).equals(user)) answer.add(list.get(0));
        }
        return answer;
    }
}
