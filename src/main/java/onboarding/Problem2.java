package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> nonDuplicates = decryption(cryptogram);
        answer = concatStack(nonDuplicates);
        return answer;
    }

    private static String concatStack(Stack<Character> nonDuplicates) {
        StringBuilder concatString = new StringBuilder();

        for (Character nonDuplicate : nonDuplicates) {
            concatString.append(nonDuplicate);
        }

        return concatString.toString();
    }

    private static Stack<Character> decryption(String input) {
        Stack<Character> result = new Stack<>();
        int index = 0;

        while (index < input.length()) {
            if (result.isEmpty()) {
                result.push(input.charAt(index));
            }
            else {
                if (result.peek() == input.charAt(index)) {
                    result.pop();
                }
                else {
                    result.push(input.charAt(index));
                }
            }
            index += 1;
        }

        return result;
    }


}
