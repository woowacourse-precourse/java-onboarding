package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static void insertStack(Stack<Character> stack, char c){
        if (!stack.empty() && stack.peek() == c){
            stack.pop();
            return;
        }
        stack.push(c);
    }

}
