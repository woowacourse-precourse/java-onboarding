package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String, Integer> score = new HashMap<>();
    static List<Map.Entry<String, Integer>> entryList;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> my_friends = new ArrayList<>();

        myFriends(my_friends, user, friends); // 내 친구 목록 추출

//        bothFriends(user, my_friends, friends); // 사용자와 함께 아는 친구의 수 점수 계산
//        visitFriends(my_friends, visitors); // 사용자의 타임 라인에 방문한 횟수 점수 계산
//        sortScore(); // 추천점수 및 이름순 정렬

//        // 최대 5명 리턴
//        int size = 0;
//        for (Map.Entry<String, Integer> ans : entryList){
//            if (size == 5) break;
//            answer.add(ans.getKey());
//            size++;
//        }
        return answer;
    }

    /**
     * 내 친구 목록 추출
     * @param user
     * @param friends
     * @return
     */
    public static void myFriends(List<String> my_friends, String user, List<List<String>> friends) {
        for(List<String> friend : friends) {
            if(friend.get(0).equals(user)) my_friends.add(friend.get(1));
            if(friend.get(1).equals(user)) my_friends.add(friend.get(0));
        }
    }
}
