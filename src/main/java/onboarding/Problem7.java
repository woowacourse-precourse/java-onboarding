package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        HashMap<String, List<String>> mates = new HashMap<>();
        HashMap<String, Integer> score = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (List<String> name : friends) {
            if (!mates.containsKey(name.get(0))) {
                List<String> friend = new ArrayList<>();
                mates.put(name.get(0), friend);
            }
            if (!mates.containsKey(name.get(1))) {
                List<String> friend = new ArrayList<>();
                mates.put(name.get(1), friend);
            }
            List<String> oneFriend = mates.get(name.get(0));
            oneFriend.add(name.get(1));

            List<String> twoFriend = mates.get(name.get(1));
            twoFriend.add(name.get(0));
        }

        if (mates.containsKey(user)) {
            for (String name : mates.get(user))
                mates.remove(name);

            for (String name : mates.keySet()) {
                if (name.equals(user))
                    continue;
                score.put(name, mates.get(name).size() * 10);
            }

            List<String> temp = mates.get(user);
            for (String visitor : visitors) {
                if (!temp.contains(visitor))
                    score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        } else {
            for (String visitor : visitors)
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }

        List<Map.Entry<String, Integer>> listkeyset = new ArrayList<>(score.entrySet());
        listkeyset.sort(new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue())
                    return o1.getKey().compareTo(o2.getKey());
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = 0; i < listkeyset.size(); i++) {
            if (i > 4)
                break;
            result.add(listkeyset.get(i).getKey());
        }

        return result;
    }
}
