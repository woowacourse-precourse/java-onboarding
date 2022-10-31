package onboarding;
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        /*
        1. 알파벳 내의 문자에 대해서만 반대로 변환하는 함수 작성
          - A : 65 , Z : 90 / a : 97 , z : 122
        2. 문자열을 순회하며 변환 후 반환할 문자열에 누적
        */
        char[] charArray = word.toCharArray();
        for ( char ch : charArray){
            answer += reverse(ch);
        }
        return answer;
    }
    static char reverse(char ch){
        // 알파벳 체크
        if ( ch < 65 || ch > 122 ) return ch;
        
        if ( ch >= 'a' ) return (char)('a' + 'z' - ch);

        return (char)('A' + 'Z' - ch);
    }
}
