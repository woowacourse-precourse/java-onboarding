package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        int[] score = new int[friends.size()];
        String[] knowFriend = new String[friends.size()];
        String[] knowFriendSet = new String[friends.size()];


        for(int i = 0; i < friends.size(); i++){
            knowFriend[i] = String.valueOf(friends.get(i).get(1));
        }
        for(int i = 0; i < friends.size(); i++){
            for(int j = 1+i ; j < friends.size(); j++){
                if(knowFriend[i] == knowFriend[j]){
                    knowFriend[j] = null;
                }
                continue;
            }
        }
        System.out.println(knowFriend.length);

        return answer;
    }
}
