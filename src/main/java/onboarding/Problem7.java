package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> score = new HashMap<>(); //친구와,점수로 계산하기

        List<String> friends_list = friends_list(user, friends); //친구목록 구하는 함수

        //1점을 얻는 친구들
        for (String visit : visitors) {
            if (!friends_list.contains(visit)){
                score.put(visit,score.getOrDefault(visit,0)+1);
            }

        }

        //10점을 얻는 친구들
        for (List<String> friend : friends) {
            if (friends_list.contains(friend.get(0)) && (!friends_list.contains(friend.contains(1)))) {
                score.put(friend.get(1),score.getOrDefault(friend.get(1), 0) + 10);
            }
            if (friends_list.contains(friend.get(1)) && (!friends_list.contains(friend.contains(0)))) {
                score.put(friend.get(0),score.getOrDefault(friend.get(0), 0) + 10);
            }
        }


        //score map 정렬
        score.remove(user);
        List<String> sort_list = new ArrayList<>();

        List<Map.Entry<String, Integer>> list = new LinkedList<>(score.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> object1, Map.Entry<String, Integer> object2) {
                int compare_result = (object1.getValue() - object2.getValue()) * -1;
                return compare_result == 0 ? object1.getKey().compareTo(object2.getKey()) : compare_result;
            }
        });
        int num = 0;
        for(String key : score.keySet()) {
            Integer value = score.get(key);
            if(value == 0 || num == 5) {
                continue;
            } else {
                sort_list.add(key);
                num++;
            }
        }


        return sort_list;
    }
    //user의 친구 목록(중복X,본인X)
    public static List<String> friends_list(String user, List<List<String>> friends) {
        List<String> friends_list = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0)==user) {
                friends_list.add(friend.get(1));
            } else if (friend.get(1)==user) {
                friends_list.add(friend.get(0));
            }
        }
        friends_list.remove(user);
        return friends_list;
    }


}
