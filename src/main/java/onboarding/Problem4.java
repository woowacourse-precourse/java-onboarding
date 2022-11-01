package onboarding;

public class Problem4 {

    private final static int  UPPER_CASE_SUM = 'A'+'Z';
    private final static int  LOWER_CASE_SUM = 'a'+'z';

    public static String solution(String word) {
        String answer = changeWord(word);
        return answer;
    }

    private static String changeWord(String word){
        String reverseWord = "";
        for(char Alphabet : word.toCharArray()) {
            if(Character.isUpperCase(Alphabet))
                reverseWord += changeUppercase(Alphabet);
            else if (Character.isLowerCase(Alphabet))
                reverseWord += changeLowercase(Alphabet);
            else
                reverseWord += " ";
        }
        return reverseWord;
    }
    private static char changeUppercase(int original_Alphabet){
        char reverseAlphabet = (char)(UPPER_CASE_SUM - original_Alphabet);
        return reverseAlphabet;
    }

    private static char changeLowercase(int original_Alphabet){
        char reverseAlphabet = (char)(LOWER_CASE_SUM - original_Alphabet);
        return reverseAlphabet;
    }
}
