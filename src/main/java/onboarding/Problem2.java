package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2 {
    // 연속된 글자 중복을 제거하는 함수
    // input : 문자열
    // output: 연속이 제거된 문자열
    private static String removeDuplicate(String str) {
        String nextStr = "";
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i ++) {
            char curt = chars[i];

            // 맨 끝이 아닌 경우 다음 원소와 중복검사
            if (i < (chars.length - 1))
                if (curt == chars[i + 1])
                    continue;

            // 맨 앞이 아닌경우 이전 원소와 중복검사
            if (i != 0)
                if (curt == chars[i - 1])
                    continue;

            // 양 옆이 중복이 아닌경우 현재글자 추가
            nextStr += curt;
        }

        return nextStr;
    }

    public static String solution(String cryptogram) {
        String str = cryptogram;

        while (true) {
            String nextStr = removeDuplicate(str);

            if (str.length() == nextStr.length())
                break;

            str = nextStr;
        }
        return str;
    }
}
