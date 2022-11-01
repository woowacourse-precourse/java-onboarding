package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        Map<String, Integer> score;

        score = calculateFriendScore(user, friends, visitors);
        answer = sortScore(score);

        return answer;
    }

    public static Set<String> findMyFriends(String user, List<List<String>> friends){
        Set<String> myFriends = new HashSet<>();
        for(List<String> list : friends){
            if(list.get(0).equals(user))
                myFriends.add(list.get(1));
            if(list.get(1).equals(user))
                myFriends.add(list.get(0));
        }

        return myFriends;
    }

    public static Map<String, Integer> calculateFriendScore(String user, List<List<String>> friends, List<String> visitors){
        Set<String> myFriends;
        myFriends = findMyFriends(user, friends);
        Map<String, Integer> score = new HashMap<>();

        for(List<String> list : friends){
            if(list.get(0).equals(user) || list.get(1).equals(user))
                continue;

            if((myFriends.contains(list.get(0))) && !myFriends.contains(list.get(1)))
                score.put(list.get(1), (score.getOrDefault(list.get(1), 0) + 10));

            if(myFriends.contains(list.get(1)) && !myFriends.contains(list.get(0)))
                score.put(list.get(0), (score.getOrDefault(list.get(0), 0) + 10));
        }

        for(String name : visitors){
            if(name.equals(user) || myFriends.contains(name))
                continue;

            score.put(name, (score.getOrDefault(name, 0) + 1));
        }

        return score;
    }

    public static List<String> sortScore(Map<String, Integer> score){
        List<String> sortedScore = new ArrayList<>();
        List<Map.Entry<String, Integer>> sortList;
        sortList = new ArrayList<>(score.entrySet());
        sortList.sort((o1, o2) -> {
            if (o1.getValue() == o2.getValue())
                return o1.getKey().compareTo(o2.getKey());

            return o2.getValue().compareTo(o1.getValue());
        });

        for(Map.Entry<String, Integer> entry : sortList) {
            sortedScore.add(entry.getKey());
            if(sortedScore.size() == 5)
                break;
        }

        return sortedScore;
    }
}
