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





        }


    }
}
