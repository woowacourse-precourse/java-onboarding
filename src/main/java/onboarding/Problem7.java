package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        // #1
        List<String> user_friends = new ArrayList<>();

        // de_friends = Clone friends (중복 제거), Not friends, Enable Recommend
        HashSet<String> de_friends = new HashSet<>();
        for(List<String> s : friends) de_friends.addAll(s);
        de_friends.remove(user);

        String temp = "";

        for(int i = 0; i < friends.size(); i++) {
            // left side
            if(user == friends.get(i).get(0)) {
                temp = friends.get(i).get(1);
                de_friends.remove(temp);
                user_friends.add(temp);
            }
            // right side
            else if(user == friends.get(i).get(1)) {
                temp = friends.get(i).get(0);
                de_friends.remove(temp);
                user_friends.add(temp);
            }
        }

        // #2
        HashSet<String> all_user = new HashSet<>(); // All SNS Users
        List<String> together = new ArrayList<>(); // 함께 아는 친구 목록

        for(int i = 0; i < friends.size(); i++) {
            for(int j = 0; j < 2; j++) {
                temp = friends.get(i).get(j);
                all_user.add(temp);
            }
        }
        // Add Visitors
        for(int i = 0; i < visitors.size(); i++) {
            temp = visitors.get(i);
            all_user.add(temp);
        }

        // #2-1 de_friends and user_friends
        for(int i = 0; i < 	friends.size(); i++) {
            for(String name : de_friends) {
                if(name == friends.get(i).get(0)) {
                    temp = friends.get(i).get(0);
                    together.add(temp);
                }
                if(name == friends.get(i).get(1)) {
                    temp = friends.get(i).get(1);
                    together.add(temp);
                }
            }
        }

        // #3. together, score
        // #3-1 Make score table
        HashMap<String, Integer> score = new HashMap<String, Integer>();
        String users;
        Iterator iterator = all_user.iterator();

        while (iterator.hasNext()) {
            users = (String) iterator.next();
            score.put(users, 0);
        }

        int sum;
        for(int i = 0; i < together.size(); i++) {

            for(String t : de_friends) {
                if(together.get(i) == t) {
                    sum = score.get(t);
                    sum += 10;
                    score.put(t, sum);
                }
            }
        }

        // #4. Visitors score
        for(String v : visitors) {
            if(score.containsKey(v)) {
                sum = score.get(v);
                sum++;
                score.put(v, sum);
            }
        }

        // #4-1 user or friends >> Remove score list
        if(score.containsKey(user)) score.remove(user);
        for(int i = 0; i < user_friends.size(); i++) {
            temp = user_friends.get(i);
            if(score.containsKey(temp)) score.remove(temp);
        }

        // #5. 점수별로 정렬 (sort)
        List<Map.Entry<String, Integer>> results = new ArrayList<Map.Entry<String, Integer>>(score.entrySet());
        Collections.sort(results, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2)
            {
                // 내림 차순 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        for(Map.Entry<String, Integer> entry : results) {
            if(entry.getValue() > 0 ){
                answer.add(entry.getKey());
            }
        }

        return answer;
    }
}
