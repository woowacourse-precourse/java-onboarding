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
                for(String visitor:visitors){
                    if(!friendmap.containsKey(visitor))
                        friendmap.put(visitor,new ArrayList<>());


                    if(visitpoint.containsKey(visitor))
                        visitpoint.put(visitor,visitpoint.get(visitor)+1);
                    else
                        visitpoint.put(visitor,1);



                }
                for(String name:friendmap.keySet()){

                    if(name==user ||userfriend.containsKey(name))
                        continue;


                    int point=0;
                    for(String friend:friendmap.get(name)){
                        if(userfriend.containsKey(friend)){
                            point+=10;
                        }
                    }

                    if(visitpoint.containsKey(name))
                        priorityQueue.add(new friendpoint(name,point+visitpoint.get(name)));
                    else
                        priorityQueue.add(new friendpoint(name, point));



                }

            }
            int count=0;
            while(priorityQueue.size()!=0||count==5) {
                friendpoint now=priorityQueue.poll();
                if(now.point>0) {
                    count++;
                    answer.add(now.getUser());

                }
            }



            return answer;
        }


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
