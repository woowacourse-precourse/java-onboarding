package onboarding;

import java.util.Collections;
import java.util.*;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> relations = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();

        for(int i = 0; i < friends.size(); i++){
            String temp1 = friends.get(i).get(0);
            String temp2 = friends.get(i).get(1);

            if(!score.containsKey(temp1) && temp1 != user){
                score.put(temp1, 0);
            }
            if (!score.containsKey(temp2) && temp2 != user){
                score.put(temp2, 0);
            }

            if(relations.containsKey(temp1)){
                List<String> temp = relations.get(temp1);
                temp.add(temp2);
                relations.put(temp1, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(temp2);
                relations.put(temp1, temp);
            }

            if(relations.containsKey(temp2)){
                List<String> temp = relations.get(temp2);
                temp.add(temp1);
                relations.put(temp2, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(temp1);
                relations.put(temp2, temp);
            }
        }

        List<String> check = relations.get(user);

        Iterator<String> keys = relations.keySet().iterator();
        while(keys.hasNext()){

            String key = keys.next();

            if(key == user) continue;

            List<String> values = relations.get(key);
            for(int i = 0; i < values.size(); i++){
                for(int j = 0; j < check.size(); j++){
                    if (Objects.equals(values.get(i), check.get(j))) {
                        int nowScore = score.get(key);
                        score.put(key, nowScore += 10);
                    }
                }
            }
        }

        for(int i = 0; i < visitors.size(); i++){
            if(Objects.equals(visitors.get(i), user)) continue;
            if(score.containsKey(visitors.get(i))){
                int nowScore = score.get(visitors.get(i));
                score.put(visitors.get(i), nowScore+=1 );
            } else {
                score.put(visitors.get(i), 1);
            }
        }

        for(int i = 0; i < check.size(); i++){
            score.remove(check.get(i));
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int num = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            if(num == 5 || entry.getValue() == 0) break;
            answer.add(entry.getKey());
            num++;
        }

        return answer;
    }
}
