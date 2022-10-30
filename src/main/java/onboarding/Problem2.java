package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    static ArrayList<Character> cryptogramList = new ArrayList<>();
    static Stack<String> stateRecord = new Stack<>();

    public static String solution(String cryptogram) {
        String answer = "answer";
        addCryptogramList(cryptogram);
        decoding(cryptogram);
        answer = decodingResult();
        cryptogramList.clear();
        return answer;
    }

    public static void addCryptogramList(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            cryptogramList.add(cryptogram.charAt(i));
        }
    }

    public static void decoding(String cryptogram) {
        while (compareChar(cryptogram) != 0) {
            stateRecord.clear();
            compareChar(cryptogram);
        }
    }

    public static String decodingResult() {
        String result = "";
        for (char decodedChar : cryptogramList) {
            result += decodedChar;
        }
        return result;
    }

    public static int compareChar(String cryptogram) {
        int count = 0;

        for (int a = 0; a < cryptogramList.size() - 1; ) {
            char firstChar = cryptogramList.get(a);
            char nextChar = cryptogramList.get(a + 1);

            if (isSame(firstChar, nextChar)) {
                executeIfSame(a + 1);
                count++;
            }
            if (!isSame(firstChar, nextChar)) {
                executeIfDifferent(a);
                a++;
            }
        }
        checkLastOne();
        return count;
    }

    public static void checkLastOne() {
        int listSize = cryptogramList.size();
        if (listSize > 0 && wasRemoved()) {
            cryptogramList.remove(listSize - 1);
        }
    }

    public static boolean isSame(char firstChar, char nextChar) {
        if (firstChar == nextChar) {
            return true;
        }
        return false;
    }

    public static void executeIfSame(int num) {
        removeDuplicates(num);
        addState("remove");
    }

    public static void executeIfDifferent(int num) {
        if (wasRemoved()) {
            removeDuplicates(num);
        }
        addState("save");
    }

    public static void removeDuplicates(int num) {
        cryptogramList.remove(num);
    }

    public static void addState(String state) {
        stateRecord.add(state);
    }

    public static boolean wasRemoved() {
        if (stateRecord.empty()) {
            return false;
        }
        if (stateRecord.peek().equals("remove")) {
            return true;
        }
        if (stateRecord.peek().equals("save")) {
            return false;
        }
        return false;
    }

}