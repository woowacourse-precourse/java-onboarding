package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();
        chk_user_friend(user, friends, score);

        List<String> alr_frd=new ArrayList<>();
        /*친구의 친구 찾기*/
        findFF(friends, score, alr_frd);
        /*방문자 점수 올리기*/
        for (String s : visitors) {
            if (score.containsKey(s)) { // 키가 있다면
                score.replace(s, score.get(s) + 1);
            } else {
                score.put(s,1);
            }
        }
        score.remove(user); // 사용자 본인은 제외하고

        List<String> tmp=new ArrayList<>();
        /*사용자와 직접 친구인 사람들 제거*/
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            if (entry.getValue()<=0) {          // 점수가 0점이거나 그 이하(직접적인 친구) 일 경우 제거하기 위해서
                tmp.add(entry.getKey());
            }
        }

        for (String s : tmp) {
            score.remove(s);
        }
        /*정답행렬에 복사하기*/
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); // 이름순 정렬 구현은?
        for (Map.Entry<String, Integer> stringIntegerEntry : entryList) {
            answer.add(stringIntegerEntry.getKey());
        }
        /*제한조건 체크*/
        if (answer.size() > 5) {
            return answer.subList(0, 6);
        } else return answer;
    }
    /**친구의 친구 찾아서 점수 업데이트**/
    private static void findFF(List<List<String>> friends, HashMap<String, Integer> score, List<String> alr_frd) {
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            String Key = entry.getKey();
            alr_frd.add(Key);
        }
        for (String s : alr_frd) {
            for (int i = 0; i < friends.size(); i++) {
                List<String> relationship = friends.get(i); // 리스트의 관계도
                String a = relationship.get(0);
                String b = relationship.get(1);

                if (a.equals(s)) { // 이미 친구인 크루의 관계도가 발견되면
                    if (score.containsKey(b)) { // 이미 점수가 있으면
                        score.replace(b, score.get(b) + 10);
                    } else {
                        score.put(b, 10);
                    }
                } else if (b.equals(s)) {

                    if (score.containsKey(a)) {
                        score.replace(a, score.get(a) + 10);
                    } else {
                        score.put(a, 10);
                    }
                }
            }
        }
    }

    /**
     * 사용자와 이미 친구인 크루의 점수를 최소값으로 초기화
     **/
    private static void chk_user_friend(String user, List<List<String>> friends, HashMap<String, Integer> score) {
        /*사용자와 이미 친구인 경우는 제외하여야 한다*/
        for (int i = 0; i < friends.size(); i++) {
            List<String> relation = friends.get(i);
            for (int j = 0; j < 2; j++) {
                String currName = relation.get(j);
                if (currName.equals(user)) {            // 이미 친구인 경우를 처리
                    if (j == 0) {
                        score.putIfAbsent(relation.get(1), Integer.MIN_VALUE);
                    } else {
                        score.putIfAbsent(relation.get(0), Integer.MIN_VALUE);
                    }
                }
            }
        }
    }
}
