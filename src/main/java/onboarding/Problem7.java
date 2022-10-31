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

        friendScore(user, hm, tm);              // 친구의 친구 점수 추가
        visitScore(user, visitors, hm, tm);     // 방문자 점수 추가
        makeAnswer(answer, tm);                 // 정답 산출

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

    // user의 친구와 친구인 경우 10점 추가
    // 점수를 받는 사람이 user인 경우와 이미 user의 친구인 경우 점수 X
    private static void friendScore(String user, Map<String, List<String>> hm, Map<String, Integer> tm) {
        if (hm.containsKey(user)) {
            List<String> li = hm.get(user);
            for (String str : li) {
                List<String> tmp = hm.get(str);

                for (String s : tmp) {
                    if (!s.equals(user) && !li.contains(s)) {
                        tm.put(s, tm.getOrDefault(s, 0) + 10);
                    }
                }
            }
        }
    }

    // 방문자 중에서 이미 user와 친구인 경우를 제외하고 점수 1점 추가
    private static void visitScore(String user, List<String> visitors, Map<String, List<String>> hm, Map<String, Integer> tm) {
        List<String> li = new ArrayList<>();
        if(hm.containsKey(user)){
            li = hm.get(user);
        }

        for(String str : visitors){
            if(!str.equals(user) && !li.contains(str)){
                tm.put(str, tm.getOrDefault(str, 0) + 1);
            }
        }
    }

    // 트리맵을 정렬하고 최대 5개까지 정답 리스트에 추가
    private static void makeAnswer(List<String> answer, Map<String, Integer> tm) {
        List<String> keySet = new ArrayList<>((tm.keySet()));
        keySet.sort((o1, o2) -> tm.get(o2).compareTo(tm.get(o1)));

        int idx = 0;
        for(String str : keySet){
            if(idx == 5){
                break;
            }
            answer.add(str);
            idx++;
        }
    }
}
