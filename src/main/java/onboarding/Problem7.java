package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * 기능 구현 사항
 * 1. visitor 점수 추가.
 * 2. 각 유저별 친구 HashMap<String, List<String>> 으로 구현.
 * */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();



        return answer;
    }


    static class SNSUser implements Comparable<SNSUser>{
        private int score;
        private List<String> friendList;

        public SNSUser(){
            this.score = 0;
            this.friendList = new ArrayList<>();
        }

        public void addFriend(String friend){
            this.friendList.add(friend);
        }

        @Override
        public int compareTo(SNSUser o) {
            return this.score - o.score;
        }

        public void compareFriend(SNSUser user){
            // todo
        }

        public void addVisitor(){
            this.score++;
        }
    }

}

