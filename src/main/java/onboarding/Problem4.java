package onboarding;

public class Problem4 {

    private final static int UPPERCASE_SUM = 155;
    private final static int LOWERCASE_SUM = 219;

    public static String solution(String word) {
        String answer = changeWord(word);
        return answer;
    }

    private static String changeWord(String word){
        String reverse_Word = "";
        for(char Alphabet : word.toCharArray()) {
            if(Character.isUpperCase(Alphabet))
                reverse_Word += UppercaseChange(Alphabet);
            else if (Character.isLowerCase(Alphabet))
                reverse_Word += LowercaseChange(Alphabet);
            else
                reverse_Word += " ";
        }
        return reverse_Word;
    }
    private static char UppercaseChange(int original){
        char reverseAlphabet = (char)(UPPERCASE_SUM - original);
        return reverseAlphabet;
    }

    private static char LowercaseChange(int original){
        char reverseAlphabet = (char)(LOWERCASE_SUM - original);
        return reverseAlphabet;
    }
}