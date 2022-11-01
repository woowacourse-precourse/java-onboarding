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
                        if(score_list.containsKey(friends.get(i).get(1))) {score_list.put( friends.get(i).get(1) , score_list.get(friends.get(i).get(1))+10 );}
                        else score_list.put( friends.get(i).get(1) , 10 );


                    }
                }

                if(friends_list.contains(friends.get(i).get(1))) {
                    if(!friends_list.contains(friends.get(i).get(0))){
                        if(score_list.containsKey(friends.get(i).get(0))) {score_list.put( friends.get(i).get(0) , score_list.get(friends.get(i).get(0))+10 );}
                        else {score_list.put( friends.get(i).get(0) , 10 );}

                    }
                }

            }

        }

        //방문 점수 계산
        for(int i=0;i<visitors.size();i++){
            if(!visitors.get(i).equals(user)){
                if(!friends_list.contains(visitors.get(i))){
                    if(score_list.containsKey(visitors.get(i))) {score_list.put(visitors.get(i), score_list.get(visitors.get(i))+1);}
                    else {score_list.put(visitors.get(i),1);}


                }
            }
        }

        //정렬
        List<Map.Entry<String,Integer>> sortList = new LinkedList<>(score_list.entrySet());
        sortList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int count=0;
        for(Map.Entry<String, Integer> list : sortList){
            if(count>=5) break;

            answer.add(list.getKey());
            count++;
        }


        return answer;
    }

}
