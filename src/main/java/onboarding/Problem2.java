package onboarding;


import java.util.Stack;
import java.util.stream.Stream;

public class Problem2 {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final String ERROR = "ERROR";

    public static String solution(String cryptogram) {
        String answer;

        if (exception(cryptogram)) {
            return ERROR;
        }
        answer = decryptPassword(cryptogram);

        return answer;
    }

    private static boolean exception(String cryptogram) {
        if (cryptogram.length() < MIN_LENGTH || MAX_LENGTH < cryptogram.length()) {
            return true;
        }
        for (char c : cryptogram.toCharArray()) {
            if (!(Character.isLowerCase(c))) {
                return true;
            }
        }
        return false;
    }

    private static String decryptPassword(String cryptogram) {
        Stack<String> duplicate;
        String result = cryptogram;

        while (checkDuplicate(result)) {
            duplicate = duplicateStr(result);
            result = deleteDuplicate(duplicate, result);
        }

        return result;
    }

    private static boolean checkDuplicate(String str) {
        char front_char;
        char back_char;

        for (int i = 0; i < str.length() - 1; i++) {
            front_char = str.charAt(i);
            back_char = str.charAt(i + 1);

            if (front_char == back_char) {
                return true;
            }
        }
        return false;
    }

    private static Stack<String> duplicateStr(String str) {
        String front_char;
        String back_char;
        Stack<String> result = new Stack<>();

        for (int i = 0; i < str.length() - 1; i++) {
            front_char = "" + str.charAt(i);
            back_char = "" + str.charAt(i + 1);

            if (front_char.equals(back_char)) {
                result.push(front_char + back_char);
            }
        }
        return result;
    }

    private static String deleteDuplicate(Stack<String> duplicate, String str) {
        String result = str;

        while (!duplicate.empty()) {
            result = result.replaceAll(duplicate.pop(), "");
        }
        return result;
    }


}
