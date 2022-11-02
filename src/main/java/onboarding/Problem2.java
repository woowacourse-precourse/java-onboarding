package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        Duplicate duplicate = new Duplicate(cryptogram);

        if(duplicate.exception() == -1) {
            answer = "***** Error *****";
        } else {
            answer = duplicate.duplicate();
        }

        return answer;
    }
}
