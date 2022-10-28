package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //친구 관계를 저장할 HashMap선언.
        //key값으로 아이디, value는 해당 아이디와 친구인 아이디 리스트(arrayList)
        HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

        for(List<String> list : friends){
            //리스트(id1, id2) 친구관계를 hashMap에 추가한다.
            //첫번째 id의 친구 리스트에 두번째 id를 넣는다.
            ArrayList<String> temp;
            if(hashMap.containsKey(list.get(0)))
                temp = hashMap.get(list.get(0));
            else
                temp = new ArrayList<>();
            temp.add(list.get(1));
            hashMap.put(list.get(0), temp);

            //두번째 id의 친구 리스트에 첫번째 id를 넣는다.
            if(hashMap.containsKey(list.get(1)))
                temp = hashMap.get(list.get(1));
            else
                temp = new ArrayList<>();
            temp.add(list.get(0));
            hashMap.put(list.get(1), temp);
        }

        

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
