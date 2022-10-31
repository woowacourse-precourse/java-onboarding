package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> m = new HashMap<>();
        List<String> close = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> s = friends.get(i);
            if (!m.containsKey(s.get(0))){
                m.put(s.get(0), 0);
            }
            if (!m.containsKey(s.get(1))){
                m.put(s.get(1), 0);
            }

            if (s.get(0) == user) {
                close.add(s.get(1));
            }
            if (s.get(1) == user) {
                close.add(s.get(0));
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (!m.containsKey(visitors.get(i))) {
                m.put(visitors.get(i), 0);
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            m.put(visitors.get(i), m.get(visitors.get(i)) + 1);
        }

        for (int i = 0; i < friends.size(); i++) {
            List<String> s = friends.get(i);

            for (int j = 0; j < close.size(); j++) {
                if (Arrays.asList(s).contains(close.get(j))) {
                    int idx = s.indexOf(close.get(j));
                    if (idx == 0) m.put(s.get(1), m.get(s.get(1))+ 10);
                    if (idx == 1) m.put(s.get(0), m.get(s.get(0))+ 10);
                }

            }
        }

        m.remove(user);
        for (int i = 0; i < close.size(); i++) {
            m.remove(close.get(i));
        }

        List<String> keySetList = new ArrayList<>(m.keySet());

        Collections.sort(keySetList, (o1, o2) -> (m.get(o2).compareTo(m.get(o1))));

        List<String> keySetList2 = new ArrayList<>(m.keySet());


        return keySetList2;
    }

}