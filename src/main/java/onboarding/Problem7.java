package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> distinctName = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        Map<String, Integer> pointList = new HashMap<>();


        // 중복 없는 사람 리스트 제작, 유저의 친구 리스트 제작
        for(int i = 0; i<friends.size(); i++){
            distinctName.add(friends.get(i).get(0));
            distinctName.add(friends.get(i).get(1));

            if(friends.get(i).get(0) == user){
                userFriends.add(friends.get(i).get(1));
            }
            else {
                userFriends.add(friends.get(i).get(0));
            }
        }

        for(int i = 0; i<visitors.size(); i++){
            distinctName.add(visitors.get(i));
        }

        distinctName = distinctName.stream().distinct().collect(Collectors.toList());
        userFriends = distinctName.stream().distinct().collect(Collectors.toList());

        // 사람 리스트를 바탕으로 점수가 포함된 친구 리스트를 작성
        for(int i = 0; i<distinctName.size(); i++){
            pointList.put(distinctName.get(i), 0);
        }

        // 포인트 리스트에서 유저는 제외
        pointList.remove(user);

        // 친구 리스트에 있는 함께 아는 친구들은 포인트 10점을 제공
        for(int i = 0; i<friends.size(); i++){
            if(userFriends.contains(friends.get(i).get(0))){
                pointList.replace(friends.get(i).get(1), 10);

                pointList.remove(friends.get(i).get(0));
            }
            else if(userFriends.contains(friends.get(i).get(1))) {
                pointList.replace(friends.get(i).get(0), 10);

                pointList.remove(friends.get(i).get(1));
            }
        }

        // 방문자들은 1점을 제공
        for(int i = 0; i<visitors.size(); i++){
            if(pointList.containsKey(visitors.get(i))){
                pointList.replace(visitors.get(i), pointList.get(visitors.get(i))+1);
            }
        }

        // 점수 순으로 정렬, 점수가 같으면 이름순으로 정렬
        List<Map.Entry<String, Integer>> list = new LinkedList<>(pointList.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        // 점수가 0점이면 출력하지 않음
        List<String> answer = new ArrayList<>();
        int max = 0;
        for(String key : pointList.keySet()) {
            Integer value = pointList.get(key);
            if(value == 0 || max == 5) {
                continue;
            } else {
                answer.add(key);
                max++;
            }
        }


        return answer;
    }
}
