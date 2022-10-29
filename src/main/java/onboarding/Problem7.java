package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer=new ArrayList<>();
        final int LENGTH=friends.size();

        //사용자의 친구 리스트 생성
        ArrayList list=new ArrayList();

        for(int i=0;i<LENGTH;i++) {
            if (friends.get(i).get(0).equals(user)) {
                list.add(friends.get(i).get(1));
            }else if (friends.get(i).get(1).equals(user)) {
                list.add(friends.get(i).get(0));
            }
        }
        //추천 친구 후보 Map 생성
        HashMap map=new HashMap();
        //Map 초기화
        for(int i=0;i<LENGTH;i++){
            map.put(friends.get(i).get(0),0);
            map.put(friends.get(i).get(1),0);
        }
        for(int i=0;i<visitors.size();i++){
            map.put(visitors.get(i),0);
        }

        //10점씩 부여
        for(int i=0;i<LENGTH;i++){
            for(int j=0;j<list.size();j++) {
                if (friends.get(i).contains(list.get(j))) {
                    map.put(friends.get(i).get(0),(Integer)map.get(friends.get(i).get(1))+10);
                    map.put(friends.get(i).get(1),(Integer)map.get(friends.get(i).get(0))+10);
                }
            }
        }
        //1점씩 부여
        for(int i=0;i<visitors.size();i++){
            map.put(visitors.get(i),(Integer)map.get(visitors.get(i))+1);
        }
        return answer;
    }
}