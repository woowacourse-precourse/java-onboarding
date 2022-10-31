package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = removeConsecutiveCharacters(cryptogram);
        return answer;
    }

    //연속된 소문자 처리 재귀적 메소드
    public static String removeConsecutiveCharacters(String str){

        //연속된 소문자 처리
        String removedStr = str.replaceAll("([a-z])\\1+","");
        if(str.length()==removedStr.length()) return str;
        else return removeConsecutiveCharacters(removedStr);

    }
}
