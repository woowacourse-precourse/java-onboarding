package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++){
            if(friends.get(i).get(0).equals(user))
                userFriends.add(friends.get(i).get(1));
            if(friends.get(i).get(1).equals(user))
                userFriends.add(friends.get(i).get(0));
        }

        List<String> recommender = new ArrayList<>();
        List<Integer> score = new ArrayList<>();

        for (int i = 0; i < userFriends.size(); i++){
            for (int j = 0; j < friends.size(); j++){
                if(friends.get(j).get(0).equals(userFriends.get(i)) && !friends.get(j).get(1).equals(user)){
                    if(!recommender.contains((friends.get(j).get(1)))) {
                        recommender.add(friends.get(j).get(1));
                        score.add(10);
                    }
                    else
                        score.set(recommender.indexOf(friends.get(j).get(1)),score.get(recommender.indexOf(friends.get(j).get(1))) + 10);
                }
                if(friends.get(j).get(1).equals(userFriends.get(i)) && !friends.get(j).get(0).equals(user)){
                    if(!recommender.contains((friends.get(j).get(0)))) {
                        recommender.add(friends.get(j).get(0));
                        score.add(10);
                    }
                    else
                        score.set(recommender.indexOf(friends.get(j).get(0)),score.get(recommender.indexOf(friends.get(j).get(0))) + 10);
                }
            }
        }

        for(int i = 0; i < visitors.size(); i ++){
            boolean bool = true;
            for(int j = 0; j < userFriends.size(); j++)
                if(visitors.get(i).equals(userFriends.get(j))) {
                    bool = false;
                    break;
                }
            if(bool)
                if(!recommender.contains(visitors.get(i))) {
                    recommender.add(visitors.get(i));
                    score.add(1);
                }
                else
                    score.set(recommender.indexOf(visitors.get(i)),score.get(recommender.indexOf(visitors.get(i))));
        }

        for(int i = 1; i < score.size(); i++) {
            int j = i - 1;
            while(j >= 0 && score.get(j) <= score.get(j+1)) {
                if(score.get(j) == score.get(j+1)){
                    if(recommender.get(j).compareTo(recommender.get(j+1)) <= 0) {
                        j--;
                        continue;
                    }
                }

                int scoreTemp = score.get(j);
                String recoTemp = recommender.get(j);

                score.set(j,score.get(j+1));
                score.set(j+1,scoreTemp);

                recommender.set(j,recommender.get(j+1));
                recommender.set(j+1,recoTemp);
                j--;
            }
        }

        for (int i = 0; i < 5 && i < recommender.size(); i++){
            answer.add(recommender.get(i));
        }
        return answer;
    }
}