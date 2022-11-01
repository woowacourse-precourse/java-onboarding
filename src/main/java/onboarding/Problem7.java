package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String,Integer> score_list = new HashMap<>();
        HashSet<String> friends_list = new HashSet<>();

        //친구 목록 생성
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(0).equals(user)) friends_list.add(friends.get(i).get(1));
            else if(friends.get(i).get(1).equals(user)) friends_list.add(friends.get(i).get(0));
        }

        //아는 친구 점수 계산
        for(int i=0;i<friends.size();i++){
            if(!friends.get(i).get(0).equals(user) && !friends.get(i).get(1).equals(user)){
                if(friends_list.contains(friends.get(i).get(0))) {
                    if(!friends_list.contains(friends.get(i).get(1))){
                        score_list.put( friends.get(i).get(1) , score_list.get(friends.get(i).get(1))+10 );
                    }
                }

                if(friends_list.contains(friends.get(i).get(1))) {
                    if(!friends_list.contains(friends.get(i).get(0))){
                        score_list.put( friends.get(i).get(0) , score_list.get(friends.get(i).get(0))+10 );
                    }
                }

            }

        }

        //방문 점수 계산





        return answer;
    }

}
