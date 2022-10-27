package onboarding;

public class Problem4 {

    //대문자 변경
    private static char changeUpper(char upper) {
        int iUpper = (int) upper;
        int iResult = 0;
        iResult = 65 + (90 - iUpper);
        return (char) iResult;
    }

    //소문자 변경
    private static char changeLower(char lower) {
        int iLower = (int) lower;
        int iResult = 0;
        iResult = 97 + (122 - iLower);
        return (char) iResult;
    }

    
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
