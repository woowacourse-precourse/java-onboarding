package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7{
    public static ArrayList<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> friend = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(0).equals(user)){
                friend.add(friends.get(i).get(1));
                //friends.remove(i);
            }
            else if(friends.get(i).get(1).equals(user)){
                friend.add(friends.get(i).get(0));
                //friends.remove(i);
            }
            else{
                map.put(friends.get(i).get(0),0);
                map.put(friends.get(i).get(1),0);

            }
        }
        for(int i=0;i<friends.size();i++){


            if (friend.contains(friends.get(i).get(0))&& !friends.get(i).get(1).equals(user)) {
                int tmp = map.get(friends.get(i).get(1));
                map.put(friends.get(i).get(1), tmp + 10);
            }
            if (friend.contains(friends.get(i).get(1))&& !friends.get(i).get(0).equals(user)) {
                int tmp = map.get(friends.get(i).get(0));
                map.put(friends.get(i).get(0), tmp + 10);
            }

        }
        for(int i=0;i<visitors.size();i++){
            if(map.containsKey(visitors.get(i))){
                int tmp = map.get(visitors.get(i));
                map.put(visitors.get(i),tmp+1);
            }
            else{
                map.put(visitors.get(i),1);
            }
        }
        // Map.Entry 리스트 작성
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

        // 비교함수 Comparator를 사용하여 내림 차순으로 정렬
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                // 내림 차순으로 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        for(Entry<String, Integer> entry : list_entries) {
            if(!friend.contains(entry.getKey())){
                answer.add(entry.getKey());
            }
        }
        return answer;
    }
}
