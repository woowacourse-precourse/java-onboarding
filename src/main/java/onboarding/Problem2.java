package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static Stack<Character> stringToStack(String string) {
        Stack<Character> stack = new Stack<>();

        for (char letter : string.toCharArray()) {
            stack.add(letter);
        }

        return stack;
    }
}
