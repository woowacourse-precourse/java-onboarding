package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String manipulateString = cryptogram;
        int curIdx = 0;

        while (curIdx < manipulateString.length()){
            String postProcessedString = replaceTargetChar(manipulateString, manipulateString.charAt(curIdx));

            if (postProcessedString.equals(manipulateString)){
                curIdx++;
            } else {
                manipulateString = postProcessedString;
                curIdx = 0;
            }
        }

        answer = manipulateString;
        return answer;
    }

    public static String replaceTargetChar(String cryptogram, char targetChar){
        String targetAlpha = Character.toString(targetChar);

        String resultCryptogram = cryptogram.replaceAll(targetAlpha+"{2,}", "");
        return resultCryptogram;
    }
}
