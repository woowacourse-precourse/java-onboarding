package onboarding;

public class Problem4 {
    //Whether it is alphabet or not using ASCII value
    public static boolean checkAlphabet(char c) {
        boolean b = (64 < c) && (c < 91);
        b = ( (96 < c) && (c < 123) ) || b;

        return b;
    }

    //
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); ++i) {
            char currentAlphabet = word.charAt(i);
            final boolean b = checkAlphabet( currentAlphabet );
            if( b ) {
                //Using the sum of the ASCII values of an alphabet pair
                int accumulatedASCII = (currentAlphabet < 97 ) ? 155 : 219;
                char convertedAlphabet = (char) (accumulatedASCII - currentAlphabet);
                answer += convertedAlphabet;
            }
            else {
                answer += currentAlphabet;
            }
        }
        return answer;
    }
}
