package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> exFriends = new ArrayList<String>();

        for (List<String> strings : friends) {
            if (Objects.equals(strings.get(0), user)) {
                exFriends.add(strings.get(1));
            } else if (Objects.equals(strings.get(1), user)) {
                exFriends.add(strings.get(0));
            }
        }

        ArrayList<String> scoreTen = new ArrayList<String>();

        for (List<String> friend : friends) {
            for (String exFriend : exFriends) {
                if (Objects.equals(friend.get(0), exFriend) || Objects.equals(friend.get(1),
                    exFriend)) {
                    scoreTen.add(friend.get(0));
                    scoreTen.add(friend.get(1));
                }
            }
        }

        HashMap<String,Integer> scoreTable = new HashMap<String,Integer>();

        for (String value : scoreTen) {
            scoreTable.merge(value, 10, Integer::sum);
            ;
        }

        for (String visitor : visitors) {
            scoreTable.merge(visitor, 1, Integer::sum);
            ;
        }

        for (String exFriend : exFriends) {
            if (scoreTable.get(exFriend) != null)
            {
                scoreTable.remove(exFriend);
            }
        }

        scoreTable.remove(user);

        TreeMap<String, Integer> sortKey = new TreeMap<>(scoreTable);
        Map<String, Integer> sortDescending = sortKey.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
            (entry1, entry2) -> entry2, LinkedHashMap::new));

        List<String> sortedKeyList = new ArrayList<>(sortDescending.keySet());
        ArrayList<String> answer = new ArrayList<String>();
        if(sortedKeyList.size() > 5){
            for (int k = 0; k < 5; k++){
                answer.add(sortedKeyList.get(k));
            }
        }
        if(sortedKeyList.size() <= 5){
            answer.addAll(sortedKeyList);
        }

        return answer;
    }
}
