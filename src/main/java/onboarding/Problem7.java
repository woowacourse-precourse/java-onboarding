package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        ArrayList<String> user_friend = new ArrayList<String>();
        ArrayList<String> not_friend = new ArrayList<String>();

        //Friend와 아닌 경우를 구분(friends, visitor 활용)
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
        //System.out.println(user_friend);

        for(int i=0;i<visitors.size();i++){
            not_friend.add(visitors.get(i));
        }

        HashSet<String> hashSet = new HashSet<>(not_friend);
        hashSet.removeAll(user_friend); // 중복 제거
        not_friend = new ArrayList<>(hashSet);

        //System.out.println(not_friend);


        //Score 계산
        int[] score = new int[not_friend.size()];

        for(int i=0;i<visitors.size();i++){
            for(int j=0;j<not_friend.size();j++){
                if(visitors.get(i) == not_friend.get(j)){
                    score[j] += 1;
                }
            }
        }

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

        while(true){
            int maxValue = -1;
            for(int k=0; k< not_friend.size();k++){ // 최대값 찾기
                if(score[k] > maxValue){
                    maxValue = score[k];
                }
            }
            if(maxValue == -1 || maxValue == 0){ // Score가 0이거나 탐색이 모두 완료되었다면 break.
                break;
            }
            ArrayList<String> sameScore = new ArrayList<String>();
            for(int k=0; k< not_friend.size();k++){ // 최대값 찾기
                if(score[k] == maxValue){
                    score[k] = -1;
                    sameScore.add(not_friend.get(k));
                }
            }

            //System.out.println(maxValue);
            Collections.sort(sameScore); // 같은 Score라면 이름순으로 정렬

            for(int i=0;i<sameScore.size();i++){
                answer.add(sameScore.get(i));
                if(answer.size() == 5){ // 최대 5명만 return
                    break;
                }
            }
            if(answer.size() == 5){
                break;
            }

            //System.out.println(sameScore);
        }





        return answer;
    }
}
