package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        Map<String,List<String>> friendMap = new HashMap<>();
        Map<String,Integer> score = new HashMap<>();
        for(int i=0; i<friends.size();i++){   //hashmap 초기
            if (friendMap.containsKey(friends.get(i).get(0)) == false) {
                List<String> friendList = new ArrayList<>();
                friendList.add(friends.get(i).get(1));
                friendMap.put(friends.get(i).get(0), friendList);
            } else if (friendMap.containsKey(friends.get(i).get(0)) == true) {
                friendMap.get(friends.get(i).get(0)).add(friends.get(i).get(1));
            }

            if (friendMap.containsKey(friends.get(i).get(1)) ==false){
                List<String> friendList = new ArrayList<>();
                friendList.add(friends.get(i).get(0));
                friendMap.put(friends.get(i).get(1),friendList);
            }
            else if (friendMap.containsKey(friends.get(i).get(1)) ==true){
                friendMap.get(friends.get(i).get(1)).add(friends.get(i).get(0));
            }
            score.put(friends.get(i).get(0),0);
            score.put(friends.get(i).get(1),0);
        }
        for (int i = 0;i< visitors.size();i++){
            if (score.containsKey(visitors.get(i)) == true) {

                if (friendMap.get(user).contains(visitors.get(i))) { //사용자의 친구라면
                    //자기의 찬구들에게 10점씩 주기
                    for(int idx = 0; idx<friendMap.get(visitors.get(i)).size();idx++){
                        if (friendMap.get(visitors.get(i)).get(idx) != user) {
                            score.put(friendMap.get(visitors.get(i)).get(idx), score.get(friendMap.get(visitors.get(i)).get(idx)) + 10);
                        }
                    }
                }
                //방문자가 사용자의 친구의 친구라면
                else if (check(friendMap,visitors.get(i),user)==1){
                    score.put(visitors.get(i), score.get(visitors.get(i)) + 10);
                }
                //아무런 관계가 아닌 사람
                else {
                    score.put(visitors.get(i), score.get(visitors.get(i)) + 1);
                }
            }
            else{  //score 새로만들기
                score.put(visitors.get(i),1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int cnt = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            if (cnt ==5 || entry.getValue()==0) {
                break;
            }
            answer.add(entry.getKey());
            cnt++;
        }
        return answer;
    }
    public static  int check(Map<String,List<String>> map,String visitor,String user){//친구의 친구인지 확인하는 함수
       int mapsize = 0;
        if (map.containsKey(visitor)){
            mapsize = map.get(visitor).size();
        }
        else {
            return  0;
        }
      for (int idx =0 ; idx<mapsize;idx++) {
         String tmp = map.get(visitor).get(idx);
         for (int i =0; i<map.get(tmp).size();i++){
             if (map.get(tmp).get(i).contains(user)){
                 return 1;
             }
         }
      }
        return 0;
    }
}
