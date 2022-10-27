package onboarding;

public class Problem4 {
    /**
     * 기능 목록
     * 1. 청개구리 사전 배열 선언 (대문자용, 소문자용)
     * 2. word를 한 글자씩 읽으며 소문자인지 대문자인지 판별
     * 3. 대문자이면 대문자 청개구리 사전 참고, 소문자이면 소문자 청개구리 사전 참고 (index)
     *      - 알파벳이 아닌 문자는 변환하지 않는다.
     */
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        String[] dicUpper = {"Z", "Y", "X",	"W", "V", "U", "T", "S", "R", "Q", "P", "O", "N",
                "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
        String[] dicLower = {"z", "y", "x",	"w", "v", "u", "t", "s", "r", "q", "p", "o", "n",
                "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a"};

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                answer.append(dicUpper[word.charAt(i) - 65]);
            } else if (Character.isLowerCase(word.charAt(i))) {
                answer.append(dicLower[word.charAt(i) - 97]);
            } else {
                answer.append(word.charAt(i));
            }
        }

        return answer.toString();
    }
}
