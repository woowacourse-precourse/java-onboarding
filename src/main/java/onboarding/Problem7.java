package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        List<String> friendsOfUser = new ArrayList<String>();
        HashMap<String, Integer> scores = new HashMap<String, Integer>();

        for (int i=0; i<friends.size(); i++) {
            for (int j=0; j<2; j++) {
                if (friends.get(i).get(j) == user) {
                    friendsOfUser.add(friends.get(i).get(1-j));
                }
            }
            addOne(scores, friends.get(i).get(0));
            addOne(scores, friends.get(i).get(1));
        }

        for (int i=0; i<friends.size(); i++) {
            for (int j=0; j<2; j++) {
                if (friendsOfUser.contains(friends.get(i).get(j))) {
                    Integer score = scores.get(friends.get(i).get(1 - j));
                    scores.replace(friends.get(i).get(1-j), score + 10);
                }
            }
        }

        for (int i=0; i<visitors.size(); i++) {
            addOne(scores, visitors.get(i));
            Integer score = scores.get(visitors.get(i));
            scores.replace(visitors.get(i), score + 1);
        }

        scores.remove(user);
        for (int i=0; i<friendsOfUser.size(); i++) {
            scores.remove(friendsOfUser.get(i));
        }

        List<Map.Entry<String, Integer>> collect = scores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        int i=0;
        for (Map.Entry<String, Integer> entry : collect) {
            if (i++==5) break;
            answer.add(entry.getKey());
        }

        return answer;
    }

    public static void addOne(HashMap<String, Integer> score, String friend) {
        if (!score.containsKey(friend))
            score.put(friend, 0);
    }

}
