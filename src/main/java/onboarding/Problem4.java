package onboarding;

public class Problem4 {

    public static boolean isUpperCase(int characterInt) {
        return ((characterInt >= 65) && (characterInt <= 90));
    }

    public static boolean isLowerCase(int characterInt) {
        return ((characterInt >= 97) && (characterInt <= 122));
    }

    public static int getInverseAlphabet(int alphabetInt) {
        if (isUpperCase(alphabetInt)) {
            return 65 + 90 - alphabetInt;
        } else if(isLowerCase(alphabetInt)) {
            return 97 + 122 - alphabetInt;
        }
        return alphabetInt;
    }


    public String getInverseWord(String word) {
        String inverseAlphabetWord = word.chars()
                .map(Problem4::getInverseAlphabet)
                .mapToObj(Character::toString)
                .reduce("", (x, y) -> x + y);
        return inverseAlphabetWord;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
