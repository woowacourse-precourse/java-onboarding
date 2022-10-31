package onboarding.problem4;

public class AlphabetReverser {

    public String reverse(String word) {
        StringBuilder builder = new StringBuilder(word);
        for (int i = 0; i < builder.length(); i++) {
            char alphabet = builder.charAt(i);
            if (Character.isAlphabetic(alphabet)) {
                if (Character.isUpperCase(alphabet))
                    builder.setCharAt(i, (char) (155 - alphabet));
                else if (Character.isLowerCase(alphabet))
                    builder.setCharAt(i, (char) (219 - alphabet));
            }
        }
        return builder.toString();
    }
}
