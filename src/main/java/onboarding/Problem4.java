package onboarding;

public class Problem4 {
    /**
     * 청개구리가 무엇을 말할지 리턴하는 메서드이다.
     *
     * @param : String, 엄마의 말
     * @return : String, 청개구리의 말
     */
    public static String solution(String word) {
        String answer = changeWord(word);
        return answer;
    }

    /**
     * 엄마의 말을 청개구리의 말로 바꾸는 메서드이다.
     *
     * @param : String, 엄마의 말
     * @return : String, 청개구리의 말
     */
    public static String changeWord(String word) {
        StringBuilder newWord = new StringBuilder();
        for (int idx = 0, size = word.length(); idx < size; idx++) {
            if ('A' <= word.charAt(idx) && word.charAt(idx) <= 'Z') {
                newWord.append((char) ('A' + 'Z' - word.charAt(idx)));
            } else if ('a' <= word.charAt(idx) && word.charAt(idx) <= 'z') {
                newWord.append((char) ('a' + 'z' - word.charAt(idx)));
            } else {
                newWord.append(word.charAt(idx));
            }
        }

        return newWord.toString();
    }
}
