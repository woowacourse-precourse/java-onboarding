package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<word.length(); i++) {
            char current = word.charAt(i);  //i번째 index 배열 접근이 많으므로 변수로 선언
            if (current>='A' & current<='Z' | current>='a' & current<='z') {    //알파벳인 경우
                if (Character.isUpperCase(current)) current = (char) ('A'+'Z'-current);         //대문자 변경
                else if (Character.isLowerCase(current)) current = (char) ('a'+'z'-current);    //소문자 변경
            }
            answer.append(current);
        }
        return answer.toString();
    }
}
