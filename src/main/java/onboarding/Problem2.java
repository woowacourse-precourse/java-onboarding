package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = deleteRepetition(inputLowercaseAlphabets(cryptogram));
        answer = answer.replace("[","");
        answer = answer.replace("]","");
        answer = answer.replace(", ","");

        return answer;
    }

    /* 3 이상 연속된 target 문자열을 2개까지 줄이는 메서드 */
    private static String compressToSizeTwo(String cryptogram, char target) {
        String result = cryptogram;
        String tmp = Character.toString(target);
        String start = tmp.repeat(3);
        String end = tmp.repeat(2);

        while (result.contains(start)) {
            result = result.replace(start,end);
        }

        return result;
    }

    /* 소문자 알파벳의 최대 연속 길이를 2로 만듬 */
    private static String inputLowercaseAlphabets(String cryptogram) {
        String result = cryptogram;

        for (int i = 0; i < 26; i++) {
            result = compressToSizeTwo(result, (char)('a'+i));
        }

        return result;
    }

    /* Stack으로 2개 연속된 문자를 제거 */
    private static String deleteRepetition(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            char tmp = cryptogram.charAt(i);
            boolean checkEmpty = stack.isEmpty();

            if (checkEmpty) {
                stack.push(tmp);
                continue;
            }

            Character topOfStack = stack.peek();
            if (topOfStack != tmp) {
                stack.push(tmp);
                continue;
            }

            stack.pop();
        }

        return stack.toString();
    }
}
