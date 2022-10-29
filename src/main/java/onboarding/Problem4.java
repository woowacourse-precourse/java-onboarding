package onboarding;

import java.util.Scanner;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Encode.validateInput(word);
        answer = Encode.encode(word);
        return answer;
    }
}

class Input4 {
    static String inputWord() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}

class Encode {

    static final int SKIP = 0;
    static final int UPPERCASE = 1;
    static final int LOWERCASE = 2;

    static void validateInput(String word) {
        if (word.length() < 1 || 1000 < word.length()) {
            throw new IllegalStateException("길이가 1이상 1000이하로 입력해 주세요!");
        }
    }

    static String encode(String word) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int encodeType = encodeType(charArray[i]);
            if (encodeType == UPPERCASE) {
                charArray[i] = encodeUpperCase(charArray[i]);
            }
            if (encodeType == LOWERCASE) {
                charArray[i] = encodeLowerCase(charArray[i]);
            }
        }
        StringBuffer encodeResult = new StringBuffer();
        for (int i = 0; i < charArray.length; i++) {
            encodeResult.append(charArray[i]);
        }
        return encodeResult.toString();
    }
    private static int encodeType(char c) {
        if (c < 65) {
            return SKIP;
        }
        if (c < 90) {
            return UPPERCASE;
        }
        if (c < 97) {
            return SKIP;
        }
        if (c < 123) {
            return LOWERCASE;
        }
        return SKIP;
    }

    private static char encodeUpperCase(char c) {
        int standard = ('A' + 'Z') / 2;
        if (c <= standard) {
            standard += (standard - c + 1);
        }
        if (c >= standard) {
            standard -= (c - standard - 1);
        }
        return (char) standard;
    }

    private static char encodeLowerCase(char c) {
        System.out.println("c = " + c);
        int standard = ('a' + 'z') / 2;
        if (c <= standard) {
            standard += (standard - c + 1);
        }
        if (c >= standard) {
            standard -= (c - standard - 1);
        }
        return (char) standard;
    }
}