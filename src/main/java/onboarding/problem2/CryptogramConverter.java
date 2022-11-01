package onboarding.problem2;

import java.util.Stack;

public class CryptogramConverter {

    private ProblemTwoValidation validation;
    private Stack<String> stack = new Stack<>();

    public CryptogramConverter(ProblemTwoValidation validation) {
        this.validation = validation;

    }

    public void duplicatedWord(String cryptogram) {
        String[] validStringToStringSplit = cryptogram.split("");

        for (String data : validStringToStringSplit) {

            if (!stack.isEmpty() && stack.peek().equals(data)) {
                stack.pop();
                continue;
            }
            stack.add(data);
        }
    }

    public String getConverterWord() {
        return String.join("", stack);
    }

    public void clear() {
        stack.clear();
    }
}
