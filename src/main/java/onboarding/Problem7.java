package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        ArrayList<String> user_friend = new ArrayList<String>();
        ArrayList<String> not_friend = new ArrayList<String>();

        for(int i=0;i<friends.size();i++){
            List<String> friend = friends.get(i);
            if(friend.get(0) == user){
                user_friend.add(friend.get(1));
            }
            else if(friend.get(1) == user){
                user_friend.add(friend.get(0));
            }
            else{
                not_friend.add(friend.get(0));
                not_friend.add(friend.get(1));
            }
        }
        System.out.println(user_friend);

        HashSet<String> hashSet = new HashSet<>(not_friend);
        hashSet.removeAll(user_friend);
        not_friend = new ArrayList<>(hashSet);
        System.out.println(not_friend);

        int[] score = new int[not_friend.size()];

        for(int i=0;i<not_friend.size();i++){
            for(int j=0;j<friends.size();j++){
                List<String> friend = friends.get(j);
                if(not_friend.get(i) == friend.get(0)){
                    for(int k=0;k<user_friend.size();k++){
                        if(user_friend.get(k)== friend.get(1)){
                            score[i] += 10;
                        }
                    }

                }
                else if(not_friend.get(i) == friend.get(1)){
                    for(int k=0;k<user_friend.size();k++){
                        if(user_friend.get(k)== friend.get(0)){
                            score[i] += 10;
                        }
                    }
                }
            }
        }


        List<String> answer = Collections.emptyList();
        return answer;
    }
}
