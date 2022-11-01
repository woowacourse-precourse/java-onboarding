package onboarding;

/**
 * 기능 1. 알파벳을 반대로 반환하는 함수
 */
public class Problem4 {

    public static String solution(String word) {
        return change(word);
    }

    /**
     * 1. 알파벳 반대로 반환 함수
     *
     * @param word
     * @return buffer에 반대로 담은 단어 String으로 반환
     */
    static String change(String word) {
        String[] strings = word.split(" ");
        StringBuffer bf = null;
        for (String str : strings) {
            for (int i = 0; i < str.length(); i++) {
                char chr = str.charAt(i);
                if (65 <= (int) chr && (int) chr <= 90) {
                    bf.append((char) (65 + 90 - (int) chr));
                } else if (97 <= (int) chr && (int) chr <= 122) {
                    bf.append((char) (97 + 122 - (int) chr));
                }
                bf.append(" ");
            }
        }
        return bf.toString();
    }
}
