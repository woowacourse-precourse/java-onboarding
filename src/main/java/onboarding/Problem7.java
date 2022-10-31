package onboarding;

import java.util.*;

public class Problem7 {
    private static final HashMap<String, LinkedList<String>> relation = new HashMap<>();
    private static final HashMap<String, Integer> score = new HashMap<>();
    private static final List<String> answer = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        for(List<String> list : friends){
            String name1 = list.get(0);
            String name2 = list.get(1);
            if(relation.containsKey(name1)){
                relation.get(name1).add(name2);
            } else {
                relation.put(name1, new LinkedList<String>(Collections.singleton(name2)));
                score.put(name1, 0);
            }

            if(relation.containsKey(name2)){
                relation.get(name2).add(name1);
            } else {
                relation.put(name2, new LinkedList<String>(Collections.singleton(name1)));
                score.put(name2, 0);
            }
        }

        for(String friend : relation.get(user)){
            for(String name : relation.get(friend)){
                if(!name.equals(user)) score.replace(name, score.get(name) + 10);
            }
        }

        for(String visitor : visitors){
            if(relation.get(user).contains(visitor)) continue;
            if(score.containsKey(visitor)){
                score.replace(visitor, score.get(visitor) + 1);
            }else{
                score.put(visitor, 1);
            }
        }

        List<Map.Entry<String, Integer>> list_entries = new ArrayList<>(score.entrySet());
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(int i = 0; i < 5; i++){
            if(list_entries.get(i).getValue() == 0) return answer;
            answer.add(list_entries.get(i).getKey());
        }
        return answer;
    }
}