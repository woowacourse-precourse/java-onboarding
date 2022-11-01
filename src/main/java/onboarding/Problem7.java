package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    static HashMap<String, Integer> recommend = new HashMap<String, Integer>();

    public static List sorting(){
        List<String> recommendFriends = new ArrayList<>();
        List<String> listOfName = new ArrayList<>(recommend.keySet());

        listOfName.sort((o1, o2) -> {
            if(recommend.get(o1).equals(recommend.get(o2))){
                return o1.compareTo(o2);
            }
            return recommend.get(o2).compareTo(recommend.get(o1));
        });

        if(listOfName.size() > 5){
            for(int i = 0; i < 5; i++)
                recommendFriends.add(listOfName.get(i));
        }else
            for(String list : listOfName)
                recommendFriends.add(list);
        return recommendFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
