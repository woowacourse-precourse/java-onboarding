package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        //[user : score]의 map 형성
        HashMap<String, Integer> userScore = new HashMap<>();
        for(int i=0;i<friends.size();i++){
            userScore.put(friends.get(i).get(0),0);
            userScore.put(friends.get(i).get(1),0);

        }
        for(int i=0;i<visitors.size();i++){
            userScore.put(visitors.get(i),0);
        }

        //친구 검색
        List<String>userFriend = new ArrayList<>();
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(0).equals(user)){
                if(!userFriend.contains(friends.get(i).get(1)))
                    userFriend.add(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1).equals(user)){
                if(!userFriend.contains(friends.get(i).get(0)))
                    userFriend.add(friends.get(i).get(0));
            }
        }

        //방문 1점씩
        for(int i=0;i<visitors.size();i++){
            int score = userScore.get(visitors.get(i));
            userScore.replace(visitors.get(i),score+1);
        }

        //user와 친구인 사람(userFriend에 contain되어있는 사람)과 친구면 10점 추가
        for(int i=0;i<friends.size();i++){
            if(userFriend.contains(friends.get(i).get(0))){
                int score = userScore.get(friends.get(i).get(1));
                userScore.replace(friends.get(i).get(1),score+10);
            }
            else if(userFriend.contains(friends.get(i).get(1))){
                int score = userScore.get(friends.get(i).get(0));
                userScore.replace(friends.get(i).get(0),score+1);
            }
        }

        //이미 친구인 사람 + user 삭제
        userScore.remove(user);
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(0).equals(user)){
                userScore.remove(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1).equals(user)){
                userScore.remove(friends.get(i).get(0));
            }
        }

        //점수순으로 정렬 - 같은 점수는 이름 순으로 정렬
        List<String> listKeySet = new ArrayList<>(userScore.keySet());
        listKeySet.sort((value1, value2) -> (userScore.get(value2).compareTo(userScore.get(value1))));

        List<String>tmp = new ArrayList<>(); // 이름순으로 정렬하기 위해 list

        for(int i=0;i<listKeySet.size();i++){
            String name = listKeySet.get(i);
            if(i== listKeySet.size()-1){
                tmp.add(name);
                Collections.sort(tmp);
                answer.addAll(tmp);
            }
            else{
                if(userScore.get(name)!= userScore.get(listKeySet.get(i+1))){
                    tmp.add(name);
                    Collections.sort(tmp);
                    answer.addAll(tmp);
                    tmp.clear();
                }
                else{
                    tmp.add(name);
                }
            }
        }





       return answer;
    }
}
