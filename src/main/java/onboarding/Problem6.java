package onboarding;

import java.util.ArrayList;
import java.util.List;
/*
- 기능 구현사항 목록 -
1. 이메일값과 닉네임을 따로 저장
2. 닉네임값을 순회하면서 2글자 단위로 완전탐색 -> 인덱스 값 저장
3. 해당 인덱스 값의 이메일을 answer 에 추
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<String>();
        ArrayList<String> email = new ArrayList<String>();
        ArrayList<String> nick = new ArrayList<String>();
        ArrayList<Integer> idx = new ArrayList<Integer>();
        for(List info: forms){
            email.add((String) info.get(0));
            nick.add((String) info.get(1));
        }
        return nick;
    }
}
