package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0;i<word.length();i++){
            char curChar = word.charAt(i);
            if(curChar >= 'A' && curChar <= 'Z') {
                char transChar = (char) ('Z' - curChar + 'A');
                answer += transChar;
            } else if (curChar >= 'a' && curChar <= 'z') {
                char transChar = (char) ('z' - curChar + 'a');
                answer += transChar;
            } else {
                answer += curChar;
            }
        }
        return answer;
    }
}
