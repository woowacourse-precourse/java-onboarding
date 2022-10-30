package onboarding;

import java.util.*;

public class Problem7 {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<String>();
        int friends_len = friends.size();
        HashMap<String, List<String>> dictionary = new HashMap<String, List<String>>();
//        Map<String, List<String>> dictionary = Collections.synchronizedMap(new TreeMap<String, List<String>>());
        HashMap<String, Integer> name_score = new HashMap<String, Integer>();

        for (int i = 0; i < friends_len; i++) {
            String f1 = friends.get(i).get(0);
            if (!dictionary.containsKey(f1)) dictionary.put(f1, new ArrayList<String>());
            name_score.put(f1, 0);

            String f2 = friends.get(i).get(1);
            if (!dictionary.containsKey(f2)) dictionary.put(f2, new ArrayList<String>());
            name_score.put(f2, 0);

            dictionary.get(f1).add(f2);
            dictionary.get(f2).add(f1);
        }

        List<String> users_friends = dictionary.get(user);

        int user_friend_cnt = users_friends.size();
        for (int i = 0; i < user_friend_cnt; i++) {
            List<String> dummy = dictionary.get(users_friends.get(i));
            int dummy_len = dummy.size();
            for (int j = 0; j < dummy_len; j++) {
                int next_score = name_score.get(dummy.get(j)) + 10;
                name_score.put(dummy.get(j), next_score);
            }
        }

        int num_visitors = visitors.size();
        for (int i = 0; i < num_visitors; i++) {
            String visitor = visitors.get(i);
            if (name_score.containsKey(visitor)) {
                int visitor_score = name_score.get(visitor);
                name_score.put(visitor, visitor_score + 1);
            }
            else {
                name_score.put(visitor, 1);
            }

        }
        SortedMap<String, Integer> sorted_name_score = new TreeMap<String, Integer>(name_score);
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : sorted_name_score.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        LinkedHashMap<String, Integer> answerMap = new LinkedHashMap<>();
        for(Integer i : list) {
            for(Map.Entry<String, Integer> entry : sorted_name_score.entrySet()) {
                if(entry.getValue().equals(i)) {
                    answerMap.put(entry.getKey(), i);
                }
            }
        }
        System.out.println("answerMap = " + answerMap);
        int countdown = 3;
        for (int i = 0; i < answerMap.size(); i++) {
            Object o = answerMap.keySet().toArray()[i];
            if(o.equals(user)) {
                continue;
            }
            else {
                answer.add((String) o);
                countdown -= 1;
            }
            if(countdown == 0) {
                break;
            }
        }
        return answer;
    }
}
