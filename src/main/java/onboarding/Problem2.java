package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!validCryptogram(cryptogram.toCharArray())) {
            return "error";
        }

        String answer = cryptogram;
        String after = "";
        while (true) {
            after = removeStr(answer.toCharArray());
            if (after.equals(answer)) {
                answer = after;
                break;
            }
            answer = after;
        }
        return answer;
    }

    public static boolean validCryptogram(char [] cryptogram) {
        for (char c : cryptogram) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    public static String removeStr(char [] str) {
        if (str.length < 2) {
            return new String(str);
        }
        char pre = 0;
        int j = 0;
        boolean isOverlap = false;
        for (char s : str) {
            if (pre != s) {
                if (isOverlap) {
                    isOverlap = false;
                    j--;
                }
                str[j++] = s;
                pre = s;
            } else {
                isOverlap = true;
            }
        }
        if (isOverlap) {
            j--;
        }
        return new String(str).substring(0,j);
    }
}
