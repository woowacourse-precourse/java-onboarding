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

    public static int countDuplicate(String str, int target){
        int len = 1;
        for (int i = target; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                len++;
            } else {
                break;
            }
        }

        return len;
    }
}
