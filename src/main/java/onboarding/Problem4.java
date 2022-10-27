package onboarding;

public class Problem4 {
    private static final int NO_ALPHABET = 0;
    private static final int LOWER_CASE = -1;
    private static final int UPPER_CASE = 1;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char reverseAlphabet(char alphabet, int alphabetCase) {
        double mid = calculateMidAlphabet(alphabetCase);
        double distanceFromMid = mid - alphabet;
        return (char)(mid + distanceFromMid);
    }

    private static double calculateMidAlphabet(int alphabetCase) {
        if(alphabetCase==UPPER_CASE) {
            return ((double)'A'+'Z')/2;
        }
        return ((double)'a'+'z')/2;
    }

}
