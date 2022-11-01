package onboarding;

import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int length = word.length();
        // 제한 사항 1 - word는 길이가 1 이상 1,000 이하인 문자열이다.
        if (length > 1000 || length < 1) {
            answer = "word의 길이가 이상합니다.";
            return answer;
        }
        char[] character = word.toCharArray();
        int temp;
        for (char x : character) {
            temp = (int) x;
            // 제한 사항 2- - 알파벳 외의 문자는 변환하지 않는다.
            // 제한 사항 3 - 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
            if (temp >= 65 && temp <= 90) temp = big(temp);
            else if(temp >= 97 && temp <=122) temp = small(temp);
            else {answer += x; continue;}
            answer += (char) temp;
        }
        return answer;
    }
    public static Integer big(Integer c) {
        // 'A'+'Z'의 아스키 코드 값
        int new_c = 155-c;
        return new_c;
    }
    public static Integer small(Integer c) {
        // 'a'+'z'의 아스키 코드 값
        int new_c = 219-c;
        return new_c;
    }

}
