package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i=0; i<word.length();i++) {
            char tmpChar = word.charAt(i);
            if ((int)tmpChar>=97 && (int)tmpChar<=122) {
                tmpChar = (char) (122 - (int) tmpChar + 97);
            } else if ((int)tmpChar>=65 && (int)tmpChar<=90) {
                tmpChar = (char) (90 - (int) tmpChar + 65);
            }
            answer+=tmpChar;
        }
        return answer;
    }
}
