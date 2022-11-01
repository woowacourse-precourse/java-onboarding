package onboarding;

public class Problem4 {

    public static String solution(String word) {
        return convertText(word);
    }

    /*
     * 주어진 문자열에 대해 사전을 통해 변환된 문장 전체 반환
     */
    public static String convertText(String text) {
        StringBuilder builder = new StringBuilder();
        for (String word : text.split(" ")) {
            builder.append(convertWord(word) + " ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    /*
     * 주어진 단어에 대해 사전을 통해 변환된 단어 반환
     */
    public static String convertWord(String word) {
        String dictionaryUpperCase = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String dictionaryLowerCase = "zyxwvutsrqponmlkjihgfedcba";
        StringBuilder builder = new StringBuilder();

        for (char c : word.toCharArray()) {
            int charToAscii = c;
            if ((97 <= charToAscii) && (charToAscii <= 122)) {
                char convertedCharacter = dictionaryLowerCase.charAt(charToAscii - ((int) 'a'));
                builder.append(convertedCharacter);
            } else if ((65 <= charToAscii) && (charToAscii <= 90)) {
                char convertedCharacter = dictionaryUpperCase.charAt(charToAscii - ((int) 'A'));
                builder.append(convertedCharacter);
            } else if ((charToAscii < 97) || (charToAscii > 122)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

}
