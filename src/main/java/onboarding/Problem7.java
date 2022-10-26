package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> u_friend = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                u_friend.add(friends.get(i).get(1));
                friends.remove(i);
            } else if (friends.get(i).get(1).equals(user)) {
                u_friend.add(friends.get(i).get(0));
                friends.remove(i);
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            for (int j = 0; j < u_friend.size(); j++) {
                if (visitors.get(i).equals(u_friend.get(j))) {
                    visitors.remove(i);
                }
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < u_friend.size(); j++) {
                if (friends.get(i).get(0).equals(u_friend.get(j))) {
                    String tmp = friends.get(i).get(1);
                    map.put(tmp, map.getOrDefault(tmp, 0) + 10);
                } else if (friends.get(i).get(1).equals(u_friend.get(j))) {
                    String tmp = friends.get(i).get(0);
                    map.put(tmp, map.getOrDefault(tmp, 0) + 10);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            String tmp = visitors.get(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        List<Integer> valueset = new ArrayList<>();
        for(String a: map.keySet()){
            valueset.add(map.get(a));
        }

        List<Integer> newList = valueset.stream().distinct().collect(Collectors.toList());

        for(Integer a: newList){
            List<String> tmp =new ArrayList<>();
            for(String b: map.keySet()){
                if(map.get(b)==a){
                    tmp.add(b);
                }
                Collections.sort(tmp);
            }
            for(String c:tmp){
                answer.add(c);
            }
        }

        return answer;
    }
}
