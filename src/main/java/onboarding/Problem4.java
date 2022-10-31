package onboarding;

import java.util.ArrayList;
import java.util.Collections;

public class Problem4 {

    static final String ERROR = "ERROR";
    static final int ASCII_MAX = 256;
    static final int NO_CHANGE = -1;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 1001;
    private final static int ALPHABAT_MAX = 26;

    public static String solution(String word) {
        String answer;

        if (exception(word)) {
            return ERROR;
        }

        answer = reverseStr(word);

        return answer;
    }

    static boolean exception(String word) {
        return (MIN_NUMBER < word.length() && word.length() < MAX_NUMBER)
            ? false : true;
    }

    static String reverseStr(String word) {
        String result = "";
        ArrayList<Integer> asciiArray = initAscii();

        for (char c : word.toCharArray()) {
            if (asciiArray.get(c) != NO_CHANGE) {
                result += Character.toString(asciiArray.get(c));
            } else if (asciiArray.get(c) == NO_CHANGE) {
                result += c;
            }
        }
        return result;
    }

    static ArrayList<Integer> initAscii() {
        ArrayList<Integer> result = new ArrayList<>(
            Collections.nCopies(ASCII_MAX, NO_CHANGE)
        );
        for (int i = 0; i < ALPHABAT_MAX; i++) {
            result.set('A' + i, 'Z' - i);
            result.set('a' + i, 'z' - i);
        }
        return result;
    }


}
