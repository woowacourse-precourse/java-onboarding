package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> bfList = new ArrayList<>();

        HashMap<String, Integer> rc = new HashMap<>();

        // user의 친구 찾기
        for (int i=0; i<friends.size(); i++) {
            boolean check = friends.get(i).contains(user);
            if (check == true) {
                for (int j = 0; j < 2; j++) {
                    String name = friends.get(i).get(j);
                    if (name != user) {
                        bfList.add(name);
                        break;
                    }
                }
            }
        }

        // 친구의 친구들 +10 (친구의 친구 중 user 제외하기)
        for (int i=0; i<friends.size(); i++){
            for (int j=0; j<bfList.size(); j++){
                boolean check = friends.get(i).contains(bfList.get(j));
                if (check == true){
                    for( int k=0; k<2; k++){
                        String name = friends.get(i).get(k);
                        if (name != bfList.get(j) && name != user){
                            if (rc.get(name) == null) rc.put(name, 10);
                            else rc.replace(name, rc.get(name)+10);
                        }
                    }
                }
            }
        }

        // 방문객들 중에 user의 친구 제외하고 +1
        for(int i=0; i<visitors.size(); i++){
            String name = visitors.get(i);
            boolean check = bfList.contains(name);
            if (check == false){
                if (rc.get(name) == null) rc.put(name, 1);
                else rc.replace(name, rc.get(name)+1);
            }
        }

        // HashMap에 있는 값 최대 5명까지 자르고 값이 같으면 이름순
        List<String> keySetList = new ArrayList<>(rc.keySet());
        Collections.sort(keySetList, (o1, o2) -> (rc.get(o2).compareTo(rc.get(o1))));
        for(String key: keySetList){
            answer.add(key);
        }

        return answer;
    }
}
