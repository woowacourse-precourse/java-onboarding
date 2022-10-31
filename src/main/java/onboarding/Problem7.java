package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //List<String> answer = Collections.emptyList();
        HashSet<String> friend = new HashSet<>();
        HashMap<String, Integer> rec = new HashMap<>();
        for(int i = 0; i < friends.size(); i++){
            if (Objects.equals(friends.get(i).get(0), user)){
                friend.add(friends.get(i).get(1));
            }
            else if (Objects.equals(friends.get(i).get(1), user)){
                friend.add(friends.get(i).get(0));
            }
        }
        for(int i = 0; i < friends.size(); i++) {
            if ((Objects.equals(friends.get(i).get(0), user)) || (Objects.equals(friends.get(i).get(1), user))) {
                continue;
            }
            if (friend.contains(friends.get(i).get(0))) {
                if (rec.containsKey(friends.get(i).get(1))) {
                    rec.put(friends.get(i).get(1), rec.get(friends.get(i).get(1)) + 10);
                } else {
                    rec.put(friends.get(i).get(1), 10);
                }
            } else if (friend.contains(friends.get(i).get(1))) {
                if (rec.containsKey(friends.get(i).get(0))) {
                    rec.put(friends.get(i).get(0), rec.get(friends.get(i).get(0)) + 10);
                } else {
                    rec.put(friends.get(i).get(0), 10);
                }
            }
        }
        for (int i = 0; i < visitors.size(); i++){
            if (rec.containsKey(visitors.get(i))){
                rec.put(visitors.get(i), rec.get(visitors.get(i)) + 1);
            }
            else{
                if (!friend.contains(visitors.get(i))) {
                    rec.put(visitors.get(i), 1);
                }
            }
        }
        List<String> answer = new ArrayList<>(rec.keySet());
        Collections.sort(answer, (o1, o2) -> (rec.get(o2).compareTo(rec.get(o1))));
        return answer;
    }
}
