package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static int getAscii(int c){
        final int upperVal = 155;
        final int lowerVal = 219;
        final int spaceVal = 32;

        if (65 <= c && c <= 90){
            return upperVal - c;
        }

        if (97 <= c && c <=122){
            return lowerVal - c;
        }
        if (c == spaceVal){
            return spaceVal;
        }
        return -1;
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
