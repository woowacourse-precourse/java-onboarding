package onboarding;

import java.util.*;

class My_Friends{
    List<String> friends;
    List<String> recommends;
    HashMap<String,Integer> results;
    public void setter(){
        this.friends = new ArrayList<String>();
        this.recommends = new ArrayList<String>();
    }

    public void result_Setter(){
        this.results = new HashMap<String,Integer>();
        for(int i=0;i<this.recommends.size();i++){
            this.results.put(recommends.get(i),0);
        }
    }
    public void result_Scoreadder(String name,int flag){
        int prev_score = this.results.get(name);
        if(flag == 0)this.results.put(name,prev_score+10);
        else this.results.put(name,prev_score+1);
    }
    public void addFriends(String adder){
        this.friends.add(adder);
    }
    public void addRecommends(String reco){
        this.recommends.add(reco);
    }
    public void deleteRecommends(String del){
        this.recommends.removeAll(Arrays.asList(del));
    }
}
public class Problem7 {
    public static List<String> multi_remover(List<String> target){
        for(int j=0;j<target.size();j++){
            String temp = target.get(j);
            target.removeAll(Arrays.asList(temp));
            target.add(temp);
        }
        return target;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        My_Friends mrko = new My_Friends();
        mrko.setter();
        for(int i=0;i<(friends.size());i++){
            String front = friends.get(i).get(0);
            String back = friends.get(i).get(1);
            if (front == user) {mrko.addFriends(back); mrko.deleteRecommends(back);}
            else if (back == user) {mrko.addFriends(front);mrko.deleteRecommends(front);}
            else {mrko.addRecommends(front);mrko.addRecommends(back);}

        }
        mrko.recommends = multi_remover(mrko.recommends);
        mrko.result_Setter();
        //동일한 친구관계가 중복없으므로
        //friend list 에서 점수추가
        for(int i =0;i<mrko.recommends.size();i++){
            for(int j=0;j<mrko.friends.size();j++){
                String temp1=mrko.friends.get(j);
                String temp2=mrko.recommends.get(i);
                if(Collections.frequency(friends,Arrays.asList(temp1,temp2))>0 ||
                        Collections.frequency(friends,Arrays.asList(temp2,temp1))>0) {
                        mrko.result_Scoreadder(temp2,0);
                }
            }
        }
        //visit 처리
        for(int i=0;i<visitors.size();i++){
            // 이미 친구이면
            if(Collections.frequency(mrko.friends,visitors.get(i))>0) continue;
            // 친구가 아니면 result 등록, 이미 등록되어 있으면 점수 증가
            else {
                if(mrko.results.get(visitors.get(i))==null){
                    mrko.results.put(visitors.get(i),1);
                }else {
                    mrko.result_Scoreadder(visitors.get(i),1);
                }
            }
        }
        Map<String, Integer> sortedMap = new TreeMap<>(mrko.results);
        List<String> answer = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(sortedMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey());
        }

        return answer;
    }
}
