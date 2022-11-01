package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Integer> refArr = new HashMap<>();
        List<String> friendArr = new ArrayList<>();
        String userfriend;
        int score =0;

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                friendArr.add(friend.get(0));
            }
        }

        for (int i=0; i < friends.size(); i++) {
            for (String userFriend : friendArr) {
                if (friends.get(i).contains(userFriend)) {
                    userfriend = friends.get(i).get(1);
                    if (userfriend.equals(user))
                        continue;
                    if (refArr.containsKey(userfriend)) {
                        score = refArr.get(userfriend);
                        score += 10;
                        refArr.put(userfriend, score);
                    } else {
                        refArr.put(userfriend, 10);
                    }
                }
            }
        }

        for (String visitor : visitors) {
            if (!friendArr.contains(visitor)) {
                if (refArr.containsKey(visitor)) {
                    score = refArr.get(visitor);
                    score += 1;
                    refArr.put(visitor, score);
                } else {
                    refArr.put(visitor, 1);
                }
            }
        }

        final List<String> valueArr = new ArrayList<>();
        refArr.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(k -> {
                    valueArr.add(String.valueOf(k.getKey()));
                });
        answer = valueArr;

        if (answer.size() > 5) {
            answer = answer.subList(0,5);
        }
        return answer;
    }
}
