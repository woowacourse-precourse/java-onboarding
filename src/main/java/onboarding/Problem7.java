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
        HashMap<String, Integer> friend_list = new HashMap<String, Integer>(); //전체의 friend리스트, 점수체크용
        List<String> ans=new ArrayList<String>();

        //user와의 친구 관계 확인
        for (List<String> ls : friends) {
            if (ls.get(0) == user) {
                user_friend.add(ls.get(1));
            } else if (ls.get(1) == user) {
                user_friend.add(ls.get(0));
            }
            friend_list.put(ls.get(0), 0);
            friend_list.put(ls.get(1), 0);
        }

        //user와 친구가 같은경우 +10점
        for (List<String> ls : friends) {
            if(user_friend.contains(ls.get(0))){
                friend_list.put(ls.get(1),friend_list.get(ls.get(1))+10);
            }
            if(user_friend.contains(ls.get(1))){
                friend_list.put(ls.get(0),friend_list.get(ls.get(0))+10);
            }
        }


        //user의 방문횟수에 따른 +1점
        for(String s: visitors){
            if(!friend_list.containsKey(s)){
                friend_list.put(s,1);
            }
            else
                friend_list.put(s,friend_list.get(s)+1);
        }

        friend_list.remove(user);
        for(String s:user_friend){
            friend_list.remove(s);
        }

        //각각을 돌려보는게 제일 편할듯하다
        List<String> sname=new ArrayList<String>();

        int cmax=0;
        for(int i=0;i<5;i++){
            String name="";
            int max=0;
            for(String s:friend_list.keySet()){
                int cmp=friend_list.get(s);
                if(cmp>max){
                 max=cmp;
                 name=s;
                }
            }
            if(max>0){
                if(max==cmax||i==0){ //여기 else문이 위로 오게 조정할 필요
                    sname.add(name);
                    //cmax=max;
                }
                else{
                    //cmax=max;
                    Collections.sort(sname);
                    for(String s:sname)
                        ans.add(s);
                    sname.clear();
                    sname.add(name);
                }
                cmax=max;
                friend_list.remove(name);
                if(friend_list.isEmpty())
                    break;
            }
            else{
                break;
            }
        }

        for(String s:sname)
            ans.add(s);

        answer=ans;

        return answer;
    }
}
