package onboarding;

import java.util.InputMismatchException;

public class Problem4 {


    static class ReverseAlphabet {

        final char START_CHAR = 'A';
        final char END_CHAR = 'Z';

        final char DIFF_A_Z = (char) (END_CHAR - START_CHAR);

        private char value;

        public ReverseAlphabet(char value) {
            if (!Character.isAlphabetic(value)) {
                throw new RuntimeException("ReverseAlphabet에 Alphabet이 아닌 다른 문자가 들어왔습니다.");
            }
            this.value = value;
        }

        public char result() {
            return reverse(value);
        }

        public char reverse(char ch) {
            if (Character.isLowerCase(ch)) {
                return Character.toLowerCase(reverse(Character.toUpperCase(ch)));
            }
            if (isLeftCharacter(ch)) {
                return reverseFromLeft(ch);
            }

            return reverseFromRight(ch);
        }

        private char reverseFromLeft(char ch) {
            return (char) (ch - START_CHAR + END_CHAR);
        }

        private char reverseFromRight(char ch) {
            return (char) (END_CHAR - ch + START_CHAR);
        }

        private boolean isLeftCharacter(char ch) {
            return ch < centerValue();
        }

        private int centerValue() {
            return DIFF_A_Z / 2;
        }
    }

    public static ReverseAlphabet makeReverseAlphabet(char ch) {
        return new ReverseAlphabet(ch);
    }

    static class ReverseString {

        final int START_RANGE = 1;
        final int END_RANGE = 1_000;

        private String value;

        public ReverseString(String value) {
            if (!isValidLength(value)) {
                throw new InputMismatchException("입력된 문자열의 크기가 [1,1000] 이내가 아닙니다.");
            }
            this.value = value;
        }

        private boolean isValidLength(String string) {
            return START_RANGE <= string.length() && string.length() <= END_RANGE;
        }

        public String transformString(String str) {
            StringBuffer stringBuffer = new StringBuffer();

            for (char ch : str.toCharArray()) {
                if (!Character.isAlphabetic(ch)) {
                    stringBuffer.append(ch);
                    continue;
                }
                stringBuffer.append(makeReverseAlphabet(ch).result());
            }

            return stringBuffer.toString();
        }

        public String result() {
            return transformString(value);
        }
    }

    public static ReverseString makeReverseString(String str) {
        return new ReverseString(str);
    }


    public static String solution(String word) {
        return makeReverseString(word).result();
    }

}
