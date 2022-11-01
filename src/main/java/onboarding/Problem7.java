package onboarding;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Collections;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitor) {
        List<String> answer = new ArrayList();
        Map<String, Integer> score = new HashMap<String, Integer>();


        List<String> uFriend = new ArrayList<>();

        for (List<String> friendRecommendation : friends) {
            if (friendRecommendation.get(0) == user) {
                uFriend.add(friendRecommendation.get(1));
            } else if (friendRecommendation.get(1) == user) {
                uFriend.add(friendRecommendation.get(0));
            }
        }

        for (List<String> friendRecommendation : friends) {
            String f1 = friendRecommendation.get(0);
            String f2 = friendRecommendation.get(1);
            if (f1 == f2 || f2 == user) continue;
            if (uFriend.contains(f1) && !uFriend.contains(f2)) {
                int value = 0;
                value += 10;
                score.put(f2, value);
            } else if (uFriend.contains(f2) && !uFriend.contains(f1)) {
                int value = 0;
                value += 10;
                score.put(f1, value);
            }
        }


        for (int i = 0; i < visitor.size(); i++) {
            String visitFriend = visitor.get(i);
            if (score.containsKey(visitFriend)) {
                int value = (Integer) score.get(visitFriend);
                value += 1;
                score.put(visitFriend, value);
            } else {
                int value = 0;
                value += 1;
                score.put(visitFriend, value);
            }
        }



        List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(score.entrySet());

        Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        int limit = 5;
        for (Entry<String, Integer> entry : entryList) {
            if (entry.getValue() != 0) {
                answer.add(entry.getKey());
                limit--;
                if (limit <= 0) break;
            }
        }
        return answer;
    }
}
