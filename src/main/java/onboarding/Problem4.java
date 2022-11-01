package onboarding;

public class Problem4 {
    public static String solution(String word) {

        char[] eachWord = word.toCharArray();

        StringBuilder answer = new StringBuilder();
        for(int index=0; index < word.length(); index++) {
            int ascii = eachWord[index];
            if(ascii >= 97 && ascii <= 122) answer.append(reverseLower(ascii));
            else if(ascii >= 65 && ascii <= 90) answer.append(reverseUpper(ascii));
            else answer.append(' ');
        }
        return answer.toString();
    }

    private static char reverseUpper(int upperWord) {
        return (char)(90 + (65 - upperWord));
    }

    private static char reverseLower(int lowerWord) {
        return (char)(122 + (97 - lowerWord));
    }
}