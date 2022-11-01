package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if (!isAlphabet(word.charAt(i))){
                answer += word.charAt(i);
            }
            else if(Character.isUpperCase(word.charAt(i))){
                answer += toReverseUpper(word.charAt(i));
            }
            else if (Character.isLowerCase(word.charAt(i))) {
                answer += toReverseLower(word.charAt(i));
            }
        }
        return answer;
    }
    public static boolean isAlphabet(char letter){
        if (letter >= 'A' && letter <= 'Z' || letter >= 'a' && letter <= 'z'){
            return true;
        }
        return false;
    }
    public static char toReverseUpper(char letter){
        int letterNumber = (int) letter - 65;
        int changeLetterNumber = 90 - letterNumber;
        return (char) changeLetterNumber;
    }
    public static char toReverseLower(char letter){
        int letterNumber = (int) letter - 97;
        int changeLetterNumber = 122 - letterNumber;
        return (char) changeLetterNumber;
    }
}
