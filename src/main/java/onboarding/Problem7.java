package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    static class friendpoint implements Comparable<friendpoint>{
        private String user;
        private int point;

        public friendpoint(String user,int point){
            this.user=user;
            this.point=point;
        }
        public String getUser(){
            return this.user;
        }

        public int getPoint(){
            return this.point;
        }
        @Override
        public int compareTo(friendpoint o) {
            if(this.point>o.getPoint()){
                return -1;
            }else if(this.point<o.getPoint())
                return 1;
            else{
                return this.user.compareTo(o.getUser());

            }
        }
    }
}
