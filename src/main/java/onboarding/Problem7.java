package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String, Integer> score = new HashMap<>();
    static List<Map.Entry<String, Integer>> entryList;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> my_friends = new ArrayList<>();

        myFriends(my_friends, user, friends); // 내 친구 목록 추출

        bothFriends(user, my_friends, friends); // 사용자와 함께 아는 친구의 수 점수 계산
        visitFriends(my_friends, visitors); // 사용자의 타임 라인에 방문한 횟수 점수 계산
        sortScore(); // 추천점수 및 이름순 정렬

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

    /**
     * 사용자와 함께 아는 친구 점수 계산 함수
     * @param my_friends
     * @param friends
     * @return HashMap<friend, score>
     */
    public static void bothFriends(String user, List<String> my_friends, List<List<String>> friends) {
        // my_friends에 있는 애가 첫번째나 두번째 항목에 있는 배열만 추출
        for(List<String> relationship : friends) {
            if(!relationship.contains(user)){
                // 아직 친구가 아닌 유저 중 함께 아는 친구가 있는 경우
                if (my_friends.contains(relationship.get(0))) {
                    if(!score.containsKey(relationship.get(1))) score.put(relationship.get(1), 10);
                    else score.put(relationship.get(1), score.get(relationship.get(1)) + 10);

                }
                if (my_friends.contains(relationship.get(1))) {
                    if(!score.containsKey(relationship.get(0))) score.put(relationship.get(0), 10);
                    else score.put(relationship.get(0), score.get(relationship.get(0)) + 10);
                }
            }
        }
    }

    /**
     * 사용자의 타임 라인에 방문한 친구 점수 계산 함수
     * @param my_friends
     * @param visitors
     */
    public static void visitFriends(List<String> my_friends, List<String> visitors) {
        int cnt = 0;
        for(String v : visitors) {
            if(!my_friends.contains(v)) { // 이미 아는 친구가 아닐 경우
                cnt = Collections.frequency(visitors, v);
                score.put(v, cnt * 1); // 사용자의 타임 라인에 방문한 횟수 * 1점
            }
        }
    }

    /**
     * 점수순 정렬 후 이름순 정렬 함수
     */
    public static void sortScore() {
        entryList = new LinkedList<>(score.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }
}
