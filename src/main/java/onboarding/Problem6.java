package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    /**
     [기능목록]
     1. 닉네임을 연속 문자 단위로 나누어서 해쉬맵에 개수 저장
     2. 연속 문자가 2명 이상 겹치는 경우 연속 문자가 포함된 닉네임의 이메일 answer에 추가하기
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> crews = new HashMap<>(); // 크루들 이메일과 닉네임 저장
        HashMap<String, Integer> nickname = new HashMap<>(); // 크루들 닉네임 연속문자 단위로 저장

        // 1. 닉네임을 연속 문자 단위로 나누어서 해쉬맵에 개수 저장
        for(List<String> list : forms) {
            for(int i = 0; i < list.get(1).length() - 1; i++) { // 크루들 닉네임으로 반복문 돌아서
                // 닉네임을 연속 문자 단위로 나눠서 해쉬맵에 저장 (값이 있는 경우 원래값에 +1, 없는 경우 0+1)
                nickname.put(list.get(1).substring(i, i + 2), nickname.getOrDefault(list.get(1).substring(i, i + 2), 0) + 1);
            }
            crews.put(list.get(1), list.get(0)); // answer에 크루 이메일 출력하기 위해 이메일, 닉네임으로 이루어진 해쉬맵에 put하기
        }

        // 2. 연속 문자가 2명 이상 겹치는 경우 연속 문자가 포함된 닉네임의 이메일 answer에 추가하기
        for(List<String> list : forms) {
            for(int i = 0; i < list.get(1).length() - 1; i++) {
                if(nickname.get(list.get(1).substring(i, i + 2)) >= 2) { // 2명이상 연속문자가 겹쳐야 하므로 2이상일 때 answer에 더해줌
                    answer.add(crews.get(list.get(1)));
                    break; // 중복을 포함하지 않기 위해 한 번 넣었으면 break로 다음 문장으로 넘어가게 함
                }
            }
        }

        Collections.sort(answer); // 이메일을 오름차순으로 정렬하기 위함
        return answer;
    }
}
