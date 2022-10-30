package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> ans = new ArrayList<String>();
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        HashMap<String, Integer> score = new LinkedHashMap<String, Integer>();
        
        //친구 관게를 hashmap을 이용해 그래프로 나타내기
        for(List<String> friend: friends){
            if (graph.containsKey(friend.get(0))){
                graph.get(friend.get(0)).add(friend.get(1));
            }
            else graph.put(friend.get(0), new ArrayList<String>(){{add(friend.get(1));}});

            if (graph.containsKey(friend.get(1))){
                graph.get(friend.get(1)).add(friend.get(0));
            }
            else graph.put(friend.get(1), new ArrayList<String>(){{add(friend.get(0));}});
        }
        System.out.println(graph);

        //함께 아는 친구에게 점수 부여하기
        for(String friend: graph.get(user)){
            for(String to_friend: graph.get(friend)){
                if(to_friend == user) continue;

                if(score.containsKey(to_friend)) score.put(to_friend, score.get(to_friend) + 10);
                else score.put(to_friend, 10);
            }
        }
        System.out.println(score);

        //방문자에게 점수 부여하기
        for(String visitor: visitors){
            if (graph.get(user).indexOf(visitor) != -1) continue;

            if(score.containsKey(visitor)) score.put(visitor, score.get(visitor) + 1);
            else score.put(visitor, 1);
        }
        System.out.println(score);
        
        //점수를 기준으로 내림차순으로 정렬, 만약 같은 점수가 존재한다면 키를 기준으로 오름차순
        List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(score.entrySet());
        sortedList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) return 1;
                else if (o1.getValue() > o2.getValue()) return -1;
                else return o1.getKey().compareTo(o2.getKey());
            }
        });
        System.out.println(sortedList);

        //점수가 높은 순서대로 친구 추천 5명 선택하기 
        for(int i = 0; i<sortedList.size(); i++){
            if (i > 4) break;
            ans.add(sortedList.get(i).getKey());
        }

        return ans;
    }
}
