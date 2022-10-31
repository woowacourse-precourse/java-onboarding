package onboarding;

//1. user를 아는 friend_list 만들기
//2. user를 제외한 friends에 포함된 이름을 hashmap에 추가
//3. visitors에 포함된 이름을 hashmap에 추가
//4. hashmap을 리스트로 변환
//5. 리스트를 hashmap의 값을 기준으로 정렬(값이 같을 시 키를 기준으로 정렬)
//6. 리스트에 있는 값을 문제의 조건에 따라 answer에 추가 후 반환
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> friend_list = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        int idx;
        //1. user를 아는 friend_list 만들기
        //2. user를 제외한 friends에 포함된 이름을 hashmap에 추가
        for(int i = 0; i < friends.size(); i++)
        {
            //2. user를 제외한 friends에 포함된 이름을 hashmap에 추가
            map.put(friends.get(i).get(0), 0);
            map.put(friends.get(i).get(1), 0);
            //1. user를 아는 friend_list 만들기
            if(friends.get(i).contains(user))
            {
                idx = friends.get(i).indexOf(user);
                friend_list.add(friends.get(i).get(1 - idx));
                //2. user를 제외한 friends에 포함된 이름을 hashmap에 추가
                map.put(friends.get(i).get(1 - idx), map.get(friends.get(i).get(1 - idx)) - 20000);
            }
        }
        map.remove(user);
        return answer;
    }
}
