package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> resultList = new ArrayList<String>();
        Set<String> set = new HashSet<String>(); // 추천 친구 목록
        Set<String> friendSet = new HashSet<String>(); //이미 친구인 목록
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        //친구 목록 추출
        for(List<String> friends_ : friends)
        {

            set.add(friends_.get(0));
            set.add(friends_.get(1));
        }
        for(String visitors_ : visitors)
        {
            set.add(visitors_);
        }
        //이미 친구인경우 친구 추천 목록 에서 제외하고 기존 친구 목록에 추가
        for(List<String> friends_ : friends)
        {
            if(friends_.get(0).equals(user)) 
            {
                friendSet.add(friends_.get(1));
            }
            else if(friends_.get(1).equals(user))
            {
                friendSet.add(friends_.get(0));
            }
        }
        //이미 친구인 경우와 자기 자신 목록에서 제외
        for(String friendSet_ : friendSet)
        {
            set.remove(friendSet_);
        }
        set.remove(user);

        //친구 , 점수 HashMap initiate
        for(String friends_ : set)
        {
            map.put(friends_, 0);
        }

        //방문 기록으로 점수 +1
        int temp;
        for(String visitors_ : visitors)
        {
            if(map.containsKey(visitors_))
            {
                temp = map.get(visitors_);
                temp ++;
                map.put(visitors_, temp);
            }
        }

        for(List<String> friends_ : friends)
        {
            for(String friendSet_ : friendSet)
            {
                for(String set_ : set)
                {
                    if(friends_.contains(friendSet_) && friends_.contains(set_))
                    {
                        temp = map.get(set_);
                        temp += 10;
                        map.put(set_, temp);
                    }
                }
            }
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        answer  = keyList;
        return answer;
    }
}
