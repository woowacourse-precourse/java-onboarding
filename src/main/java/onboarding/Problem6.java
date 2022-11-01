package onboarding;

import org.assertj.core.util.Lists;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        /*
         * 기능 요구 사항
         * 3. 닉네임 중복인 회원의 이메일을 오름차순으로 정렬해서 반환
         * */

        return answer;
    }

    /*
     * 기능 요구 사항
     * 1. 닉네임 글자 중복을 확인하기
     * */

    private static boolean duplicate_str(String str_a, String str_b) {
        for (int i = 0; i < str_a.length() - 1; i++) {
            if (str_b.contains(str_a.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    /*
     * 기능 요구 사항
     * 2. 이메일로 정렬하기
     * */

}
