package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = Collections.emptyList();
//        return answer;
        List<String> names = new ArrayList<>(visitors);
        for (int i = 0; i < friends.size(); i++) {
            String name = friends.get(i).get(1);
            if (!user.equals(name)) {
                names.add(name);
                names.add(friends.get(i).get(0));
            }
            if (user.equals(name)) {
                names.removeAll(Collections.singleton(friends.get(i).get(0)));
            }
        }
        Set<String> set = new HashSet<String>(names);
        List<String> newNames =new ArrayList<String>(set);


        return newNames;
    }
}

/* 잠깐 보류
List<String> checkScore = new ArrayList<>();
        for (int j = 0; j < visitors.size(); j++) {
            String name = visitors.get(j);
            checkScore.add(name);

            for (int i = 0; i < friends.size(); i++) {
                String name2 = friends.get(i).get(1);
                if (!user.equals(name2)) {
                    checkScore.add(friends.get(i).get(0));
                    checkScore.add(name2);
                }
                if (user.equals(name2)) {
                    for (int q = 0; q < checkScore.size(); q++) {
                        checkScore.remove(friends.get(i).get(0));
                    }
                }
            }
        }
*/