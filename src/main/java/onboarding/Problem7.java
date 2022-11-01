package onboarding;

import java.util.*;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, HashSet<String>> friendMap = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for(List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            if(friendMap.containsKey(friend1)) {
                friendMap.get(friend1).add(friend2);
            } else {
                friendMap.put(friend1, new HashSet<>(List.of(friend2)));
            }
            if(friendMap.containsKey(friend2)) {
                friendMap.get(friend2).add(friend1);
            } else {
                friendMap.put(friend2, new HashSet<>(List.of(friend1)));
            }
        }

        for (String visitor : visitors) {
            if(scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, scoreMap.get(visitor) + 1);
            } else {
                scoreMap.put(visitor, 1);
            }
        }
        for (String userFriend : friendMap.get(user)) {
          friendMap.forEach((key, value) -> {
              if(value.contains(userFriend)) {
                  if(scoreMap.containsKey(key)) {
                      scoreMap.put(key, scoreMap.get(key) + 10);
                  } else {
                      scoreMap.put(key, 0);
                  }
              }
        });
        }
        scoreMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).filter(s -> s.getValue() >0).forEach(

                entry -> answer.add(entry.getKey())
        );
        answer.removeIf(s -> friendMap.get(user).contains(s) || s.equals(user));
        answer.subList(0, Math.min(5, answer.size()));



        return answer;
    }
}
