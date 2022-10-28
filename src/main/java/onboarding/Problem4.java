package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        if (checkValidation(word)) {

        } else {
            answer = "-1";
        }

        return answer;
    }

    public static boolean checkValidation(String inputString) {
        int inputStringLength = inputString.length();

        // 길이가 1 이상 1,000 이하인지 확인한다.
        if (!(1 <= inputStringLength && inputStringLength <= 1000)) {
            return false;
        }

        return true;
    }
}
