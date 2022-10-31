package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        replaceTargetChar(cryptogram, 'o');

        return answer;
    }

    public static String replaceTargetChar(String cryptogram, char targetChar){
        String targetAlpha = Character.toString(targetChar);

        String resultCryptogram = cryptogram.replaceAll(targetAlpha+"{2,}", "");
        System.out.println(resultCryptogram);
        return resultCryptogram;
    }
}
