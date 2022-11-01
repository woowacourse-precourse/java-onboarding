package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String,Integer> info = new HashMap<String, Integer>();
        HashMap<String, Integer> vistorScore = new HashMap<String,Integer>();
        int n=0;
        info.put(user,n++);
        for (List<String> friend : friends) { //사람 목록
            for (int j = 0; j < 2; j++) {
                String f = friend.get(j);
                if (!info.containsKey(f))
                    info.put(f,n++);
            }
        }
        for (String visitor : visitors){
            if (!info.containsKey(visitor))
                info.put(visitor,n++);
            if(!vistorScore.containsKey(visitor))
                vistorScore.put(visitor,Collections.frequency(visitors, visitor));
        }

        int[] score = new int[n]; //점수
        int[][] rel = new int[n][n]; //관계 matrix

        for (List<String> friend : friends) {
            int i = info.get(friend.get(0));
            int j = info.get(friend.get(1));
            rel[i][j]=1;
            rel[j][i]=1;
        }
        List<Integer> f = getFriends(rel,0); // user의 친구인 회원의 index
        List<Integer> tmp;
        for(int i=0;i<f.size();i++){
            tmp = getFriends(rel,f.get(i));
            for(int j=0;j<tmp.size();j++){
                int index = tmp.get(j); //친구의 친구 index
                if(index!=0 && !f.contains(index)) //user가 아니고 친구 목록에 없는 경우 점수 10점
                    score[j]=10;
            }
        }
        for(int i=0;i<score.length;i++)
            System.out.println(score[i]);
        return answer;
    }

    public static List<Integer> getFriends(int rel [][],int k){
        List<Integer> f = new ArrayList<>();
        for(int i=0;i<rel.length;i++) {
            if (rel[0][k] == 1){
                f.add(i);
            }
        }
        return f;
    }


}
