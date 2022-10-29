package onboarding;

import java.util.*;

public class Problem7 {
    private static HashMap<String, Integer> getVisitScore(HashMap<String, Integer> result, List<String> visitors){
        for(String v:visitors){
            if(result.containsKey(v)){
                result.put(v, result.get(v)+1);
            } else{
                result.put(v, 1);
            }
        }
        return result;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();

        // 친구 이름들
        HashSet<String> names = new HashSet<>();
        for(List<String> friend: friends){
            names.add(friend.get(0));
            names.add(friend.get(1));
        }
        System.out.println(names);

        for(String name: names){
            score.put(name, 0);
        }

        // 방문 점수 1점
        getVisitScore(score, visitors);
        System.out.println(score);
        
        // 친구별 연결된 친구
        HashMap<String, ArrayList<String>> friendGraph = new HashMap<>();
        for(List<String> friend: friends){
            if(!friendGraph.containsKey(friend.get(0))){
                ArrayList<String> arr = new ArrayList<>();
                arr.add(friend.get(1));
                friendGraph.put(friend.get(0), arr);
            } else{
                ArrayList<String> arr = friendGraph.get(friend.get(0));
                arr.add(friend.get(1));
                friendGraph.put(friend.get(0), arr);
            }

            if(!friendGraph.containsKey(friend.get(1))) {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(friend.get(0));
                friendGraph.put(friend.get(1), arr);
            } else{
                ArrayList<String> arr = friendGraph.get(friend.get(1));
                arr.add(friend.get(0));
                friendGraph.put(friend.get(1), arr);
            }
        }
        System.out.println(friendGraph);

        // 10점
        System.out.println(friendGraph.get(user).getClass().getName());
        for(Object friendUser: friendGraph.get(user)){
            System.out.println(friendUser);
            String f = String.valueOf(friendUser);
            ArrayList<String> first = friendGraph.get(f);
            System.out.println(first);

            for (Object o : first) {
                String second = String.valueOf(o);
                System.out.println("    " + second);
                if (second.equals(user)) {
                    continue;
                }
                if (!score.containsKey(second)) {
                    score.put(second, 10);
                } else {
                    score.put(second, score.get(second) + 10);
                }
            }
        }
        System.out.println(score);

        // 내림차순 정렬
        List<String> keySetList = new ArrayList<>(score.keySet());
        keySetList.sort((o1, o2) -> (score.get(o2).compareTo(score.get(o1))));
        ArrayList<String> alreadyFriends = friendGraph.get(user);
        int cnt = 0;
        for(String key : keySetList) {
            if(cnt == 5){
                break;
            }
            if(alreadyFriends.contains(key) || key.equals(user)){
                continue;
            }
            System.out.println("key : " + key + " / " + "value : " + score.get(key));
            answer.add(key);
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args){
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(solution(user, friends, visitors));

    }
}
