package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String,List<String>> friendsList = new HashMap<>();
        for (List<String> friend : friends) {

            List<String> tmp = friendsList.getOrDefault(friend.get(0), new ArrayList<>());
            tmp.add(friend.get(1));
            friendsList.put(friend.get(0),tmp);
            tmp = friendsList.getOrDefault(friend.get(1),new ArrayList<>());
            tmp.add(friend.get(0));
            friendsList.put(friend.get(1),tmp);
        }
        Map<String,Integer> scroeList = new HashMap<>();
        for (String name : friendsList.keySet()) {
            if(friendsList.get(name).contains(user))
            {
                for (String f : friendsList.get(name)) {
                    if(f.equals(user)) continue;
                    int score = scroeList.getOrDefault(f, 0);
                    scroeList.put(f,score+10);
                }
            }
        }


        for (String visitor : visitors) {
            int score = scroeList.getOrDefault(visitor,0);
            scroeList.put(visitor,score+1);

        }


        List<String> keySet = new ArrayList<>(scroeList.keySet());

        // Value 값으로 오름차순 정렬
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return scroeList.get(o2).compareTo(scroeList.get(o1));

            }
        });

        for (String key : keySet) {
            if (friendsList.get(user).contains(key)) continue;
            answer.add(key);

        }


        return answer;
    }

}
