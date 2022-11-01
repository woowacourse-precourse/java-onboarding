package onboarding;

public class Problem2 {
    public static boolean validateInput(String cryptogram) {
        if (cryptogram.length() > 1000 || cryptogram.length() < 1)
            return false;
        else if (!cryptogram.toLowerCase().equals(cryptogram))
            return false;
        return true;
    }
    public static boolean removeRepeatChar(StringBuilder answer) {
        boolean repeat = false;
        for (int index = answer.length() - 1; index > 0; index--) {
            if (answer.charAt(index) != answer.charAt(index - 1))
                continue;
            char repeatChar = answer.charAt(index);
            while (index >= 0 && answer.charAt(index) == repeatChar) {
                answer.deleteCharAt(index);
                index--;
            }
            repeat = true;
        }
        return repeat;
    }
    public static String solution(String cryptogram) {
        if (!validateInput(cryptogram))
            return "";
        StringBuilder answer = new StringBuilder(cryptogram);
        boolean repeat = true;
        while (repeat) {
            repeat = removeRepeatChar(answer);
        }
        return answer.toString();
    }
}
