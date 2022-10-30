package onboarding;

import java.util.*;


/*
* 약어
* sn : Substring Name(이름의 부분 문자열)
* */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /*
     * 이름에서 두 자리 이상의 부분 문자열을 구해 리스트로 반환한다.
     * */
    private static List<String> subName(String name) {
        List<String> sub = new ArrayList<>();
        int n = name.length();
        for (int i = 2; i <= n; i++) { // 크기
            for (int j = 0; i + j <= n; j++) { // 위치
                if (n - j >= 2) {
                    sub.add(name.substring(j, i + j));
                }
            }
        }
        return sub;
    }
}
