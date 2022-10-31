package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // 예외 처리 : 1 이상 1000 이하인 문자열 들어오면
        if(word.length() < 1 || word.length() > 1000)
            return "입력하는 문자열의 길이는 반드시 1 이상 1000 이하여야 합니다.";

        // 거꾸로 변환된 청개구리 문자열을 얻어 반환한다.
        answer = getReversedString(word);
        return answer;
    }

    static String getReversedString(String word) {
        /* start of loop */
        String str = "";

        int len = word.length();
        char c;
        for(int i = 0; i < len; ++i)
        {
            c = word.charAt(i);
            // 대문자라면 ?? - 아스키 코드
            if(c >= 65 && c <= 90) // 65 = 'A' , 90 = 'Z'
            {
                c = (char) (90 - c + 65);
                str += c;
                continue;
            }

            // 소문자라면 ?? - 아스키 코드
            if(c >= 97 && c <= 122) // 97 = 'a' , 122 = 'z'
            {
                c = (char) (122 - c + 97);
                str += c;
                continue;
            }

            // 다른 종류의 문자라면 ? 그대로 추가
            str += c;
        } /* end of loop */

        return str;
    }
}
