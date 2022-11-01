package onboarding;

import java.util.*;

public class Problem7 {

    /**
     - 목표: 친구 추천 알고리즘
     1) 사용자와 함께 아는 친구의 수 = 10점
     2) 사용자의 타임 라인에 방문한 횟수 = 1점
     3) 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명 리턴

     - 변수 정보:
     1) User : 사용자 아이디
     2) Friends : 친구 관계 정보
     3) Visitors : 사용자 타임 라인 방문 기록

     - 주의 사항:
     1) 추천 점수가 0점이면 추천하지 않음
     2) 추천 점수는 이름순으로 정렬
     3) user : 1~30 문자열
     4) friend : 1 ~ 10000문자열
     5) friends 각 원소 길이 : 2 ( 아이디A, 아이디B ) - A,B는 친구
     6) Visitors : 0 ~ 10000
     7) 사용자 아이디 : 소문자


     **/
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> tenArr = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (List<String> i : friends) {
            if (i.get(0).equals(user)) {
                tenArr.add(i.get(1));
            } else if(i.get(1).equals(user)){
                tenArr.add(i.get(0));
            }
        }

        for (String i : tenArr) {
            for (List<String> j : friends) {
                if (j.get(0).equals(i) && !j.get(1).equals(user)) {
                    if(!hashMap.containsKey(j.get(1))){
                        hashMap.put(j.get(1), 10);
                    } else {
                        Integer n = hashMap.get(j.get(1));
                        n += 10;
                        hashMap.put(j.get(1), n);
                    }
                } else if (j.get(1).equals(i) && !j.get(0).equals(user)) {
                    if(!hashMap.containsKey(j.get(0))){
                        hashMap.put(j.get(0), 10);
                    } else {
                        Integer n = hashMap.get(j.get(0));
                        n += 10;
                        hashMap.put(j.get(0), n);
                    }
                }
            }
        }

        for (String i : visitors) {
            if(!hashMap.containsKey(i)){
                hashMap.put(i, 1);
            } else {
                Integer n = hashMap.get(i);
                n += 1;
                hashMap.put(i, n);
            }
        }

        int number = 0;
        int max = 0;
        int sameMax = 0;

        while (number < 3) {
            String result = "";
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                Integer value = entry.getValue();
                if (value > max) {
                    max = value;
                    result = entry.getKey();
                }
            }
            if(hashMap.containsKey(result)) {
                hashMap.remove(result);
            }
            answer.add(result);
            result = "";
            number++;
            max = 0;
        }

        return answer;
    }
}
