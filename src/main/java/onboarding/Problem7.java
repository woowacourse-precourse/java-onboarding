package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> userfriend = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();

        ArrayList<String> answer = new ArrayList<String>();
        int data;

        for(int i=0;i<friends.size();i++){
            //사용자와 친구라면? 저장

            if(friends.get(i).get(0)==user){
                userfriend.add(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1)==user){
                userfriend.add(friends.get(i).get(0));
            }
        }

        for(int i=0;i<friends.size();i++){
            if(friends.get(i).contains(user)){
                continue;

            }

            for(int j=0;j<userfriend.size();j++){

                if(friends.get(i).contains(userfriend.get(j))){
                    for(int k=0;k<2;k++){
                        if(friends.get(i).get(k)!=userfriend.get(j)){
                            System.out.println(friends.get(i).get(k));
                            if(map.get(friends.get(i).get(k))==null)
                            {
                                data=10;
                            }else{
                                data=map.get(friends.get(i).get(k))+10;
                            }
                            System.out.println(data);

                            map.put(friends.get(i).get(k),data);
                        }
                    }
                }
            }
        }
        //visiter
        for(int i=0;i<visitors.size();i++){
            if(userfriend.contains(visitors.get(i))){
                continue;
            }
            if(map.get(visitors.get(i))==null){
                map.put(visitors.get(i),1);
                continue;
            }
            map.put(visitors.get(i),map.get(visitors.get(i))+1);
        }

        List<String> keyList = new ArrayList<>(map.keySet());

        System.out.println(keyList);

        return keyList;
    }
}
