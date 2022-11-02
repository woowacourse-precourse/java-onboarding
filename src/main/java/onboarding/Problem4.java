package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer;
        Conversion conversion = new Conversion(word);

        if(conversion.exception() == -1) {
            answer = "***** Error *****";
        } else {
            answer = conversion.convert();
        }

        return answer;
    }
}
