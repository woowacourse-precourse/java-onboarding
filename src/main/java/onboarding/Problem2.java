package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String subString = "";
        String tmpAnswer = answer;
        boolean isComplete = false;

        while (!isComplete) {
            tmpAnswer = answer;
            if (cryptogram.length() == 2 && cryptogram.charAt(0) == cryptogram.charAt(1)) {
                answer = "";
                break;
            }
            else {
                for (int i = 1; i < cryptogram.length() - 1; i++) {
                    if (cryptogram.charAt(i) == cryptogram.charAt(i + 1) || cryptogram.charAt(i) == cryptogram.charAt(i - 1))
                        subString += cryptogram.charAt(i);
                }
            }

            answer = cryptogram.replaceAll(subString, "");
            cryptogram = answer;

            if (tmpAnswer.equals(answer)) {    // 이전 값과 같으면 바뀐 것이 없으므로
                isComplete = true;
            }
            subString = "";
        }

        return answer;
    }
}
