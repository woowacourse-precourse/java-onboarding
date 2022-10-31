package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return StringParser.parsing(cryptogram);
    }

    static class StringParser {

        private StringParser() {
        }

        private static String parsing(String str) {
            Stack<String> strStack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                String temp = String.valueOf(str.charAt(i));
                boolean isFirst = true;
                if (isLast(str, i) || !String.valueOf(str.charAt(i + 1)).equals(temp)) {
                    while (!strStack.empty() && strStack.peek().equals(temp)) {
                        strStack.pop();
                        isFirst = false;
                    }
                }
                if (isFirst) {
                    strStack.push(temp);
                }
            }
            return strStack.stream()
                    .reduce("", (a, b) -> a + b);
        }

        private static boolean isLast(String str, int idx) {
            return str.length() - 1 == idx;
        }
    }
}
