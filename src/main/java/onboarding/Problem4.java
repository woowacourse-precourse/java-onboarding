package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public boolean isUpperCase(int characterInt) {
        return ((characterInt >= 65) && (characterInt <= 90));
    }

    public boolean isLowerCase(int characterInt) {
        return ((characterInt >= 97) && (characterInt <= 122));
    }

    public int getInverseAlphabet(int alphabetInt) {
        if (isUpperCase(alphabetInt)) {
            return 65 + 90 - alphabetInt;
        } else if(isLowerCase(alphabetInt)) {
            return 97 + 122 - alphabetInt;
        }
        return alphabetInt;
    }
}
