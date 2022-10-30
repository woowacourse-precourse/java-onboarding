package onboarding;

import java.util.*;

class Sns {
    public String user;
    public int score;

    public Sns(String user, int score) {
        this.user = user;
        this.score = score;
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        //user 친구 찾기
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                list.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                list.add(friends.get(i).get(0));
            }
        }
        System.out.println(list);

        // user 친구의 친구 찾기
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(friends.get(i).get(0).equals(list.get(j))){
                     if(!friends.get(i).get(1).equals(user)){
                         map.put(friends.get(i).get(1), 10);
                     }
                }else if(friends.get(i).get(1).equals(list.get(j))) {
                    if (!friends.get(i).get(0).equals(user)) {
                        map.put(friends.get(i).get(0), 10);
                    }
                }
            }
        }

        //visitor

        for (int i = 0; i < visitors.size(); i++) {
            if(!map.containsKey(visitors.get(i))){
                map.put(visitors.get(i), 1 );
            }else{

            }
        }





        System.out.println(map.entrySet());


        return answer;
    }
}
