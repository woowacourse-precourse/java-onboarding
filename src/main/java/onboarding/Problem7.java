package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    // 전체 아이디, 전체 점수 포함하는 리스트 만들기
    // 모든 friends 목록을 탐색하면서 모든 친구들을 담는 리스트 만들기
    // 함께 아는 친구를 담는 리스트 만들기 (user와 다른 사람들 모두 이미 친구인 사람 인원수)
    // friends에서 user -> user의 친구 -> 친구의 친구들에게 10점을 주기
    // 마지막에는 인덱스가 5를 넘어가면 잘라내기로 함, 추천 친구가 없으면 없는 채로 반환

    public static List<String> getFriends(List<List<String>> friends, String user) {
        List<String> allId = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++) {
            for(int j = 0; j < 2; j++) {
                if(!friends.get(i).contains(user)) {
                    allId.add(friends.get(i).get(j));
                }
            }
        }
        return allId;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> allId = new ArrayList<>();
        List<Integer> allScore = new ArrayList<>();
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
