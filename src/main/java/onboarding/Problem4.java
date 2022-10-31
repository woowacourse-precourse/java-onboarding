package onboarding;

public class Problem4 {

    public static void main(String[] args) {
        String word = "I love you";
        String result = "R olev blf";
        System.out.println(solution(word));
    }

    public static String solution(String word) {
        String answer;
        if (word.length() == 0 || word.length() > 1000) {
            return "";
        }
        answer = reverseString(word);

        return answer;
    }

    /**
     * 청개구리의 방식대로 A->z, b->Y 가 출력되도록 하는 함수
     * @param word 입력된 단어
     * @return 청개구리의 방식으로 변경된 단어
     */
    public static String reverseString(String word) {
        StringBuilder reverseWord = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                reverseWord.append((char)('Z' - c + 'A'));
            } else if (c >= 'a' && c <= 'z') {
                reverseWord.append((char)('z' - c + 'a'));
            } else {
                reverseWord.append(c);
            }
        }

        return reverseWord.toString();
    }
}