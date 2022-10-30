package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String erase(String cryptogram, char target, int len){
        String targetString = Character.toString(target);
        targetString = targetString.repeat(len);
        cryptogram = cryptogram.replaceFirst(targetString, "");

        return cryptogram;
    }
}
