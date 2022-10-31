package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        //사용자의 친구 분류
        HashSet<String> friend_set = new HashSet<>();
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).get(0).equals(user)) friend_set.add(friends.get(i).get(1));
            else if (friends.get(i).get(1).equals(user)) friend_set.add(friends.get(i).get(0));
        }

        HashMap<String, Integer> score_map = new HashMap<>();
        //함께아는 친구 수 계산
        for (int i = 0; i < friends.size(); i++){
            String left = friends.get(i).get(0);
            String right = friends.get(i).get(1);
            //유저가 포함되어있는 경우 continue
            if (left.equals(user) || right.equals(user)) continue;
            //좌측 우측 둘다 친구일 경우 continue
            if (friend_set.contains(left) && friend_set.contains(right)) continue;
            //좌측 사람이 친구일 경우 우측 사람에게 점수 배정
            if (friend_set.contains(left)){
                if (!score_map.containsKey(right)) score_map.put(right, 10);
                else score_map.put(right, score_map.get(right)+10);
            //우측 사람이 친구일 경우 좌측 사람에게 점수 배정
            } else if (friend_set.contains(right)){
                if (!score_map.containsKey(left)) score_map.put(left, 10);
                else score_map.put(left, score_map.get(left)+10);
            }
        }

        //방문횟수 계산
        for (int i = 0; i < visitors.size(); i++){
            //유저의 친구가 아닌 경우 점수 증가
            if (!friend_set.contains(visitors.get(i))) {
                if(!score_map.containsKey(visitors.get(i))) score_map.put(visitors.get(i), 1);
                else score_map.put(visitors.get(i), score_map.get(visitors.get(i))+1);
            }
        }

        List<Map.Entry<String, Integer>> score_list = new ArrayList<>(score_map.entrySet());
        //추천 점수가 동일한 경우 이름순 정렬
        Collections.sort(score_list, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        //추천 점수가 가장 높은 순으로 정렬
        Collections.sort(score_list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        //최대 5명까지 입력
        for (int i = 0; i < score_list.size() ;i++){
            if (i > 4) break;
            answer.add(score_list.get(i).getKey());
        }

        return answer;
    }
}
