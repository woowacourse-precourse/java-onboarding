package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))) // 문자가 대문자일 경우
                answer+=(char)('A'+'Z'-word.charAt(i));
            else if(Character.isLowerCase(word.charAt(i))) // 문자가 소문자일 경우
                answer+=(char)('a'+'z'-word.charAt(i));
            else // 문자가 알파벳 이외의 문자일 경우
                answer+=word.charAt(i);
        }
        return answer;
    }
}
