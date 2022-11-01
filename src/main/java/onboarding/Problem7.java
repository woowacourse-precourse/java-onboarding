package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashSet<String> member = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(1) != user){
                member.add(friends.get(i).get(0));
                member.add(friends.get(i).get(1));
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            member.add(visitors.get(i));
        }
        int[] score = new int[member.size()];
        String[] m = member.toArray(new String[0]);

        HashSet<String> arr = new HashSet<>();
        ArrayList<String> ten = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(1) != user){
                int count1 = arr.size();
                arr.add(friends.get(i).get(1));
                int count2 = arr.size();
                if(count1 == count2){
                    ten.add(friends.get(i).get(1));
                }
            }
        }
        for (int i = 0; i < member.size(); i++) {
            for (int j = 0; j < ten.size(); j++) {
                if(ten.get(j)==m[i]){
                    score[i]+=10;
                }
            }
        }

        for (int i = 0; i < member.size(); i++) {
            for (int j = 0; j < visitors.size(); j++) {
                if(visitors.get(j)==m[i]){
                    score[i]+=1;
                }

            }

        }
        for (int i = 0; i < score.length; i++) {
            if(score[i]>1){
                answer.add(m[i]);
            }

        }


        return answer;
    }
}
