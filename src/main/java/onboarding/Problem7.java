package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> CurrentFriends = CurrentFriends(user, friends);
        HashMap<String, Integer> PossibleFriends = PossibleFriend(user, friends, CurrentFriends);
        CountOverlappingFriend(PossibleFriends, CurrentFriends, friends);
        CountVisitors(PossibleFriends, CurrentFriends, visitors);
        List<String> answer = sortSuggestionList(PossibleFriends);
        List<String> ret = new ArrayList<>();
        int k = (answer.size() > 5)? 5 : answer.size();
        for (int i = 0; i < k; i++)
            ret.add(answer.get(i));
        return ret;
    }

    private static HashMap<String, Integer> PossibleFriend(String usr, List<List<String>> friends, List<String> CurrentFriends) {
        HashMap<String, Integer> PossibleFriends = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (!CurrentFriends.contains(friends.get(i).get(j)) && friends.get(i).get(j) != usr) {
                    PossibleFriends.put(friends.get(i).get(j), 0);
                }
            }
        }
        return PossibleFriends;
    }

    private static List<String> CurrentFriends(String usr, List<List<String>> friends) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(usr)) {
                list.add(friends.get(i).get(0));
                list.add(friends.get(i).get(1));
            }
        }
        while (list.contains(usr))
            list.remove(new String(usr));
        return list;
    }

    private static void CountOverlappingFriend(HashMap<String, Integer> PossibleFriend, List<String> CurrentFriend, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            if (CurrentFriend.contains(friends.get(i).get(0)) && PossibleFriend.containsKey(friends.get(i).get(1))) {
                int value = PossibleFriend.get(friends.get(i).get(1));
                PossibleFriend.replace(friends.get(i).get(1), value + 10);
            } else if (CurrentFriend.contains(friends.get(i).get(1)) && PossibleFriend.containsKey(friends.get(i).get(0))) {
                int value = PossibleFriend.get(friends.get(i).get(0));
                PossibleFriend.replace(friends.get(i).get(0), value + 10);
            }
        }
    }

    private static void CountVisitors(HashMap < String, Integer > PossibleFriend, List < String > CurrentFriend, List < String > visitors){
        for (int i = 0; i < visitors.size(); i++) {
            if (PossibleFriend.containsKey(visitors.get(i))) {
                int value = PossibleFriend.get(visitors.get(i));
                PossibleFriend.replace(visitors.get(i), value + 1);
            }
            else if (!CurrentFriend.contains(visitors.get(i))){
                PossibleFriend.put(visitors.get(i), 1);
            }
        }
    }

    private static List<String> sortSuggestionList(HashMap < String, Integer > PossibleFriend){
        List<Map.Entry<String, Integer>> list = new LinkedList<>(PossibleFriend.entrySet());
        Collections.sort(list, (o1, o2) -> {
            int comparision = (o1.getValue() - o2.getValue()) * -1;
            return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        while (sortedMap.containsValue(0))
            sortedMap.values().remove(0);
        List<String> ret = new ArrayList<>();
        sortedMap.forEach((k,v)->ret.add(k));
        return ret;
    }
}