package onboarding;

import java.sql.Array;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> relation = new HashMap<>();
        HashMap<String, Integer> score = new HashMap<>();
        for (List<String> friend : friends) {
            /* Hashmap value의 값이 null이면 새로 Arraylist를 만들어 추가하고 null이 아니라면 추가만 한다. */
            relation.computeIfAbsent(friend.get(0), k -> new ArrayList<>()).add(friend.get(1));
            relation.computeIfAbsent(friend.get(1), k -> new ArrayList<>()).add(friend.get(0));
        }

        for (String key : relation.keySet()) {
            /* 앞에 !를 붙이면 not의 의미를 지니는 듯.*/
            if(!Objects.equals(key, user) && !relation.get(key).contains(user)){
                for (String bridge : relation.get(key)){
                    if(relation.get(user).contains(bridge)){
                        /* k는 얻다 쓰는건지 잘 모르겠다.. */
                        score.computeIfAbsent(key, k-> 0);
                        score.put(key, score.get(key)+10);
                    }
                }
            }
        }

        for (String visitor : visitors){
            if (!relation.get(user).contains(visitor)){
                score.computeIfAbsent(visitor, k -> 0);
                score.put(visitor, score.get(visitor)+1);
            }
        }
        /* Hashmap value에 대해 sort */
        /* entrySet()는 Hashmap의 key, value를 모두 가져오는 method. */
        /* 이를 LinkedList로 받은 이유는 인덱스 이동이 빨라서인듯..? */
        /* sort lambda는 아래와 같이 표현할 때 score hashmap의 value에 대해 오름차순, 반대로 쓰면 내림차순. */
        List<String> result = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        entryList.sort(((o1, o2) -> score.get(o2.getKey()) - score.get(o1.getKey())));
        for(int i = 0; i < 5; i++){
            if (i >= entryList.size()){
                continue;
            }
            result.add(entryList.get(i).getKey());
        }
        return result;
    }
}