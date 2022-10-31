package onboarding;

import java.util.ArrayList;
import java.util.List;
// 1. 문자열 분리하는 메소드
// 2. 중복된 글자를 없애주는 메소드
// 3. 중복 없어진 메소드를 출력함 -> solution

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static List<String> cryptoSplit(String s){ //문자열 분리 메소드
        String[] arr = s.split("");
        List<String> list = new ArrayList<>();
        for(String s1 : arr) list.add(s1);
        return list;

    }

}
