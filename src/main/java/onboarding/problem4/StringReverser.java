package onboarding.problem4;

public class StringReverser {

    public static String reverse(String word){
        StringBuilder sb = new StringBuilder();

        for (char letter : word.toCharArray()) {
            char reversedLetter = LetterReverser.reverseOnlyEnglish(letter);
            sb.append(reversedLetter);
        }
        return sb.toString();
    }
}
