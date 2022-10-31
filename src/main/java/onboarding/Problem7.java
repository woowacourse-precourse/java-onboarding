package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> frFriends = new ArrayList<>();
        for(int i = 0 ; i < friends.size() ; i++){
            for(int j = 0 ; j < 2 ; j++){
                if(user ==friends.get(i).get(j)){
                    frFriends.add(friends.get(i).get(1-j));
                }
            }
        }
        while (frFriends.remove(null)) {        }
        for(int i = 0; i < frFriends.size(); i++){
            for(int j = 0 ; j < friends.size() ; j++){
                for(int k = 0 ; k < 2 ; k++){
                    if(frFriends.get(i) == friends.get(j).get(k)){
                        if(friends.get(j).get(1-k) == user){
                            break;
                        }
                        map.put(friends.get(j).get(1-k), map.getOrDefault(friends.get(j).get(1-k), 0) +10);
                    }
                }
            }
        }
        for(int i =0; i < visitors.size(); i++){
            if (!frFriends.contains(visitors.get(i))) {
                map.put(visitors.get(i), map.getOrDefault(visitors.get(i), 0) +1);
            }
        }
        List<String> answer = new ArrayList<>(sortValueBeforeKey(map));
        return answer;
    }

    public static  List<String> sortValueBeforeKey(HashMap<String, Integer> map){
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1).compareTo(map.get(o2)) == 0){
                    return o1.compareTo(o2);
                }
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        return keySet;
    }

    public static void main(String args[]){
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        System.out.println(solution(user , friends, visitors));
    }
}
