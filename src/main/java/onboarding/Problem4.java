package onboarding;
//아스키 코드값을 이용하여 반대로 알파벳 출력 ( 대문자는 대문자, 소문자는 소문자)
// 대문자 A~Z : 65~90 / 소문자 a~z : 97~122
// 1. 소문자와 대문자 구분
// 2. 구분 후 알파벳 거꾸로 출력되도록 처리
// 3. 문자 -> 문자열로 다시 변환
public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        char[] wordArr = word.toCharArray();
        for (char code : wordArr) {
            if(code >= 65 && code <=90){
                answer.append((char)(90 - (code - 65)));
            } else if (code >= 97 && code <= 122){
                answer.append((char)(122 - (code - 97)));
            //공백 또는 이외의 문자
            } else {
                answer.append(code);
            }
        }
        return answer.toString();
    }
}
