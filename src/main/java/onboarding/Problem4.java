package onboarding;

import java.util.HashMap;

public class Problem4 {

    public static class Word {
        private String word;
        private final static int A_ASCII = 65;
        private final static int Z_ASCII = 90;
        private final static int a_ASCII = 97;
        private final static int z_ASCII = 122;
        private final static int SPACE_ASCII = 32;


        public Word(String value) {
            this.word = value;
        }

        public String reverse() {
            String result = "";
            for (int i = 0; i < word.length(); i++) {
                result = getSpace(result, i);
                result = convertUppercase(result, i);
                result = convertLowercase(result, i);
            }
            return result;
        }

        private String convertLowercase(String result, int i) {
            if (word.charAt(i) >= a_ASCII && word.charAt(i) <= z_ASCII) {
                result = result + (char) (((z_ASCII - a_ASCII) - (word.charAt(i) - a_ASCII)) + a_ASCII);
            }
            return result;
        }

        private String convertUppercase(String result, int i) {
            if (word.charAt(i) >= A_ASCII && word.charAt(i) <= Z_ASCII) {
                result = result + (char) (((Z_ASCII - A_ASCII) - (word.charAt(i) - A_ASCII)) + A_ASCII);
            }
            return result;
        }

        private String getSpace(String result, int i) {
            if (word.charAt(i) == SPACE_ASCII) {
                result = result + word.charAt(i);
            }
            return result;
        }
    }
    public static String solution(String word) {
        return new Word(word).reverse();
    }
}
