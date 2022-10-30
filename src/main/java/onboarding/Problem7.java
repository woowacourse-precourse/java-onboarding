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
        for (int i=0; i<friends.size(); i++){
            if (Friends.contains(friends.get(i).get(0)) && friends.get(i).get(1)!=user) {
                if (map.containsKey(friends.get(i).get(1))){
                    int value = map.get(friends.get(i).get(1));
                    map.replace(friends.get(i).get(1), value+10);
                }
                else{
                    map.put(friends.get(i).get(1), 10);
                }
            }
            else if (Friends.contains(friends.get(i).get(1)) && friends.get(i).get(1)!=user) {
                if (map.containsKey(friends.get(i).get(0))){
                    int value = map.get(friends.get(i).get(0));
                    map.replace(friends.get(i).get(0), value+10);
                }
                else{
                    map.put(friends.get(i).get(0), 10);
                }
            }
        }
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
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            public int compare(String o1, String o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        int num=0;
        for (int i=0; i<keySet.size(); i++){
            if (Friends.contains(keySet.get(i)) || keySet.get(i) == user ){
                continue;
            }
            else {
                answer.add(keySet.get(i));
                num+=1;
            }
            if (num==5){
                break;
            }
        }
        return answer;
    }
}