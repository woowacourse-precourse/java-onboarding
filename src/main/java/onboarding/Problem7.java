package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendList = new ArrayList<>();
        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < friends.size(); i += 1) {
            if (friends.get(i).get(1) == user) {
                friendList.add(friends.get(i).get(0));
            } else if (friends.get(i).get(0) == user) {
                friendList.add(friends.get(i).get(1));
            }
        }

        for (int i = 0; i < friends.size(); i += 1) {
            for (int j = 0; j < friendList.size(); j += 1) {
                if (friends.get(i).get(1) == friendList.get(j)) {
                    if (result.containsKey(friends.get(i).get(0))) {
                        result.put(friends.get(i).get(0), result.get(friends.get(i).get(0)) + 10);
                    } else {
                        result.put(friends.get(i).get(0), 10);
                    }
                } else if (friends.get(i).get(0) == friendList.get(j)) {
                    if (result.containsKey(friends.get(i).get(1))) {
                        result.put(friends.get(i).get(1), result.get(friends.get(i).get(1)) + 10);
                    } else {
                        result.put(friends.get(i).get(1), 10);
                    }
                }
            }
        }

        for (int i = 0; i < visitors.size(); i += 1) {
            if (result.containsKey(visitors.get(i))) {
                result.put(visitors.get(i), result.get(visitors.get(i)) + 1);
            } else {
                result.put(visitors.get(i), 1);
            }
        }

        if (result.containsKey(user)){
            result.remove(user);
        }

        for (int i = 0; i < friendList.size(); i+=1){
            if (result.containsKey(friendList.get(i))){
                result.remove(friendList.get(i));
            }
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
