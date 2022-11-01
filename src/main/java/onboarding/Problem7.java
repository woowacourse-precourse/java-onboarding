package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashSet<String> my = new HashSet<>();
        HashMap<String, Integer> score = new HashMap<>();


        // 친구 명단 중 user의 친구를 my 에 담는 과정
        addMyfriends(user, friends, my);
        // user의 친구의 친구를 찾아 score 10점을 더하는 과정
        addScore10(user, friends, my, score);
        // user의 타임라인에 방문한 친구에게 1점을 더하는 과정
        addScore1(visitors, my, score);


        // 추천 점수중의 key값만 answer에 담아준다
        List<String> answer = new ArrayList<>(score.keySet());
        // 이름순으로 answer 정렬
        Collections.sort(answer);
        // 이름순으로 정렬한 answer을 점수별로 비교해 오름차순 정렬한다
        Collections.sort(answer, (s1, s2) -> (score.get(s2).compareTo(score.get(s1))));

        
        // answer 리스트를 최대 길이 5까지만 가능하도록 자르기
        answer.subList(0, Math.min(answer.size(), 5));

        // 만약 추천 리스트에 담긴 사람 중 추전 점수가 0점이면 제거해준다.
        for (int i = 0; i < answer.size(); i++) {
            if (score.get(answer.get(i)) == 0){
                answer.remove(i);
            }
        }

        return answer;
    }

    private static void addScore1(List<String> visitors, HashSet<String> my, HashMap<String, Integer> score) {
        for (String visitor : visitors){
            if (!my.contains(visitor)){
                if (score.containsKey(visitor)){
                    score.replace(visitor, score.get(visitor) + 1);
                }else{
                    score.put(visitor, 1);
                }
            }
        }
    }

    private static void addScore10(String user, List<List<String>> friends, HashSet<String> my, HashMap<String, Integer> score) {
        for (List<String> friend : friends){
            if (my.contains(friend.get(0)) && !friend.get(1).equals(user)){
                if (score.containsKey(friend.get(1))){
                    score.replace(friend.get(1), score.get(friend.get(1)) + 10);
                }else{
                    score.put(friend.get(1), 10);
                }
            } else if (my.contains(friend.get(1)) && !friend.get(0).equals(user)) {
                if (score.containsKey(friend.get(0))){
                    score.replace(friend.get(0), score.get(friend.get(0)) + 10);
                }else{
                    score.put(friend.get(0), 10);
                }
            }
        }
    }

    private static void addMyfriends(String user, List<List<String>> friends, HashSet<String> my) {
        for (List<String> friend: friends) {
            if (friend.get(0).equals(user)){
                my.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                my.add(friend.get(0));
            }
        }
    }
}
