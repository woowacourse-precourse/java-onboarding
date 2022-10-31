package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);
            List<String> tmp;

            if (hashMap.containsKey(a)) {
                tmp = hashMap.get(a);
            }

            else {
                tmp = new ArrayList<>();
            }
            tmp.add(b);
            hashMap.put(a, tmp);

            if (hashMap.containsKey(b)) {
                tmp = hashMap.get(b);
            }

            else {
                tmp = new ArrayList<>();
            }
            tmp.add(a);
            hashMap.put(b, tmp);
        }

        HashMap<String, Integer> tmpScore = new HashMap<>();
        List<String> userFriends = hashMap.get(user);
        for (String key : hashMap.keySet()) {
            if (!userFriends.contains(key) && !key.equals(user)) {
                int score = 0;
                List<String> curr = hashMap.get(key);
                for (int i = 0; i < curr.size(); i++) {
                    if (userFriends.contains(curr.get(i))) {
                        score += 10;
                    }
                }
                tmpScore.put(key, score);
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            String v = visitors.get(i);
            if (!userFriends.contains(v)) {
                if (tmpScore.containsKey(v)) {
                    int score = tmpScore.get(v);
                    tmpScore.put(v, ++score);
                }

                else {
                    tmpScore.put(v, 1);
                }
            }
        }

        List<Info> infoList = new ArrayList<>();
        for (String key : tmpScore.keySet()) {
            if (tmpScore.get(key) != 0) {
                Info info = new Info(key, tmpScore.get(key));
                infoList.add(info);
            }
        }
        Collections.sort(infoList);

        for (int i = 0; i < infoList.size(); i++) {
            answer.add(i, infoList.get(i).name);
        }

        return answer;
    }

    static class Info implements Comparable {
        String name = "";
        int score = 0;

        public Info(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Object o) {
            Info info = (Info) o;
            if (this.score > info.score) {
                return -1;
            }

            else if (this.score < info.score) {
                return 1;
            }

            else {
                return name.compareTo(info.name);
            }
        }
    }
}
