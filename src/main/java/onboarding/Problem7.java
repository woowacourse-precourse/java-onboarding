package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for(String visitor : visitors){
            if(!map.containsKey(visitor)){
                map.put(visitor, 1);
            }
            else{
                int cnt = map.get(visitor);
                map.put(visitor, ++cnt);
            }
        }

        for(List<String> list : friends){
            if(list.get(0).equals(user)){
                if(map.containsKey(list.get(1))){
                    map.remove(list.get(1));
                    continue;
                }
            }
            else if(list.get(1).equals(user)){
                if(map.containsKey(list.get(0))){
                    map.remove(list.get(0));
                    continue;
                }
            }
            if(!map.containsKey(list.get(0))){
                map.put(list.get(0), 0);
            }
            if(!map.containsKey(list.get(1))){
                map.put(list.get(1), 0);
            }
        }

        for(List<String> list : friends){
            if((!map.containsKey(list.get(0))) && (map.containsKey(list.get(1)))){
                int cnt = map.get(list.get(1));
                cnt += 10;
                map.put(list.get(1), cnt);
            }
            else if((!map.containsKey(list.get(1))) && (map.containsKey(list.get(0)))){
                int cnt = map.get(list.get(0));
                cnt += 10;
                map.put(list.get(0), cnt);
            }
        }

        List<String> keySetList = new ArrayList<>(map.keySet());

        Collections.sort(keySetList,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1)>map.get(o2)) { //1,2,3
                    return -1;
                }
                else if(map.get(o1)<map.get(o2)){
                    return 1;
                }
                else {
                    if(o1.compareTo(o2)<0) {
                        return -1;
                    }
                    return 1;
                }
            }
        });

        int cnt = 0;
        for(String key : keySetList) {
            answer.add(key);
            cnt++;
            if(cnt == 4) break;
        }

        return answer;
    }
}