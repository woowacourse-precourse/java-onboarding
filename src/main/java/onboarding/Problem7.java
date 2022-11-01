package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // user의 친구가 들어있는 변수
        List<String> bestFriends = new ArrayList<>();

        // 방목자와 이름과 점수를 저장하는 변수
        Map<String,Integer> score = new HashMap<>();

        for(int i = 0; i<friends.size(); i++){
            if(friends.get(i).contains(user)){
                if(friends.get(i).get(0).equals(user)){
                    bestFriends.add(friends.get(i).get(1));
                }else{
                    bestFriends.add(friends.get(i).get(0));
                }
            }
        }

        for(int i = 0; i<bestFriends.size(); i++){
            for(int j = 0; j<friends.size(); j++){
                if(friends.get(j).contains(bestFriends.get(i)) && !friends.get(j).contains(user)){
                    if(friends.get(j).get(0).equals(bestFriends.get(i))){
                        if(score.containsKey(friends.get(j).get(1))){
                            score.put(friends.get(j).get(1),score.get(friends.get(j).get(1))+10);
                        }else{
                            score.put(friends.get(j).get(1),10);
                        }
                    }else{
                        if(score.containsKey(friends.get(j).get(0))){
                            score.put(friends.get(j).get(0),score.get(friends.get(j).get(0))+10);
                        }else{
                            score.put(friends.get(j).get(0),10);
                        }
                    }
                }
            }
        }

        for(int i = 0; i<visitors.size(); i++){
            if(!bestFriends.contains(visitors.get(i)) && !visitors.get(i).equals(user)){
                if(score.containsKey(visitors.get(i))){
                    score.put(visitors.get(i), score.get(visitors.get(i))+1);
                }else{
                    score.put(visitors.get(i), 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> result = new ArrayList<>();

        int count = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            if(count ==5){
                break;
            }
            result.add(entry.getKey());
            count++;
        }

        System.out.println(score.toString());

        return result;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan","mrko");

        System.out.println(solution(user,friends,visitors));
    }
}
