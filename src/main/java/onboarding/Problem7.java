package onboarding;

import net.bytebuddy.matcher.CollectionSizeMatcher;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> user_friend = new HashSet<String>();  //user와 친구인 사람들
        HashMap<String, Integer> user_list = new HashMap<String, Integer>(); //전체의 friend리스트, 점수체크용
        List<String> answerList=new ArrayList<String>();

        //user와의 친구 관계 확인
        for (List<String> friendship : friends) {
            if (friendship.get(0) == user) {
                user_friend.add(friendship.get(1));
            } else if (friendship.get(1) == user) {
                user_friend.add(friendship.get(0));
            }
            user_list.put(friendship.get(0), 0);
            user_list.put(friendship.get(1), 0);
        }

        //user와 친구가 같은경우 +10점
        for (List<String> friendship : friends) {
            if(user_friend.contains(friendship.get(0))){
                user_list.put(friendship.get(1),user_list.get(friendship.get(1))+10);
            }
            if(user_friend.contains(friendship.get(1))){
                user_list.put(friendship.get(0),user_list.get(friendship.get(0))+10);
            }
        }


        //user의 방문횟수에 따른 +1점
        for(String visitor: visitors){
            if(!user_list.containsKey(visitor)){
                user_list.put(visitor,1);
            }
            else
                user_list.put(visitor,user_list.get(visitor)+1);
        }
        
        //user_list에서 user자신과 user의 친구들을 제거
        user_list.remove(user);
        for(String s:user_friend){
            user_list.remove(s);
        }

        //각각을 돌려보는게 제일 편할듯하다
        List<String> save_name=new ArrayList<String>();
        int before_max=0;

        while(answerList.size()<5){
            String name="";
            int max=0;
            for(String friend_name:user_list.keySet()){
                int point=user_list.get(friend_name);
                if(point>max){
                 max=point;
                 name=friend_name;
                }
            }

            if(max>0){
                if(max!=before_max &&!save_name.isEmpty()){
                    Collections.sort(save_name);
                    for(String s:save_name)
                        answerList.add(s);
                    save_name.clear();
                }
                
                save_name.add(name);
                before_max=max;
                user_list.remove(name);
                if(user_list.isEmpty())
                    break;
            }
            else
                break;
        }

        if(!save_name.isEmpty()) {
            Collections.sort(save_name);
            for (String name : save_name) {
                if (answerList.size() == 5)
                    break;
                answerList.add(name);
            }
        }

        answer=answerList;

        return answer;
    }
}
