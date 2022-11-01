package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        //List<List<String>> all_user = new ArrayList<>();
        List<String> user_friends = new ArrayList<>();
        HashMap<String, Integer> friend_list = new HashMap<>();
        int size = friends.size();
        int[] flag = new int[size];

        for(int i=0; i<size; i++){
            if(friends.get(i).get(0) == user){
                user_friends.add(friends.get(i).get(1));
                flag[i] = 1;
            }
            else if(friends.get(i).get(1) == user){
                user_friends.add(friends.get(i).get(0));
                flag[i] = 1;
            }
            else{
                for(int j=0; j<friend_list.size(); j++){

                }
            }
        }

        for(int i=0; i<size; i++){
            if(flag[i] == 0){
                for(int j = 0 ; j<user_friends.size();j++){

                }
            }
        }

        return answer;
    }
}
