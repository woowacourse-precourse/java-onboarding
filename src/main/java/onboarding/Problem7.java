package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userList = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        boolean[][] friend = new boolean[35][35];
        int[] score = new int[35];

        userList.add(user);
        int listSize = friends.size();
        for(int i=0; i<listSize; ++i){
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);
            if(!userList.contains(friend1)) userList.add(friend1);
            if(!userList.contains(friend2)) userList.add(friend2);
            friend[userList.indexOf(friend1)][userList.indexOf(friend2)] =  true;
            friend[userList.indexOf(friend2)][userList.indexOf(friend1)] =  true;
        }

        int userSize = userList.size();
        for(int i=1; i<userSize; ++i)
            if(!friend[0][i])
                for(int j=1; j<userSize; ++j)
                    if(friend[i][j] && i != j && friend[0][j])
                        score[i] += 10;

        int visitorSize = visitors.size();
        for(int i=0; i<visitorSize; ++i){
            String visitor = visitors.get(i);
            if(!userList.contains(visitor)) userList.add(visitor);
            if(!friend[0][userList.indexOf(visitor)])
                score[userList.indexOf(visitor)] += 1;
        }

        userSize = userList.size();
        while(true){
            int maxScore = Integer.MIN_VALUE;
            List<String> temp = new ArrayList<>();
            for(int i=0; i<userSize; ++i) {
                if(score[i] == 0) continue;
                if(maxScore < score[i]){
                    temp.clear();
                    maxScore = score[i];
                    temp.add(userList.get(i));
                }
                else if(maxScore == score[i]) temp.add(userList.get(i));
            }
            if(temp.isEmpty()) break;
            for(int i=0; i<temp.size(); ++i)
                score[userList.indexOf(temp.get(i))] = 0;

            Collections.sort(temp);
            if(answer.size() + temp.size() <= 5) answer.addAll(temp);
            else answer.addAll(new ArrayList<>(temp.subList(0, 5-answer.size()-1)));
        }

        return answer;
    }
}
