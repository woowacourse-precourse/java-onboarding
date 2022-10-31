package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friend = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int max =0;
        String name=null;
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).contains(user)){
                friend.add(friends.get(i).get(0)!=user?friends.get(i).get(0):friends.get(i).get(1));
            }
        }

       for(int i=0;i<friends.size();i++){
           for(String hi:friend){
               name = null;
               if((friends.get(i).contains(hi))&&(!(friends.get(i).contains(user)))){
                   name = friends.get(i).get(0)!=hi?friends.get(i).get(0):friends.get(i).get(1);
                   if(map.containsKey(name))map.put(name,map.get(name)+10);
                   else map.put(name,10);
               }
           }
       }

        for(int i=0;i<visitors.size();i++){
            if (friend.contains(visitors.get(i)))continue;
            if(map.containsKey(visitors.get(i)))map.put(visitors.get(i),map.get(visitors.get(i))+1);
            else map.put(visitors.get(i),1);
        }

        for(int i=0;i<5;i++) {
            name=null;
            max=0;
            if (map.size()==0)break ;
            for (String key : map.keySet()) {
                if (max < map.get(key)) {
                    name = key;
                    max = map.get(key);
                }

               if(max==map.get(key)) {
                   if(name.compareTo(key)==1){
                       name = key;
                   }
               }

            }
            answer.add(name);
            map.remove(name);

        }
        return answer;
    }
    
}
