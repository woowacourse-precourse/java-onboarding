package onboarding;

public class Problem4 {

    static char[] upperCaseList = new char[26];
    static char[] lowerCaseList = new char[26];
    public static String solution(String word) {
        String answer = "";
        for (int i=0; i<26; i++) {
            upperCaseList[i] = (char)(i+65);
            lowerCaseList[i] = (char)(i+97);
        }
        return answer;
    }
}
