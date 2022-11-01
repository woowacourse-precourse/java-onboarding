package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String,String[]> friend_list = new HashMap<>();
        HashMap<String,Integer> score = new HashMap<>();
        List<String> answer = new ArrayList<>();

//        user 친구 목록 만들기
        List<String> user_friends = new ArrayList<>();
        for (List<String> friend:friends) {
            if(friend.get(0).equals(user)){
                user_friends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                user_friends.add(friend.get(0));
            }
        }
        //user 제외하고 친구의 친구 10점
        for(List<String> friend : friends){
            for(String user_friend : user_friends){
                String f_friend = "";

                if(friend.get(0).equals(user_friend)&&!(friend.get(1).equals(user))){
                    f_friend = friend.get(1);

                    if(score.get(f_friend)!=null){
                        score.put(f_friend,score.get(f_friend)+10);
                    }else{
                        score.put(f_friend,10);
                    }
                }else if(friend.get(1).equals(user_friend)&&!(friend.get(0).equals(user))){
                    f_friend = friend.get(0);
                    if(score.get(f_friend)!=null){
                        score.put(f_friend,score.get(f_friend)+10);
                    }else{
                        score.put(f_friend,10);
                    }
                }
            }
        }

        for (String visitor : visitors){
             if(!(visitor.equals(user))){
                 if(score.get(visitor) != null){
                     score.put(visitor,score.get(visitor)+1);
                 }
             score.put(visitor, 1);
             }
        }

        List<String> names = new ArrayList<>(score.keySet());
        Collections.sort(names, (a,b) -> score.get(b).compareTo(score.get(a)));


        for(int i=0; i<names.size();i++){

            if(i==5)break;

            if(user_friends.contains(names.get(i))){
                names.remove(i);
                i--;
            }else{
                answer.add(names.get(i));
            }

        }
        return answer;
    }
}
