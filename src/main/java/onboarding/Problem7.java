package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendsOfUser = new ArrayList<>();
        HashMap<String, Integer> recommendFriendsScore = new HashMap<>();

//먼저 HashMap에서 user의 친구를 조사한다.
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).contains(user)){
                for(int j = 0; j < friends.get(i).size(); j++) {
                    if(!friends.get(i).get(j).equals(user)) {
                        friendsOfUser.add(friends.get(i).get(j));
                    }
                }
            }
        }
        return answer;
    }
}
