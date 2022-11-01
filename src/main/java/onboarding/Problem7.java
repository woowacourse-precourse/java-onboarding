package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, Integer> score = new HashMap<>();

        for(int i = 0; i < friends.size(); i++){
            if(map.containsKey(friends.get(i).get(0))) {
                ArrayList<String> arr = new ArrayList<>();
                arr = map.get(friends.get(i).get(0));
                arr.add(friends.get(i).get(1));
                map.put(friends.get(i).get(0), arr);
            }
            else{
                ArrayList<String> arr = new ArrayList<>();
                arr.add(friends.get(i).get(1));
                score.put(friends.get(i).get(0), 0);
                map.put(friends.get(i).get(0), arr);
            }
            if(map.containsKey(friends.get(i).get(1))){
                ArrayList<String> arr = new ArrayList<>();
                arr = map.get(friends.get(i).get(1));
                arr.add(friends.get(i).get(0));
                map.put(friends.get(i).get(1), arr);
            }
            else{
                ArrayList<String> arr = new ArrayList<>();
                arr.add(friends.get(i).get(0));
                score.put(friends.get(i).get(1), 0);
                map.put(friends.get(i).get(1), arr);
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        arr = map.get(user);
        score.replace(user, -10);
        for(String str : arr){
            score.replace(str, -10);
            ArrayList<String> a = map.get(str);
            for(String str1 : a) {
                if(score.get(str1) == -10)
                    continue;
                int s = score.get(str1) + 10;
                score.replace(str1, s);
            }
        }
        for(String str : visitors){
            if(score.containsKey(str)) {
                if(score.get(str) == -10)
                    continue;
                int s = score.get(str) + 1;
                score.replace(str, s);
            }
            else{
                score.put(str, 1);
            }
        }
        List<String> keySetList = new ArrayList<>(score.keySet());
        Collections.sort(keySetList, (o1, o2) -> (score.get(o2).compareTo(score.get(o1))));


        int cnt = 0;
        for(String key : keySetList){
            if(score.get(key) <= 0 || cnt >= 5) {
                break;
            }
            cnt++;
            answer.add(key);
        }

        return answer;
    }
}
