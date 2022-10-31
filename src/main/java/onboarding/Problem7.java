package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        //친구면 해쉬맵 <username,점수> 점수 Min integer해줌
        HashMap<String,ArrayList<String>> friendmap=new HashMap<>();
        HashMap<String,Boolean> userfriend=new HashMap<>();
        HashMap<String,Integer> visitpoint=new HashMap<>();
        PriorityQueue<friendpoint> priorityQueue=new PriorityQueue<>();


        for(int i=0;i<friends.size();i++){

            for(int j=0;j<2;j++){
                if(friends.get(i).get(j)==user){
                    userfriend.put(friends.get(i).get((j+1)%2),true);
                }


                if(friendmap.containsKey(friends.get(i).get(j)))
                    friendmap.get(friends.get(i).get(j)).add(friends.get(i).get((j+1)%2));

                else {
                    ArrayList<String> news = new ArrayList<>();
                    news.add(friends.get(i).get((j+1)%2));
                    friendmap.put(friends.get(i).get(j), news);
                }



            }}


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
