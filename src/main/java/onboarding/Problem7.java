package onboarding;

import java.util.*;
import java.util.Map.Entry;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> KnowUser = new HashMap<>();
        Map<String, Integer> ScoreUser = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            String A_User = friends.get(i).get(0);
            String B_User = friends.get(i).get(1);

            if (KnowUser.containsKey(A_User)) {
                List<String> tmpUser = KnowUser.get(A_User);
                tmpUser.add(B_User);
                KnowUser.put(A_User, tmpUser);
            } else {
                List<String> tmpUser = new ArrayList<>();
                tmpUser.add(B_User);
                KnowUser.put(A_User, tmpUser);
            }

            if (KnowUser.containsKey(B_User)) {
                List<String> tmpUser = KnowUser.get(B_User);
                tmpUser.add(A_User);
                KnowUser.put(B_User, tmpUser);
            } else {
                List<String> tmpUser = new ArrayList<>();
                tmpUser.add(A_User);
                KnowUser.put(B_User, tmpUser);
            }
        }
        for (String str : KnowUser.get(user)) {
            for (String know : KnowUser.get(str)) {
                if (user.equals(know)) continue;
                if (ScoreUser.containsKey(know)) {
                    int tmpScore = ScoreUser.get(know);
                    ScoreUser.put(know, tmpScore + 10);
                } else ScoreUser.put(know, 10);
            }
        }
        for (String visitor : visitors) {
            if (KnowUser.get(user).contains(visitor)) continue;
            if (ScoreUser.containsKey(visitor)) {
                int tmpScore = ScoreUser.get(visitor);
                ScoreUser.put(visitor, tmpScore + 1);
            } else ScoreUser.put(visitor, 1);
        }
        System.out.println(KnowUser);
        System.out.println(ScoreUser);
        List<Entry<String,Integer>> UserList = new ArrayList<>(ScoreUser.entrySet());

        Collections.sort(UserList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Entry<String,Integer> entry : UserList) {
            answer.add(entry.getKey());
            if (answer.size()==5)  break;
        }
        return answer;
    }
}
