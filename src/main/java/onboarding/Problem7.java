package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> nears = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                for (int j = 0; j < friends.get(i).size(); j++) {
                    if (friends.get(i).get(j) != user) {
                        nears.add(friends.get(i).get(j));
                    }
                }
            }
        }

        int point = 10;
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < nears.size(); j++) {
                if (friends.get(i).contains(nears.get(j))
                        && !friends.get(i).contains(user)) {
                    for (int k = 0; k < friends.get(i).size(); k++) {
                        if (friends.get(i).get(k) != nears.get(j)) {
                            if (!map.containsKey(friends.get(i).get(k))) {
                                map.put(friends.get(i).get(k), point);
                            } else {
                                map.put(friends.get(i).get(k), map.get(friends.get(i).get(k))+10);
                            }
                        }
                    }
                }
            }
        }

        for (String key : visitors) {
            Integer value = map.get(key);
            if (value == null) map.put(key, 1);
            else map.put(key, value + 1);
        }

        for(int i=0;i<nears.size();i++){
            if(map.containsKey(nears.get(i)))
                map.remove(nears.get(i));
        }

        List<String> result = new ArrayList<>(map.keySet());
        result.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        for (String key : result) {
            answer.add(key);
        }

        System.out.println(map);
        return answer;
    }
}
