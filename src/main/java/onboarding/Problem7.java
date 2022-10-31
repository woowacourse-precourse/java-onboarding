package onboarding;

import java.util.Collections;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Set<String>> hm = new HashMap<>();
        HashMap<String, Integer> point = new HashMap<>();



        for(int i = 0; i < friends.size(); i++)
        {
            String f1 = friends.get(i).get(0);
            String f2 = friends.get(i).get(1);

            if(!hm.containsKey(f1)) hm.put(f1, new HashSet<>());
            if(!hm.containsKey(f2)) hm.put(f2, new HashSet<>());

            hm.get(f1).add(f2);
            hm.get(f2).add(f1);
        }

        for(var person1: hm.keySet())
        {
            if(person1.equals(user)) continue;
            if(hm.get(user).contains(person1)) continue;

            int count = 0;
            for(var person2: hm.get(person1)) if(hm.get(user).contains(person2)) count++;

            point.put(person1, count*10);
        }

        for(var person: visitors)
        {
            if(hm.get(user).contains(person)) continue;
            if(!point.containsKey(person)) { point.put(person, 1); continue; }
            point.replace(person, point.get(person) + 1);
        }

        List<String> answer = new ArrayList<>(point.keySet());
        Collections.sort(answer, (o1, o2) -> {
            if(point.get(o2) > point.get(o1)) return 1;
            if(point.get(o2) == point.get(o1)) return o1.compareTo(o2);
            return -1; });

        List<String> answer2 = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < answer.size(); i++)
        {
            if(count == 5) break;
            if(point.get(answer.get(i)) == 0) break;

            answer2.add(answer.get(i));
            count++;
        }

        return answer2;
    }
}