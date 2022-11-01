package onboarding;

import java.util.*;

public class Problem6 {
    /* 기능단위
    * 1. 이름을 2글자씩 분할 (divideNameByTwoChars)
    * 2. 1에서 2글자씩 분할한 글자가 forms의 name에 포함되어 있는 이메일 찾기 (findEmailContainWord)
    * 3. 2에서 구한 이메일들의 중복 제거 (removeDuplicatedEmail)
    * */

    private static List<String> divideNameByTwoChars(List<String> form) {
        List<String> dividedName = new ArrayList<>();
        String name = form.get(1);
        int nameLength = name.length();
        for(int i = 0; i < nameLength - 1; i++) {
            dividedName.add(name.substring(i, i+2));
        }
        return dividedName;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> words;
        List<String> email;

        for(List<String> form: forms) {
            words = divideNameByTwoChars(form);
        }
        return answer;
    }
}
