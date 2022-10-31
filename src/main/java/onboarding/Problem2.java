package onboarding;

public class Problem2 {
    public static boolean isOverlap(String target) {
        for (int i = 0; i < target.length() - 1; i++) {
            if (target.charAt(i) == target.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

/*    public static String removeOverlap(String target) {
        String result = target;
        for (int i = 0; i < result.length(); i++) {

        }
    }*/

    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = cryptogram;
        while(isOverlap(answer)) {
            //중복 제거
        }

        return answer;
    }
}
