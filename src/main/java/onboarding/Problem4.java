package onboarding;

public class Problem4 {
    public static String solution(String word) {
        Validator.isValidate(word);

        return convertWord(word);
    }

    private static String convertWord(String word){
        char[] charArr = word.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isAlphabetic(word.charAt(i))){
                charArr[i] = convertChar(charArr[i]);
            }
        }
        return new String(charArr);
    }

    private static char convertChar(char ch){
        char convert;
        int div;

        if ('a' <= ch && ch <= 'z'){
            div = 'a' + 'z';
        } else {
            div = 'A' + 'Z';
        }
        convert = (char)(div - ch);
        return convert;
    }

    static class Validator {
        public static boolean isValidate(String word){
            try {
                isCorrectSize(word);
            } catch (Exception error){
                return false;
            }
            return true;
        }

        private static void isCorrectSize(String word){
            if (word.length() < 1 || word.length() > 10000){
                throw new IllegalArgumentException("is wrong size");
            }
        }
    }
}
