package onboarding;

import javax.swing.*;
import java.util.*;

/*
##기능 목록
1. 모든 사용자의 아이디(Key : String)와 친구 목록(Value : List<String>)을 HashMap에 저장
2. 1번 규칙. 주어진 사용자의 친구가 아닐 때, 함께 아는 친구의 수를 계산해 점수 계산
3. 2번 규칙. 방문자 중, 사용자의 친구가 아닐 때, 점수 계산
4. 결과 List 정렬 및 Resize

 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, List<String>> relation = initHashMap(friends);
        HashMap<String, Integer> point = new HashMap<>();
        return answer;
    }

    public static HashMap<String, List<String>> initHashMap(List<List<String>> friends) {
        HashMap<String, List<String>> relation = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            String userA = friends.get(i).get(0);
            String userB = friends.get(i).get(1);
            if (!relation.containsKey(userA)) {
                List<String> newList = new ArrayList<>();
                relation.put(userA, newList);
            }
            relation.get(userA).add(userB);

            if (!relation.containsKey(userB)) {
                List<String> newList = new ArrayList<>();
                relation.put(userB, newList);
            }
            relation.get(userB).add(userA);
        }
        return relation;
    }
}
