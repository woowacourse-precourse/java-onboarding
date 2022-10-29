package onboarding;

import java.util.*;


public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        ArrayList<String> Friends = new ArrayList<>();
        answer = new ArrayList<String>();
        Map<String, Integer> map = new TreeMap<>();
        for (int k=0; k<friends.size(); k++){
            if (friends.get(k).get(0) == user) {
                Friends.add(friends.get(k).get(1));
            }
            if (friends.get(k).get(1) == user){
                Friends.add(friends.get(k).get(0));
            }
        }
        System.out.println(Friends);

        for (int j=0; j<visitors.size(); j++){
            if (map.containsKey(visitors.get(j))){
                int value = map.get(visitors.get(j));
                map.replace(visitors.get(j), value+1);
            }
            else{
                if (!Friends.contains(visitors.get(j))) {
                    map.put(visitors.get(j), 1);
                }
            }
        }
        System.out.println(map);
        List<String> keySet = new ArrayList<>(map.keySet());

        answer = keySet;
        return answer;
    }
}