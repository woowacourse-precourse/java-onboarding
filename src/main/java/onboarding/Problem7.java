package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> score = new HashMap<>();
        Map<String, List<String>> member = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            if(member.containsKey(friends.get(i).get(0))){
                List<String> list = member.get(friends.get(i).get(0));
                list.add(friends.get(i).get(1));
                member.replace(friends.get(i).get(0), list);
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(friends.get(i).get(1));
                member.put(friends.get(i).get(0), temp);
            }
            if(member.containsKey(friends.get(i).get(1))){
                List<String> list = member.get(friends.get(i).get(1));
                list.add(friends.get(i).get(0));
                member.replace(friends.get(i).get(1), list);
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(friends.get(i).get(0));
                member.put(friends.get(i).get(1), temp);            }
        }
        for (String s : member.keySet()) {
            score.put(s, 0);
        }
        for (String visitor : visitors) {
            score.put(visitor, 0);
        }
        for (Map.Entry<String, List<String>> entry : member.entrySet()) {
            if(entry.getValue().contains(user)){
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (entry.getValue().get(i) != user){
                        score.replace(entry.getValue().get(i),score.get(entry.getValue().get(i)) + 10);
                    }
                }
            }
        }
        for (String visitor : visitors) {
            score.replace(visitor, score.get(visitor) + 1);
        }
        for (Map.Entry<String, List<String>> entry : member.entrySet()) {
            if(entry.getValue().contains(user)){
                score.remove(entry.getKey());
            }
        }
        score.remove(user);
        List<Map.Entry<String , Integer>> entries = new LinkedList<>(score.entrySet());
        Collections.sort(entries, (((o1, o2) -> o1.getKey().compareTo(o2.getKey()))));
        Collections.sort(entries, ((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue() != 0){
                answer.add(entry.getKey());
            }
            if(cnt >= 4) break;
            cnt++;
        }
        return answer;
    }
}
