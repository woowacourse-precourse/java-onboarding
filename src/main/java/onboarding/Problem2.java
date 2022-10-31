package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static boolean isContinuitySubstring(String substring) {
        return substring.charAt(0) == substring.charAt(1);
    }

    public static String removeContinuity(String subString, char c){
        int index = subString.indexOf(c);
        while(index == 0){
            subString = subString.substring(1);
            index = subString.indexOf(c);
        }
        return subString;
    }
}
