package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();
        HashMap<String,Integer> score = new HashMap<>();

        scoreByFriends(user,friends,score);
        scoreByVisitors(visitors,score);

        return answer;
    }

    //유저의 친구의 친구일때 점수 획득
    public static void scoreByFriends(String user,List<List<String>> friends, HashMap<String,Integer> score){

        List<String> usersFriends = new ArrayList<>();
        String friendsOne ,friendsTwo;

        for(int i = 0; i < friends.size(); i++){
            friendsOne = friends.get(i).get(0);
            friendsTwo = friends.get(i).get(1);

            if(friendsOne.equals(user)){
                usersFriends.add(friendsTwo);
            }

            if(friendsTwo.equals(user)){
                usersFriends.add(friendsOne);
            }
        }

        for(int i = 0; i < friends.size(); i++){
            friendsOne = friends.get(i).get(0);
            friendsTwo = friends.get(i).get(1);
            int currentScore = 0;

            for(int j = 0 ; j < usersFriends.size(); j++){
                if(friendsOne.equals(usersFriends.get(j))){
                    if(score.containsKey(friendsTwo)) currentScore = score.get(friendsTwo);
                    currentScore += 10;
                    score.put(friendsTwo,currentScore);
                }

                if(friendsTwo.equals(usersFriends.get(j))){
                    if(score.containsKey(friendsOne)) currentScore = score.get(friendsOne);
                    currentScore += 10;
                    score.put(friendsOne,currentScore);
                }
            }
        }
    }

    //유저의 타임라인에 방문했을때 점수 획득
    public static void scoreByVisitors(List<String> visitors, HashMap<String,Integer> score){

        for(int i = 0 ; i < visitors.size(); i++){
            int currentScore = 0;
            if(score.containsKey(visitors.get(i))) currentScore = score.get(visitors.get(i));
            currentScore+=1;
            score.put(visitors.get(i),currentScore);
        }
    }
}
