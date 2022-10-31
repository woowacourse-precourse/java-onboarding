package onboarding;

import java.util.*;

public class Problem7 {
   //이름과 점수를 저장할 사용자 정의 자료형 생성
   static class people_score{
       public int score;
       public String people;

       public people_score(String people, int score){
           this.people = people;
           this.score = score;
       }
   }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //사용자와 함께 아는 친구의 목록 생성 함수
    static List<String> user_friends(String user, List<List<String>> friends){
        List<String> friend = new ArrayList<>();

        for (int i=0;i<friends.size();i++){
            String x = friends.get(i).get(0);
            String y = friends.get(i).get(1);

            if(x.equals(user)){
                friend.add(y);
            }
            if(y.equals(user)){
                friend.add(x);
            }
        }

        return friend;
    }
    //hash를 사용하여 중복없이 모든 친구의 목록을 저장하는 함수
    static HashSet<String> no_duplication_user(String user, List<List<String>> friends, List<String> visitors){
        HashSet<String> userList = new HashSet<>();

        userList.add(user);

        for (int i=0;i<friends.size();i++){
            userList.add(friends.get(i).get(0));
            userList.add(friends.get(i).get(1));
        }

        for (int i=0;i< visitors.size();i++){
            userList.add(visitors.get(i));
        }

        return userList;
    }
    //hash를 사용하여 저장한 중복없는 친구목록을 List로 변환해 줄 함수
    static List<people_score> user_list(String user, List<List<String>> friends, List<String> visitors){
        List<people_score> userList = new ArrayList<>();
        HashSet<String> no_dupl_user = no_duplication_user(user,friends,visitors);

        Iterator iter = no_dupl_user.iterator();

        while (iter.hasNext()){
            userList.add(new people_score(String.valueOf(iter.next()),0));
        }

        return userList;
    }
    //만들어둔 친구 목록을 사용자정의 자료형 리스트로 변환해 줄 함수

    //사용자와 함께 아는 친구의 수 점수 계산 함수

    //사용자의 타임라인에 방문한 점수 계산 함수

    //사용자와 함께 아는 친구의 수 점수와 사용자의 타임라인에 방문한 점수의 총 합을 구해주는 함수

    //실행을 위한 함수

}

