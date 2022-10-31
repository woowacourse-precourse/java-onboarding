package onboarding;

public class Problem4 {

    private final static int  UPPER_CASE_SUM = 155;
    private final static int  LOWER_CASE_SUM = 219;

    public static String solution(String word) {
        String answer = changeWord(word);
        return answer;
    }

    private static String changeWord(String word){
        String reverse_Word = "";
        for(char Alphabet : word.toCharArray()) {
            if(Character.isUpperCase(Alphabet))
                reverse_Word += changeUppercase(Alphabet);
            else if (Character.isLowerCase(Alphabet))
                reverse_Word += changeLowercase(Alphabet);
            else
                reverse_Word += " ";
        }
        return reverse_Word;
    }
    private static char changeUppercase(int original_Alphabet){
        char reverse_Alphabet = (char)(UPPER_CASE_SUM - original_Alphabet);
        return reverse_Alphabet;
    }

    private static char changeLowercase(int original_Alphabet){
        char reverse_Alphabet = (char)(LOWER_CASE_SUM - original_Alphabet);
        return reverse_Alphabet;
    }
}
