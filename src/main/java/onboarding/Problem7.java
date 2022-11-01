package onboarding;

//기능1. friends 리스트/배열에 있는 이름(key)과 점수10(value) 을 해시맵에 추가한다. 만약 friends 리스트/배열에 유저와 같은 이름이 있으면 해시맵에 넣지 않는다.
//기능2. 만약 해쉬맵에있는 이름이 있을경우 추가하지 않고 value에 10을 더한다.
//기능3. visitors 에 등장하는 친구들은 value에 +1 을 하고 key에 등록되지 않은 경우 등록하고 +1 한다.
//기능4. value 값이 높은 순으로 리스트에 정렬한다.
//기능5. 만약 점수가 같으면 알파벳 순으로 출력한다.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String,Integer> map = new HashMap<>();

        for (int i=0;i<friends.size();i++) {
            for (int j=0;j<2;j++) {
                if (!(friends.get(i).contains(user))) { //user 의 이름을 포함하지 않으면
                    if (map.containsKey(friends.get(i).get(j))) { //만약 이름이 이미 있으면
                        map.put((friends.get(i).get(j)), map.get((friends.get(i).get(j)))+10); //10을 더한다.
                    } else {
                        map.put((friends.get(i).get(j)), 10); //추가
                    }
                }
            }
        }

//        if (friends.get(2).contains("mrko")) {
//            System.out.println(1);
//        }
//        System.out.println(friends);


        System.out.println(map);

        return answer;
    }
}
