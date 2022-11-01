package onboarding;

public class Problem4 {
    private final static int UPPER_VALUE = 155;
    private final static int LOWER_VALUE = 219;
    private final static int SPACE_VALUE = 32;
    public static String solution(String word) {
        return convertWord(word);
    }

    public static int getAscii(int c){
        if (65 <= c && c <= 90){
            return UPPER_VALUE - c;
        }

        if (97 <= c && c <=122){
            return LOWER_VALUE - c;
        }
        if (c == SPACE_VALUE){
            return SPACE_VALUE;
        }
        return c;
    }
    public static String convertWord(String word){
        return word.chars()
                .map(Problem4::getAscii)
                .filter(i-> i != -1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

}
