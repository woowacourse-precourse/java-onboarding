package onboarding;

public class Problem2 {
    public static boolean validateInput(String cryptogram) {
        if (cryptogram.length() > 1000 || cryptogram.length() < 1)
            return false;
        String[] strArray = cryptogram.split("");
        for(String s : strArray) {
            if (!Character.isLowerCase(s.charAt(0)))
                return false;
        }
        return true;
    }
    public static int getRepeatEndIndex(StringBuilder answer, int index) {
        while (index > 0) {
            if (answer.charAt(index) == answer.charAt(index - 1))
                return index;
            index --;
        }
        return -1;
    }
    public static int getRepeatStartIndex(StringBuilder answer, int repeatIndex) {
        char repeatChar = answer.charAt(repeatIndex);
        for (int index = repeatIndex - 1; index >= -1; index--) {
            if (index == -1 || answer.charAt(index) != repeatChar)
                return index + 1;
        }
        return repeatIndex;
    }
    public static boolean removeRepeatChar(StringBuilder answer) {
        boolean repeat = false;
        for (int index = answer.length() - 1; index > 0; index--) {
            int repeatEndIndex = getRepeatEndIndex(answer, index);
            if (repeatEndIndex == -1)
                continue;
            int repeatStartIndex = getRepeatStartIndex(answer, repeatEndIndex - 1);
            answer.delete(repeatStartIndex, repeatEndIndex + 1);
            index = repeatStartIndex;
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
