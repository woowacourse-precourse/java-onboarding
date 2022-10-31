package onboarding;

import java.util.*;
/*
 * 1. 친구관계를 저장하는 해시맵과 점수를 저장하는 트리맵 선언
 * 2. 양방향 친구관계를 해시맵에 저장
 * 3. user의 친구와 친구관계인 경우 점수 추가
 * 4. visiters 배열 점수 추가
 * 5. 트리맵을 정렬하여 정답 출력
 * */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> hm = makeRelation(friends);
        Map<String, Integer> tm = new TreeMap<>();

        return answer;
    }
    // 해시맵에 {이름 : {친구인 사람들}} 형식으로 저장
    private static Map<String, List<String>> makeRelation(List<List<String>> friends) {
        Map<String, List<String>> hm = new HashMap<>();

        for(List<String> li : friends){
            List<String> from = hm.getOrDefault(li.get(0), new ArrayList<>());
            List<String> to = hm.getOrDefault(li.get(1), new ArrayList<>());

            from.add(li.get(1));
            to.add(li.get(0));

            hm.put(li.get(0), from);
            hm.put(li.get(1), to);
        }
        return hm;
    }
}
