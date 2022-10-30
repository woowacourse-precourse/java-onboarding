package onboarding.problem2;


import java.util.Stack;

public class Decryptor {
    PasswordValidator passwordValidator = new PasswordValidator();

    public String decrypt(String password) {
        passwordValidator.validate(password);
        Stack<Character> decryptStack = getDecryptStack(password);

        return mapToString(decryptStack);
    }

    private Stack<Character> getDecryptStack(String password) {
        Stack<Character> stack = new Stack<>();
        int passwordLength = password.length();
        int passwordIndex = 0;

        while (passwordIndex < passwordLength)  {
            char passwordChar = password.charAt(passwordIndex);
            if (isInsertable(stack, passwordChar)) {
                stack.push(passwordChar);
                passwordIndex++;
                continue;
            }

            passwordIndex = skipIndex(password, stack, passwordIndex);
            stack.pop();
        }

        return stack;
    }

    private int skipIndex(String password, Stack<Character> stack, int passwordIndex) {
        while (isSkipCase(password, stack, passwordIndex)) {
            passwordIndex++;
        }
        return passwordIndex;
    }

    private boolean isSkipCase(String password, Stack<Character> stack, int passwordIndex) {
        return passwordIndex < password.length() &&
                password.charAt(passwordIndex) == stack.peek();
    }

    private static boolean isInsertable(Stack<Character> stack, char passwordChar) {
        return stack.isEmpty() || stack.peek() != passwordChar;
    }

    private String mapToString(Stack<Character> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

}
