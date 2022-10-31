package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        try {
            validation(cryptogram);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        String answer = decode(cryptogram);
        return answer;
    }

    public static void validation(String str) {
        if ((str.length() < 0) && (str.length() > 1000)) {
            throw new IllegalArgumentException("길이가 1 이상 1000 이하인 문자열만 입력 가능합니다.");
        }
        if (!isAllSmallLetter(str)) {
            throw new IllegalArgumentException("문자열은 알파벳 소문자로만 이루어져야 합니다.");
        }
    }

    public static boolean isAllSmallLetter(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (((int) str.charAt(i) < 97) || ((int) str.charAt(i) > 122))
                return false;
        }
        return true;
    }

    public static String decode(String str) {
        while (haveDuplicate(str)) {
            str = deleteDuplicate(str);
        }
        return str;
    }

    public static boolean haveDuplicate(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return true;
        }
        return false;
    }

    public static String deleteDuplicate(String str) {
        String newString = "";
        char tmp = ' ';
        for (int i = 0; i < str.length() - 1; i++) {
            if ((str.charAt(i) != str.charAt(i + 1)) && (tmp != str.charAt(i)))
                newString += str.charAt(i);
            tmp = str.charAt(i);
        }

        if (str.charAt(str.length() - 2) != str.charAt(str.length() - 1))
            newString += str.charAt(str.length() - 1);

        return newString;
    }
}
