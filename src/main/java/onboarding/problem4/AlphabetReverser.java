package onboarding.problem4;

public class AlphabetReverser {

    public String reverse(String word) {
        StringBuilder wordBuilder = new StringBuilder(word);
        for (int i = 0; i < wordBuilder.length(); i++) {
            char alphabet = wordBuilder.charAt(i);
            if (Character.isAlphabetic(alphabet)) {
                if (Character.isUpperCase(alphabet))
                    wordBuilder.setCharAt(i, (char) (155 - alphabet));
                else if (Character.isLowerCase(alphabet))
                    wordBuilder.setCharAt(i, (char) (219 - alphabet));
            }
        }
        return wordBuilder.toString();
    }
}
