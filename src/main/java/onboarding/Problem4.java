package onboarding;

public class Problem4 {
    public static String solution(String word) {

        if (word.length() < 1 || word.length() > 1000) {
            return "false";
        }

        return convertFrogDictionary(word);
    }

    private static String convertFrogDictionary(String word) {
        StringBuilder sb = new StringBuilder();

        for (char alphabet : word.toCharArray()) {
            char understand = alphabet;

            if (Character.isLowerCase(alphabet)) {
                understand = (char) ('z' - (alphabet - 'a'));
            }
            if (Character.isUpperCase(alphabet)) {
                understand = (char) ('Z' - (alphabet - 'A'));
            }

            sb.append(understand);
        }

        return sb.toString();
    }
}
