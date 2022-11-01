package onboarding;
import java.util.*;
public class Problem7 {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "andole"),
            List.of("donut", "jun"),
            List.of("donut", "mrko"),
            List.of("shakevan", "andole"),
            List.of("shakevan", "jun"),
            List.of("shakevan", "mrko"));
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(solution(user, friends, visitors));
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(5);
        Set<String> friend = new HashSet<>();
        Map<String, Integer> friendAndScore = new HashMap<>();
        String str[] = new String[5];

        int recommand = 10;     //친구의 친구일 때 더해줄 값
        //친구입력
        for (List<String> friendSearch : friends) {
            if (friendSearch.get(0).equals(user)) {
                friend.add(friendSearch.get(1));
            } else if (friendSearch.get(1).equals(user)) {
                friend.add(friendSearch.get(0));
            } else {

            }
        }
        //친구의 친구찾기
        for(List<String> friendSearch : friends){
            if(friendSearch.get(0).equals(user) || friendSearch.get(1).equals(user)){
                continue;
            }
            if(friend.contains(friendSearch.get(1))) {
                if (friend.contains(friendSearch.get(0))) {
                    continue;
                }
                else {
                    int score = 0;
                    if(friendAndScore.containsKey(friendSearch.get(0))){
                        score = friendAndScore.get(friendSearch.get(0));
                        }
                    score += 10;
                    friendAndScore.put(friendSearch.get(0), score);
                }
            }
            if(friend.contains(friendSearch.get(0))) {
                if (friend.contains(friendSearch.get(1))) {
                    continue;
                }
                else {
                    int score = 0;
                    if(friendAndScore.containsKey(friendSearch.get(1))){
                        score = friendAndScore.get(friendSearch.get(1));
                    }
                    score += 10;
                    friendAndScore.put(friendSearch.get(1), score);
                }
            }
            }

        //방문자
        for(String friendSearch : visitors) {
            //방문자가 친구거나 자신일 경우 스킵
            if (friend.contains(friendSearch) || user.equals(friendSearch)) {
                    continue;
            }
            else {
                int score = 0;
                //친구의 친구라면
                if (friendAndScore.containsKey(friendSearch)) {
                    score = friendAndScore.get(friendSearch);
                }
                score += 1;
                friendAndScore.put(friendSearch, score);
            }
        }
        for (String name : visitors) {
            if (friend.contains(name) || user.equals(name)) continue;
            friendAndScore.put(name, friendAndScore.getOrDefault(name, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(friendAndScore.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return -o1.getValue().compareTo(o2.getValue());
        });

        for (Map.Entry<String, Integer> map : list) {
            answer.add(map.getKey());
        }
        return answer;
    }
}
