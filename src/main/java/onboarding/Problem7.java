package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<String>();
        int friends_len = friends.size();
        HashMap<String, List<String>> dictionary = new HashMap<String, List<String>>();
        HashMap<String, Integer> name_score = new HashMap<String, Integer>();

        // 유저의 친구관계 정리. 유저의 이름, 추천 점수를 담는 HashMap에 대한 초기화.
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

        // 사용자와 함께 아는 친구의 수에 대한 추천 점수 계산
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

        // 사용자의 타임 라인에 방문한 횟수에 대한 계산
        int num_visitors = visitors.size();
        for (int i = 0; i < num_visitors; i++) {
            String visitor = visitors.get(i);
            if (name_score.containsKey(visitor)) {
                int visitor_score = name_score.get(visitor);
                name_score.put(visitor, visitor_score + 1);
            } else {
                name_score.put(visitor, 1);
            }
        }

        // 점수가 가장 높은 순으로 정렬하기 전에, 동점일 때엔 이름순으로 정렬해야 하므로, 먼저 이름에 따라서 정렬.
        SortedMap<String, Integer> sorted_name_score = new TreeMap<String, Integer>(name_score);

        // 추천 점수가 sorted_name_score에서 value로 들어있기에, 이에 따라서 정렬하기 위해 list에 value값들 삽입.
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sorted_name_score.entrySet()) {
            list.add(entry.getValue());
        }

        // value값에 대한 정렬.
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        LinkedHashMap<String, Integer> answerMap = new LinkedHashMap<>();
        for (Integer i : list) {
            for (Map.Entry<String, Integer> entry : sorted_name_score.entrySet()) {
                if (entry.getValue().equals(i)) {
                    answerMap.put(entry.getKey(), i);
                }
            }
        }

        // 높은 순으로 3명을 answer list에 추가. 다만, answerMap에는 user 본인에 대한 정보도 포함되어 있어서, 이에 대한 정보를 제외함.
        int countdown = 3;
        for (int i = 0; i < answerMap.size(); i++) {
            Object o = answerMap.keySet().toArray()[i];
            if (o.equals(user)) {
                continue;
            } else {
                answer.add((String) o);
                countdown -= 1;
            }
            if (countdown == 0) {
                break;
            }
        }
        return answer;
    }
}
