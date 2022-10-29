package onboarding;

import java.util.*;

/**
 * 기능 구현 목록
 * 1. user의 친구 목록 뽑기
 * 2. user 친구의 친구들을 뽑기. -> 키-값의 형태로 저장하기 위해 해시맵에 저장.
 * 3. 친구의 친구 순회 하면서 score 합산
 * 4. visitors 중 친구가 아닌 사람들만 스코어에 넣기
 * 5. score 순서대로 정렬. 점수가 같다면 이름순으로 정렬
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, Integer> nonFriends = new HashMap<>();

        // user의 친구 목록 추가
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).get(0).equals(user)){
                userFriends.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)){
                userFriends.add(friends.get(i).get(0));
            }
        }

        // 친구의 친구 목록 추가, score 합산
        for (int i = 0; i < friends.size(); i++){
            for (int j = 0; j < userFriends.size(); j++) {
                if (friends.get(i).contains(user)) {
                    continue;
                }
                if (userFriends.contains(friends.get(i).get(0)) && userFriends.contains(friends.get(i).get(1))){
                    continue;
                }

                if (friends.get(i).get(0).equals(userFriends.get(j))){
                    if (nonFriends.containsKey(friends.get(i).get(1))){
                        nonFriends.put(
                                friends.get(i).get(1),
                                nonFriends.get(friends.get(i).get(1)) + 10
                        );
                    } else {
                        nonFriends.put(friends.get(i).get(1), 10);
                    }
                } else if (friends.get(i).get(1).equals(userFriends.get(j))){
                    if (nonFriends.containsKey(friends.get(i).get(0))){
                        nonFriends.put(
                                friends.get(i).get(0),
                                nonFriends.get(friends.get(i).get(0)) + 10
                        );
                    } else {
                        nonFriends.put(friends.get(i).get(0), 10);
                    }
                }
            }
        }

        for (String visitor : visitors){
            if (userFriends.contains(visitor)){
                continue;
            }
            if (nonFriends.containsKey(visitor)){
                nonFriends.put(
                        visitor,
                        nonFriends.get(visitor) + 1
                );
            } else {
                nonFriends.put(visitor, 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(nonFriends.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() != o2.getValue()){
                    return o1.getValue() - o2.getValue();
                }else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        for (Map.Entry<String, Integer> ans : entryList){
            answer.add(ans.getKey());
        }

        System.out.println(userFriends);
        System.out.println(nonFriends);
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args){
//        String user = "mrko";
//        List<List<String>> friends = List.of(
//                List.of("donut", "andole"),
//                List.of("donut", "jun"),
//                List.of("donut", "mrko"),
//                List.of("shakevan", "andole"),
//                List.of("shakevan", "jun"),
//                List.of("shakevan", "mrko")
//        );
//        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");


//        String user = "mrko";
//        List<List<String>> friends = List.of(
//                List.of("mrko", "jun"),
//                List.of("donut", "jun"),
//                List.of("donut", "mrko"),
//                List.of("shakevan", "andole"),
//                List.of("jun", "andole"),
//                List.of("shakevan", "jun"),
//                List.of("shakevan", "mrko")
//        );
//        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("bedi", "jun"),
                List.of("bedi", "donut"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("jun", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("donut", "shakevan");
        List<String> result = List.of("andole", "bedi");

        solution(user, friends, visitors);
    }
}
