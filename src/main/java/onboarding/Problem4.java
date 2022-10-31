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
        return spaceVal;
    }

}
