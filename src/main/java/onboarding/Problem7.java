package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.Iterator;
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
        //user의 value 0으로 수정
        map.put(user,0);

        //user의 친구들 value 0으로 수정
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),0);
        }

        List<Map.Entry<String, Integer>> list2 = new LinkedList<>(map.entrySet());
        Collections.sort(list2, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list2.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue()==0) continue;
            answer.add(entry.getKey());
        }
        if(answer.size()>5){
            answer=answer.subList(0,5);
        }
        return answer;
    }
}