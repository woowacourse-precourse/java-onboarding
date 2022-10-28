package onboarding;

import java.sql.Array;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 1. map으로 user, friends 분리시켜
        Map<String, String> friendsMap = new LinkedHashMap<>();
        for (int i =0; i<friends.size(); i++){
            friendsMap.put(friends.get(i).get(0), friends.get(i).get(1));
        }


        // 6. 단, 리스트 0번에있는 애는 제외시켜
        Set friendsSet  =addfrieds(friendsMap,user);// andole, jun

        // 4. 방문자를  +1



        // 5. 리스트에  있어 +10

        List<String> answer = Collections.emptyList();
        return answer;
    }


    public static LinkedList<String> friendsList(Map<String,String> map , String users){
        // 2. value값에 mrko가 있으면 그 key값에 해당하는 리스트를 하나 만들어

        //LinkedList<LinkedList<String>> friends = new LinkedList<LinkedList<String>>();
        LinkedList<String> friends = new LinkedList<String>();

        for (Map.Entry<String, String> pair : map.entrySet()) {
            String s = pair.getValue();
            String ss = pair.getKey();
            if(s.equals(users)) friends.add(ss); // shakevan, donut
        }

        // 3. 이 리스트 이후에는 인덱스 0번의 친구들을 저장해


        return friends;
    }


    public static Set addfrieds(Map<String,String> map , String users, List<String> visitors){
        LinkedList<String> friends =  friendsList(map,users); // shakevan, donut
        Set friendsSet = new HashSet();
        int count =0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String userFriends = friends.get(count++);
            String s = pair.getValue();
            String ss = pair.getKey();
            if(s.equals(userFriends)) friendsSet.add(ss); // andole, jun
        }
        for(int j =0; j<visitors.size();j++){ //bedi", "bedi", "donut", "bedi", "shakevan"

        }

        return friendsSet;
    }





}
