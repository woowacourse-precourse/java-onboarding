package onboarding;

public class Problem4 {

    static StringBuilder sb = new StringBuilder();
    public static String solution(String word) {
        if (wordLengthOutOfRangeException(word)) {
            return word;
        }
        return mergeConvertedCharacters(word);
    }

    public static char upperCaseConversion(char character) {
        return (char) (155 - character);
    }

    public static char lowerCaseConversion(char character) {
        return (char) (219 - character);
    }

    public static String mergeConvertedCharacters(String word) {
        sb.setLength(0);
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = (word.charAt(i) >= 65 && word.charAt(i) <= 90) ? upperCaseConversion(word.charAt(i)) :
                    ((word.charAt(i) >= 97 && word.charAt(i) <= 122) ? lowerCaseConversion(word.charAt(i)) : word.charAt(i));
            sb.append(ch);
            sb.trimToSize();
        }
        return String.valueOf(sb);
    }

    public static boolean wordLengthOutOfRangeException(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            System.out.println("문자열의 길이는 1 ~ 1000자리까지 가능합니다.");
            return true;
        }
        return false;
    }
}