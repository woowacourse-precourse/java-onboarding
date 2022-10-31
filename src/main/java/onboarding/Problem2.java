package onboarding;

import java.util.Stack;

public class Problem2 {
    private static final Stack<Integer> start = new Stack<>();
    private static final Stack<Integer> end = new Stack<>();
    public static String solution(String cryptogram) {
        // 오류 시 error 반환은 스스로 판단하여 구현한 것.
        if (!isValidate(cryptogram)) {
            return "error";
        }
        return removeDuplicated(cryptogram);
    }

    /**
     * 제한사항 검증하는 기능
     */
    private static boolean isValidate(String cryptogram) {
        return (validateLength(cryptogram) && isLowerCase(cryptogram));
    }

    private static boolean validateLength(String cryptogram) {
        int length = cryptogram.length();
        return (length > 0 && length < 1001);
    }

    private static boolean isLowerCase(String cryptogram) {
        char[] cryptoTemp = cryptogram.toCharArray();
        for (char ch : cryptoTemp) {
            if (!isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLowerCase(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    /**
     * 중복되는 문자열 찾아서 제거
     */
    private static String removeDuplicated(String cryptogram) {
        String result = cryptogram;
        while (start.size() != 0 || findRange(result)) {
            String substring = result.substring(start.pop(), end.pop());
            result = result.replace(substring, "");
        }
        return result;
    }

    private static boolean findRange(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            char ch = cryptogram.charAt(i);
            int endTemp = findEnd(cryptogram, i, ch);
            if (i != endTemp - 1) {
                pushStack(i, endTemp);
                i = endTemp;
            }
        }
        return (start.size() != 0);
    }

    private static int findEnd(String cryptogram, int index, char ch) {
        char[] toCharArray = cryptogram.toCharArray();
        while (index < toCharArray.length && toCharArray[index] == ch) {
            index++;
        }
        return index;
    }

    private static void pushStack(int startTemp, int endTemp) {
        start.push(startTemp);
        end.push(endTemp);
    }
}
