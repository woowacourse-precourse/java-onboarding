package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

/*
    기능 명세
    1. continuous(List<List<String>> forms) : 글자가 연속적으로 포함된 닉네임을 찾는 함수
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return continuous(forms);
    }

    public static List<String> continuous(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        Hashtable<String, Integer> ht = new Hashtable<>(); // 닉네임, 중복 횟수
        String nickname, split;
        int count;
        // 닉네임을 key로, 중복 횟수를 value로 하는 해시테이블 생성
        for(List<String> form : forms) {
            nickname = form.get(1);
            if(nickname.length() < 2) continue; // 닉네임이 2글자 미만이면 패스
            for(int i = 0; i < nickname.length() - 1; i++) {
                split = nickname.substring(i, i + 2);
                count = ht.containsKey(split) ? ht.get(split) : 0;
                ht.put(split, count + 1);
            }
        }
        // 중복 횟수가 2회 이상인 닉네임을 result에 추가
        for(List<String> form : forms) {
            nickname = form.get(1);
            for(int i = 0; i < nickname.length() - 1; i++) {
                split = nickname.substring(i, i + 2);
                count = ht.get(split);
                if(count >= 2) {
                    result.add(form.get(0));
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
