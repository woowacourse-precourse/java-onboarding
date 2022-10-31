package onboarding;

public class Problem4 {
    /*
    1. 알파벳인지 검사 후
    2. 알파벳이라면 reversAlphabet() 실행
    3. 알파벳이 아니라면 그대로 StringBuffer에 append
     */
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    // 알파벳(대문자)을 반대쪽 알파벳으로 변환해주는 함수 reversUpperAlphabet()
    private static char reverseUpperAlphabet(char c){
        char result = c;
        if ('A'<=c && c<='Z'){
            result = (char) ('Z'-c+'A');
        }
        return result;
    }

    // 알파벳(소문자)을 반대쪽 알파벳으로 알파벳(대문자)을 반대쪽 알파벳으로 변환해주는 함수 reversLowerAlphabet()
    private static char reverseLowerAlphabet(char c){
        char result = c;
        if ('a'<=c && c<='z'){
            result = (char) ('z'-c+'a');
        }
        return result;
    }
}
