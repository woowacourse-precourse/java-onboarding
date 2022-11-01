package onboarding;
/*
기능 목록
1. 연속된 중복 문자 확인
2. 연속된 문자열 제거
3. 알파벳인지 확인
4. 알파벳 소문자인지 확인
5. 문자열 길이가 1 ~ 1000자 이하인지 확인
 */
public class Problem2 {
    public static boolean isAlphaAndLowerCase(String s){
        for(char c:s.toCharArray()){
            if(!('a'<=c && c <='z')){
                return false;
            }
        }
        return true;
    }
    public static String solution(String cryptogram) {
        String answer = "wrong";

        if(isAlphaAndLowerCase(cryptogram)){
            return answer;
        }

        if(cryptogram.length()>1000){
            return answer;
        }
        return cryptogram;
    }
}
