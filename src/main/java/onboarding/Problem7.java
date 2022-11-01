package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    static List<String> answer = Collections.emptyList();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Create(user, friends,visitors);
        return answer;
    }
    public static void Create(String user, List<List<String>> friends,List<String> visitors){
        List<String> oldFriends = Collections.emptyList();

        for(int i = 0; i < friends.size();i++){
            for (int j = 0; j<2;j++){
                String temp = friends.get(i).get(j);
                if(temp != user) {
                    if (!answer.contains(temp)) answer.add(temp);
                }
                else {
                    int flag = 1 - j;
                    oldFriends.add(friends.get(i).get(flag));
                }
            }
        }
        for(int i = 0; i < answer.size(); i++){
            for(int j = 0; j < oldFriends.size(); j++){
                if(answer.get(i) == oldFriends.get(j)) answer.remove(i);
            }
        }//return answer;

        for(int i = 0; i < visitors.size(); i++){
            int count = 0;
            for(int j = 0; j < answer.size(); j++){
                if(i == j){
                    count++;
                }
            }
            if(count == answer.size()){
                answer.add(visitors.get(i));
            }
        }
    }

    static class User{
        private String name;
        private int point;

        public void plusPoint(int n){
            this.point += n;
        }
    }
}
