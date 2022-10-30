package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        // 아스키코드 'A' == 65 ~ 'Z' == 90, 'a' == 97 ~ 'z' == 122
        // 25차이가 나니까. 문자 - 25를
        // 만약에 'C'라면 67이고 'A'로부터 2가 차이난다. 그러면 90으로부터 -2를 한다.
        char[] array = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (array[i] != ' ' && array[i] <= 90 && 65 <= array[i]) {
                char temp = (char) (array[i] - 'A');
                temp = (char) ('Z' - temp);
                answer.append(temp);
            } else if (array[i] != ' ' && array[i] > 90 && array[i] <= 122) {
                char temp = (char) (array[i] - 'a');
                temp = (char) ('z' - temp);
                answer.append(temp);
            } else {
                answer.append(array[i]);
            }
        }
        return answer.toString();
    }
}
