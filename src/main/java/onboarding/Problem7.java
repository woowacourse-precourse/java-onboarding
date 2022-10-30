package onboarding;

import java.util.*;

public class Problem7 {
    private static HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
    private static HashMap<String, Integer> score = new LinkedHashMap<String, Integer>();

    ////친구 관게를 hashmap을 이용해 그래프로 나타내는 함수
    private static void to_graph(List<List<String>> friends){
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
    }

    //함께 아는 친구에게 점수를 부여하는 함수
    private static void friends_score(String user){
        for(String friend: graph.get(user)){
            for(String to_friend: graph.get(friend)){
                if(to_friend == user) continue;

                if(score.containsKey(to_friend)) score.put(to_friend, score.get(to_friend) + 10);
                else score.put(to_friend, 10);
            }
        }
    }

    //방문자에게 점수를 부여하는 함수
    private static void visitor_score(String user, List<String> visitors){
        for(String visitor: visitors){
            if (graph.get(user).indexOf(visitor) != -1) continue;

            if(score.containsKey(visitor)) score.put(visitor, score.get(visitor) + 1);
            else score.put(visitor, 1);
        }
    }

    //점수를 기준으로 내림차순으로 정렬하고, 만약 점수가 같다면 아이디를 기준으로 오름차순으로 정렬하는 함수
    private static List<Map.Entry<String, Integer>> sort_score_id(){
        List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(score.entrySet());
        sortedList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) return 1;
                else if (o1.getValue() > o2.getValue()) return -1;
                else return o1.getKey().compareTo(o2.getKey());
            }
        });

        return sortedList;
    }

    //점수가 높은 순서대로 친구 추천 5명 선택하는 함수
    private static List<String> choose5(List<Map.Entry<String, Integer>> sortedList){
        List<String> result = new ArrayList<String>();

        for(int i = 0; i<sortedList.size(); i++){
            if (i > 4) break;
            result.add(sortedList.get(i).getKey());
        }

        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //friends를 graph로 나타낸다.
        to_graph(friends);

        //함께 아는 친구에게 10점 부여한다.
        friends_score(user);

        //방문자에게 1점 부여한다.
        visitor_score(user, visitors);

        //점수와 아이디를 기준으로 정렬한다.
        List<Map.Entry<String, Integer>> sortedList = sort_score_id();

        //정렬된 것을 기준으로 순위가 높은 5명을 추천한다.
        List<String> ans = choose5(sortedList);

        return ans;
    }
}
